package com.lxitedu.st1610.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxitedu.st1610.service.Impl.RegisterTwoService;
import com.lxitedu.st1610.vo.RegisterVo;

/**
 * Servlet implementation class RegisterParticularServlet
 */
public class RegisterParticularServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterParticularServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String particularId = request.getParameter("particularId");
		RegisterTwoService registerTwoServlet = new RegisterTwoService();
		RegisterVo registerVo= (RegisterVo) registerTwoServlet.personage_particular(particularId);
		request.getSession().setAttribute("registerVo", registerVo);
		response.sendRedirect("registerParticular.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
