<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jp.senac.model.Aluno" %>
<%@ page import="java.util.List, com.jp.senac.dao.AlunoJDBCdao" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Aluno</title>
</head>
<body>
<%	if(session.getAttribute("usuario") == null || session == null){
		response.sendRedirect("index.jsp?erro=true");
	}
%>
<%
	int id = (int) request.getAttribute("id");
	AlunoJDBCdao dao = new AlunoJDBCdao();
	Aluno aluno = dao.pesquisarPorId(id);
%>


<h2>Alterar Aluno:</h2>

<form action="ConfirmarAlteracaoServlet" method="post">
	
	<input type="hidden" name="nomeAntigo" value="<%=aluno.getNome() %>">
	
	Nome:
	<input type="text" name="nome" value="<%=aluno.getNome() %>">
	<br><br>
	
	Idade:
	<input type="number" name="idade" value="<%=aluno.getIdade() %>">
	<br><br>
	
	Semestre:
	<select name="semestre">
		<option value="Primeiro" <%=aluno.getSemestre().equals("Primeiro")  ? "selected"  :  ""%>>Primeiro</option>   
		<option value="Segundo" <%=aluno.getSemestre().equals("Segundo")  ? "selected"  :  ""%>>Segundo</option>   
	</select>
	<br><br>
	
	
	Genero:
	<input type="radio" name ="genero" value = "masculino"
	<%=aluno.getGenero().equals("Masculino")? "checked":"" %>>Masculino
	<input type="radio" name ="genero" value = "Feminino"
	<%=aluno.getGenero().equals("Feminino")? "checked":"" %>>Feminino
	<input type="submit" value="Confirmar Alteração">
	<a href="listarAlunos.jsp">Voltar</a>
</form>





</body>
</html>