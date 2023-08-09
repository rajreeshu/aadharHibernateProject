package aadharController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aadharModel.HibernateManager;

@WebServlet("/updateData")
public class UpdateData extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String aadharNo = req.getParameter("aadharNo");
		String changeColumn = req.getParameter("changeColumn");
		String newValue = req.getParameter("newValue");
		
		HibernateManager hbm = new HibernateManager();
		
		hbm.updateData(aadharNo,changeColumn,newValue);
		
		res.sendRedirect("success.html");
	}
}
