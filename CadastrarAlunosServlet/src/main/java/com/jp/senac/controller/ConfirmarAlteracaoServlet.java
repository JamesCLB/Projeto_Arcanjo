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
 * Servlet implementation class ConfirmarAlteracaoServlet
 */
public class ConfirmarAlteracaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String nome = request.getParameter("nome");
	String idade = request.getParameter("idade");
	String genero = request.getParameter("genero");
	String semestre = request.getParameter("semestre");
	String nomeAntigo = request.getParameter("nomeAntigo");
	
	AlunoJDBCdao dao = new AlunoJDBCdao();
	
	HttpSession session = request.getSession();
	List<Aluno> listaAlunos = null;
	try {
		listaAlunos = dao.listarAlunos();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(Aluno aluno :listaAlunos) {
		if(aluno.getNome().toString().equals(nomeAntigo)) {
			
		}
	}
	session.setAttribute("listaAlunos", listaAlunos);
	request.getRequestDispatcher("listarAlunos.jsp").forward(request, response);
	
	}

}
