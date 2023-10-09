package com.jp.senac.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import com.jp.senac.dao.AlunoJDBCdao;
import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ConfirmarCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recuperando a sessão
		HttpSession session = request.getSession();
		
		// Recuperando os valores informados
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		String genero = request.getParameter("genero");
		String semestre = request.getParameter("semestre");
		String semestreAtual = "";

		// Recuperando a lista da sessão, caso não exista, cria
		AlunoJDBCdao dao = new AlunoJDBCdao();
		List<Aluno> listaAlunos = null;
		try {
			listaAlunos = dao.listarAlunos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Calendar calendario = Calendar.getInstance();
		int anoAtual = calendario.get(Calendar.YEAR);
		int mesAtual = calendario.get(Calendar.MONTH) + 1;
		if(mesAtual > 6) {
			semestreAtual = "02";
		}else {
			semestreAtual = "01";
		}
		int[] valoresAle = new int[4];
		Random aleatorio = new Random();
		for(int i = 0; i < valoresAle.length; i++) {
			int nAle = aleatorio.nextInt(9) + 1;
			valoresAle[i] = nAle;
		}
		String matriCorreta = "";
		for (int i : valoresAle) {
			matriCorreta += i;
		}
		String SanoAtual = Integer.toString(anoAtual);
		String SmesAtual = Integer.toString(mesAtual);
		String matricula = SanoAtual + SmesAtual + semestreAtual + idade + matriCorreta;
		
		Aluno aluno = new Aluno(nome, idade, semestre, genero, matricula);
		Aluno alunoCadastrado = dao.cadastrarAluno(aluno);
		
		// Adicionando aluno na lista (INSERT)
		listaAlunos.add(alunoCadastrado);
		
		session.setAttribute("listaAlunos", listaAlunos);
		request.setAttribute("aluno", alunoCadastrado);
		
		// Encaminhar a requisição para o JSP
		request.getRequestDispatcher("detalharAluno.jsp").forward(request, response);
		
		
		
		
		
		
		
	}

}
