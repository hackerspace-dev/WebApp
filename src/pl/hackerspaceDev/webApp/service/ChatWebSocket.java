package pl.hackerspaceDev.webApp.service;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import pl.hackerspaceDev.webApp.util.Log;

@ServerEndpoint(value = "/websocket/chat")
public class ChatWebSocket {

    private static final String GUEST_PREFIX = "Guest";
    private static final AtomicInteger connectionIds = new AtomicInteger(0);
    private static final Set<ChatWebSocket> connections =
            new CopyOnWriteArraySet<ChatWebSocket>();

    private String nickname;
    private Session session;

    public ChatWebSocket() {
        nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
    }

    @OnOpen public void start(Session session) {
        this.session = session;
        connections.add(this);
        String message = String.format("* %s %s", nickname, "has joined.");
        broadcast(message);
    }

    @OnClose public void end() {
        connections.remove(this);
        String message = String.format("* %s %s",
                nickname, "has disconnected.");
        broadcast(message);
    }

    @OnMessage public void incoming(String message) {
        // Never trust the client
        String filteredMessage = String.format("%s: %s",
                nickname, message.toString());
        if(message.startsWith("set ")){
        	nickname = message.substring(4); // ustawiam nick
        } else {
        	broadcast(filteredMessage);
        }
    }

    @OnError public void onError(Throwable t) throws Throwable {
    	Log.info("Error for user: " + nickname);
    	Log.info("Chat Error: " + t.toString());
    }


    private void broadcast(String msg) {
        for (ChatWebSocket client : connections) {
            try {
                synchronized (client) {
                	client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
                Log.info("Chat Error: Failed to send message to client "+ e.toString());
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    // Ignore
                }
                String message = String.format("* %s %s",
                        client.nickname, "has been disconnected.");
                broadcast(message);
            }
        }
    }
}