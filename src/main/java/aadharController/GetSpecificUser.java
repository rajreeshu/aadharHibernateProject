package aadharController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aadharBin.AadharDetail;
import aadharModel.HibernateManager;

@WebServlet("/getSpecificUser")
public class GetSpecificUser extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String aadharNo = req.getParameter("addharNo");
		System.out.println(aadharNo);
		HibernateManager hbm = new HibernateManager();
		AadharDetail user = hbm.getSpecificUser(aadharNo);
		HttpSession session = req.getSession();
		if(user!=null) {
			session.setAttribute("userDetail", user);
			res.sendRedirect("showUser.jsp");
		}else {
			res.sendRedirect("fail.html");
		}
		
		
		
	}
}
