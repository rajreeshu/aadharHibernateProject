package aadharController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aadharModel.HibernateManager;

@WebServlet("/deleteData")
public class DeleteData extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String aadharNo = req.getParameter("aadharNo");
		
		
		HibernateManager hbm = new HibernateManager();
		
		hbm.deleteData(aadharNo);
		
		res.sendRedirect("success.html");
	}
}
