package pl.hackerspaceDev.webApp.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import pl.hackerspaceDev.webApp.util.Log;

/**
 * Servlet implementation class Rest
 */
@WebServlet({ "/Rest", "/rest" })
public class Rest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		Log.info(request.getParameterMap().keySet());
		Log.info(request.getParameter("parametr"));
		
		JSONObject jsonObject = extractPostData(request);
		
		String nazwa = jsonObject.getString("nazwa");
		nazwa = new StringBuffer(nazwa).reverse().toString();
		jsonObject.put("nazwa", nazwa);
		jsonObject.put("val", 1234);
		
		Log.info(jsonObject);
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) { }
		response.getWriter().println(jsonObject);
	}

	private JSONObject extractPostData(HttpServletRequest request) throws IOException {
		StringBuffer jb = new StringBuffer();
		String line = null;
	    BufferedReader reader = request.getReader();
	    while ((line = reader.readLine()) != null){
	    	jb.append(line);
	    } 
		JSONObject jsonObject = new JSONObject(jb.toString());
		return jsonObject;
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
