package pl.hackerspaceDev.webApp.view;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import pl.hackerspaceDev.webApp.model.User;
import pl.hackerspaceDev.webApp.service.HelloBean;
import pl.hackerspaceDev.webApp.service.UserService;
import pl.hackerspaceDev.webApp.util.Log;

@WebServlet({ "/HelloServlet", "/Hello", "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	HelloBean helloBean;//=new HelloBean();
	
	@EJB
	UserService userService;
	
    public HelloServlet() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = helloBean.getHello();
		
		s+= "\n"+userService.getFirstUser().getName();
		s+= "\n"+userService.getAllUsers();
		
		//logTest
		if(Log.isTraceEnabled()){
			Log.trace("Œlad wywo³añ");
		}
		if(Log.isDebugEnabled()){
			Log.debug("Podgl¹d Wartoœci");
		}
		Log.info("Informacje");
		Log.warn("Ostrze¿enia");
		Log.error("Wyj¹tek");
		Log.fatal("B³¹d niszcz¹cy");
		
		//userService.removeEvenUsers();
		
		Log.info("Hello from servlet!");
		Log.info(s);
		response.getWriter().println("Hello from servlet! ");
		response.getWriter().println(s);
		
		String name = request.getParameter("name");
		userService.createUserWithName(name);

		response.getWriter().println(userService.getEla());
		
		
	}

}
