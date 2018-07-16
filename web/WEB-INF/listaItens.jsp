<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div>
    <h2>Lista dos Meus Itens</h2>
<table border="1">
    <thead>
    <th>Titulo</th>
    <th>Descricao</th>
    <th>Data da Criação</th>
    <th>Data da última atualização</th>
    <th>Link</th>
    <th>Opções</th>
</thead>
<tbody>
    <c:forEach var="item" items="${itens}">
        <tr>
            <td>${item.getTitulo()}</td>
            <td>${item.getDescricao()}</td>
            <td>${item.getDataCriacao()}</td>
            <td>${item.getDataAtualizacao()}</td>
            <td>${item.getLink()}</td>
            <td><a href="item-editar.html?idItem=${item.getId()}" >Editar</a> <a href="item-excluir.html?idItem=${item.getId()}">Excluir</a></td>
        </tr>
    </c:forEach>
    

        <td><a href="item-novo.html"/>Novo Item<a></td>
    
</tbody>

</table>


</div>
<%@include file="jspf/rodape.jspf" %>