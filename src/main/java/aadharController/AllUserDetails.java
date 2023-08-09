package aadharController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aadharModel.HibernateManager;

@WebServlet("/getAllUser")
public class AllUserDetails extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HibernateManager hbm = new HibernateManager();
		List allUserDetails = hbm.allUserDetails();
		HttpSession session = req.getSession();
		session.setAttribute("allUser", allUserDetails);
		if(allUserDetails==null) {
			res.sendRedirect("fail.html"); 
		}else {
			session.setAttribute("allUser", allUserDetails);
			res.sendRedirect("showAllUsers.jsp");
		}
		
	}
}
