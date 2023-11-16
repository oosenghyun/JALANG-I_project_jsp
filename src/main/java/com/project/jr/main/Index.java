package com.project.jr.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.model.CrtDTO;
import com.project.jr.crt.repository.CrtDAO;

@WebServlet("/index.do")
public class Index extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//자격증 top 100
		CrtDAO cdao = new CrtDAO();
		ArrayList<CrtDTO> clist = cdao.getTop100();
		req.setAttribute("clist", clist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(req, resp);

	}	
	
}