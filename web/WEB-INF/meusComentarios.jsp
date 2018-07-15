<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<table border="1">
    <thead>
    <th>Texto</th>
    <th>Data da Criação</th>
    <th>Data da última atualização</th>
    <th>Titulo do Item</th>
    <th>Avaliação do Comentário</th>
</thead>
<tbody>
    <c:forEach var="comentario" items="${comentarios}">
        <tr>
            <td>${comentario.getTexto()}</td>
            <td>${comentario.getDataCriacao()}</td>
            <td>${comentario.getDataAtualizacao()}</td>
            <td>${comentario.getItem().getTitulo()}</td>
            <td>${comentario.getAvaliacao().getLike()}</td>
            <td>
           
                <a href="comentar.html?idItem=${comentario.getItem().getId()}" >Editar Comentário</a>
            
                    <a href="item-comentarios.html?idItem=${comentario.getItem().getId()}" >Exibir Comentários do Item</a>
            </td>
        </tr>
    </c:forEach>
    

        
    
</tbody>

</table>


<%@include file="jspf/rodape.jspf" %>