package com.jp.senac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jp.senac.model.Aluno;
import com.mysql.cj.protocol.Resultset;

public class AlunoJDBCdao {
	
	public Connection getConexao() throws ClassNotFoundException { 
		//Driver 
		String driver = "com.mysql.cj.jdbc.Driver";
		
		//Banco de dados
		String url = "jdbc:mysql://localhost:3306/cadastroalunos?useTimezone=true&serverTimezone=UTC";
		
		//Usuario
		String user = "root";
		
		//Senha
		String password = "root";
		
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado ao banco de dados");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public List<Aluno> listarAlunos() throws SQLException {
		List<Aluno> alunos = new ArrayList<>();
		String query = "SELECT * FROM alunos";
		
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String idade = rs.getString(3);
				String semestre = rs.getString(4);
				String genero = rs.getString(5);
				String matricula = rs.getString(6);
				alunos.add(new Aluno(name, idade, semestre, genero, id, matricula));
			}
			rs.close();
			pst.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return alunos;
	}
	
	public Aluno pesquisarPorId(Integer id) {
		String query = "SELECT * FROM alunos WHERE id = ?";
		Aluno aluno = new Aluno();
		try {
			Connection con = getConexao();
	        PreparedStatement pst = con.prepareStatement(query);
	        pst.setInt(1, id); 
	        ResultSet rs = pst.executeQuery();
	        String name = rs.getString(2);
			String idade = rs.getString(3);
			String semestre = rs.getString(4);
			String genero = rs.getString(5);
			String matricula = rs.getString(6);
			aluno.setId(id);
			aluno.setGenero(genero);
			aluno.setIdade(idade);
			aluno.setMatricula(matricula);
			aluno.setNome(name);
			aluno.setSemestre(semestre);
			System.out.println(aluno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aluno;
	}
	
	public Aluno cadastrarAluno(Aluno aluno) {
		String query = "INSERT INTO alunos (nome, idade, semestre, genero, matricula) VALUES (?, ?, ?, ?, ?)";
		try {
			
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, aluno.getNome());
			pst.setString(2, aluno.getIdade());
			pst.setString(3, aluno.getSemestre());
			pst.setString(4, aluno.getGenero());
			pst.setString(5, aluno.getMatricula());
			
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                int idDoAlunoCadastrado = rs.getInt(1);
                aluno.setId(idDoAlunoCadastrado); 
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Aluno Criado");
		System.out.println(aluno.toString());

		
		return aluno;
	}
	
	public void excluirAluno(Aluno aluno) {
		String query = "DELETE FROM alunos WHERE id = ?";
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, aluno.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Aluno alterarAluno(Aluno aluno) {
		
		return null;
	}
}

