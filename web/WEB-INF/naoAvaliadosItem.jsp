<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div>
<h2>Itens N�o Comentados:</h2>
<table border="1">
    <thead>
    <th>Titulo</th>
    <th>Descricao</th>
    <th>Data da Cria��o</th>
    <th>Data da �ltima atualiza��o</th>
    <th>Link</th>
    <th>Avalia��o</th>
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
            <td>${item.getNum()}</td>
            <td>
            <c:if test="${logado}">
                <a href="comentar.html?idItem=${item.getId()}" >Comentar</a> 
            </c:if>
                    <a href="item-comentarios.html?idItem=${item.getId()}" >Exibir Coment�rios</a>
            </td>
        </tr>
    </c:forEach>
    

        
    
</tbody>

</table>

<h2>Itens N�o Avaliados:</h2>
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