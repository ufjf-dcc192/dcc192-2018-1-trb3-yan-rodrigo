<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<h2>Todos os Usuários, ordenados por suas notas de avaliação em seus comentários</h2>

<table border="1">
    <thead>
    <th>Nome Usuário</th>
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