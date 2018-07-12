<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<table border="1">
    <thead>
    <th>Titulo</th>
    <th>Descricao</th>
    <th>Data da Criação</th>
    <th>Data da última atualização</th>
</thead>
<tbody>
    <c:forEach var="item" items="${itens}">
        <tr>
            <td>${item.getTitulo()}</td>
            <td>${item.getDescricao()}</td>
            <td>${item.getDataCriacao()}</td>
            <td>${item.getDataAtualizacao()}</td>
            <td><a href="item-editar.html">Editar</a> <a href="item-excluir.html">Excluir</a></td>
        </tr>
    </c:forEach>
    

        <td><a href="item-novo.html"/>Novo Item<a></td>
    
</tbody>

</table>


<%@include file="jspf/rodape.jspf" %>