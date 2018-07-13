<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<table border="1">
    <thead>
    <th>Titulo</th>
    <th>Descricao</th>
    <th>Data da Cria��o</th>
    <th>Data da �ltima atualiza��o</th>
    <th>Link</th>
    <th>Op��es</th>
</thead>
<tbody>
    <c:forEach var="item" items="${itens}">
        <tr>
            <td>${item.getTitulo()}</td>
            <td>${item.getDescricao()}</td>
            <td>${item.getDataCriacao()}</td>
            <td>${item.getDataAtualizacao()}</td>
            <td>${item.getLink()}</td>
            <c:if test="${logado}">
                <td><a href="comentar.html?idItem=${item.getId()}" >Comentar</a> <a href="avaliar.html?idItem=${item.getId()}">Avaliar</a></td>
            </c:if>
        </tr>
    </c:forEach>
    

        
    
</tbody>

</table>


<%@include file="jspf/rodape.jspf" %>