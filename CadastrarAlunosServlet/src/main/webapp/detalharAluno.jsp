<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jp.senac.model.Aluno" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Informações do Aluno</title>
</head>
<body>

<%	if(session.getAttribute("usuario") == null || session == null){
		response.sendRedirect("index.jsp?erro=true");
	}
%>
	

<% Aluno aluno = (Aluno) request.getAttribute("aluno");%>

<h2> Aluno Cadastrado</h2>

Nome: <%=aluno.getNome()%>
<br><br>

Idade: <%=aluno.getIdade()%>
<br><br>

Genero: <%=aluno.getGenero()%>
<br><br>

Semestre: <%=aluno.getSemestre()%>
<br><br>

Matricula: <%=aluno.getMatricula()%>
<br><br>

<input type="button" onclick="javascript:location.href='listarAlunos.jsp'"  value="Confirmar"> 
<a href="AlterarServlet?id=<%=aluno.getId()%>">Alterar</a>






</body>
</html>