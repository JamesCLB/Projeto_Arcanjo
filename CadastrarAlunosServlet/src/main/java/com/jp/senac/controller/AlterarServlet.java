package com.jp.senac.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.jp.senac.dao.AlunoJDBCdao;
import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AlterarServlet
 */
public class AlterarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		AlunoJDBCdao dao = new AlunoJDBCdao();
		
		// Recuperar a minha sessão
		HttpSession session = request.getSession();
		List<Aluno> listaAlunos = null;
		try {
			listaAlunos = dao.listarAlunos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		// Recuperando o aluno que tem o nome informado (e que deve ser alterado)
		Aluno aluno = null;
		for (Aluno a : listaAlunos) {
			if (a.getId() == id) {
				aluno = a;
			}
		}
		
		request.setAttribute("aluno", aluno);
		request.setAttribute("id", id);
		request.getRequestDispatcher("alterarAluno.jsp").forward(request, response);
		
	}



}
