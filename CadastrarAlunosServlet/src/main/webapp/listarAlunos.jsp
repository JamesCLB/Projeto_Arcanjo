<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.jp.senac.model.Aluno" %>
<%@ page import="java.util.List, com.jp.senac.dao.AlunoJDBCdao" %>
<!DOCTYPE html>	
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Alunos</title>
</head>
<body>
<%	if(session.getAttribute("usuario") == null){
	response.sendRedirect("index.jsp?erro=true");
	}
%>
<% String usuario = (String) session.getAttribute("usuario");
	out.print("Bem vindo, "+usuario+"<br>");
%>

Clique <a href="cadastrarAluno.jsp">aqui</a> para cadastrar um novo aluno

<%	AlunoJDBCdao dao = new AlunoJDBCdao();
	
	List<Aluno> listaAlunos = dao.listarAlunos();  %>

<% if (listaAlunos == null) { %>
		<h3>Nenhum aluno cadastrado</h3>
<% } else { %>
		<h2>Alunos cadastrados</h2>
		<table border="1">
			<tr>
				<th>Detalhar</th>
				<th>Nome</th>
				<th>Idade</th>
				<th>Sexo</th>
				<th>Semestre</th>
				<th>Excluir</th>
			</tr>
			<% for (Aluno aluno : listaAlunos) { %>
			<tr>
				<td><a href="DetalharServlet?id=<%=aluno.getId()%>"><%= aluno.getId() %></a></td>
				
				<td><%=aluno.getNome()%> </td>
				<td><%=aluno.getIdade()%> </td>
				<td><%=aluno.getGenero()%> </td>
				<td><%=aluno.getSemestre()%> </td>
				<td><%=aluno.getMatricula()%> </td>
				<td><a href="ExcluirServlet?id=<%=aluno.getId()%>">Excluir</a></td>
			</tr>
			<% } %>
		</table>
<% } %>
	
	<a href="LogoutServlet">Logout</a>
	
</body>
</html>