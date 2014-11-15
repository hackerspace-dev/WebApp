package pl.hackerspaceDev.webApp.view;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.hackerspaceDev.webApp.service.HelloBean;

@WebServlet({ "/HelloServlet", "/Hello", "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	HelloBean helloBean;//=new HelloBean();
	
    public HelloServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = helloBean.getHello();
		
		System.out.println("Hello from servlet!");
		System.out.println(s);
		response.getWriter().println("Hello from servlet! ");
		response.getWriter().println(s);
		
		
	}

}
