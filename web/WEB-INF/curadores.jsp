<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<h2>Todos os Usu�rios, ordenados por suas notas de avalia��o em seus coment�rios</h2>

<table border="1">
    <thead>
    <th>Nome Usu�rio</th>
    <th>Nome</th>
    <th>E-mail</th>
    
</thead>
<tbody>
    <c:forEach var="user" items="${user}">
        <tr>
            <td>${user.getUsuario()}</td>
            <td>${user.getNome()}</td>
            <td>${user.getEmail()}</td>
           
           
        </tr>
    </c:forEach>
    

        
    
</tbody>

</table>


<%@include file="jspf/rodape.jspf" %>