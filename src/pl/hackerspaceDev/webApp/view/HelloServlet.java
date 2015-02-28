package pl.hackerspaceDev.webApp.view;

import java.io.IOException;
import java.security.Principal;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.EJBContext;
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

@WebServlet({ "/HelloServlet", "/Hello", "/hello", "/admin/hello" })
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
		
		//s+= "\n"+userService.getFirstUser().getName();
		s+= "\n"+userService.getAllUsers();
		
		
		//userService.removeEvenUsers();
		
		Log.info("Hello from servlet!");
		Log.info(s);
		response.getWriter().println("path: "+request.getRequestURI());
		response.getWriter().println("Hello from servlet! ");
		response.getWriter().println(s);
		
		String name = request.getParameter("name");
		userService.createUserWithName(name);

		response.getWriter().println(userService.getEla());
		
		
	}

}
