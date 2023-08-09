package aadharController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aadharBin.AadharDetail;
import aadharModel.HibernateManager;

@WebServlet("/register")
public class RegisterUser extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String aadharNo = req.getParameter("aadhar_no");
		String name = req.getParameter("name");
		String fatherName = req.getParameter("father_name");
		int age = Integer.parseInt(req.getParameter("age"));
		String address = req.getParameter("address");
		String phoneNo = req.getParameter("phone_no");
		String email = req.getParameter("email");

		// Create an AadharDetail object
		AadharDetail aadharDetail = new AadharDetail();
		aadharDetail.setAadharNo(aadharNo);
		aadharDetail.setName(name);
		aadharDetail.setFatherName(fatherName);
		aadharDetail.setAge(age);
		aadharDetail.setAddress(address);
		aadharDetail.setPhoneNo(phoneNo);
		aadharDetail.setEmail(email);
		
		HibernateManager hbm = new HibernateManager();
		boolean isRegistered = hbm.register(aadharDetail);
		if(isRegistered) {
			res.sendRedirect("success.html");
		}else {
			res.sendRedirect("fail.html");
		}
	}
}
