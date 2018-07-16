<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div>
<h2>Itens Não Comentados:</h2>
<table border="1">
    <thead>
    <th>Titulo</th>
    <th>Descricao</th>
    <th>Data da Criação</th>
    <th>Data da última atualização</th>
    <th>Link</th>
    <th>Avaliação</th>
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
            <td>${item.getNum()}</td>
            <td>
            <c:if test="${logado}">
                <a href="comentar.html?idItem=${item.getId()}" >Comentar</a> 
            </c:if>
                    <a href="item-comentarios.html?idItem=${item.getId()}" >Exibir Comentários</a>
            </td>
        </tr>
    </c:forEach>
    

        
    
</tbody>

</table>

<h2>Itens Não Avaliados:</h2>
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
    <c:forEach var="item" items="${itensAvaliar}">
        <tr>
            <td>${item.getTitulo()}</td>
            <td>${item.getDescricao()}</td>
            <td>${item.getDataCriacao()}</td>
            <td>${item.getDataAtualizacao()}</td>
            <td>${item.getLink()}</td>
           
            <td>
            <c:if test="${logado}">
                <a href="avaliar.html?idItem=${item.getId()}">Avaliar</a>
            </c:if>
            </td>
        </tr>
    </c:forEach>
    

        
    
</tbody>

</table>

        
</div>
<%@include file="jspf/rodape.jspf" %>