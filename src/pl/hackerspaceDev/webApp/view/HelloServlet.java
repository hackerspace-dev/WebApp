package pl.hackerspaceDev.webApp.view;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.hackerspaceDev.webApp.service.HelloBean;
import pl.hackerspaceDev.webApp.service.UserService;

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
		
		userService.removeEvenUsers();
		
		System.out.println("Hello from servlet!");
		System.out.println(s);
		response.getWriter().println("Hello from servlet! ");
		response.getWriter().println(s);
		
		
	}

}
