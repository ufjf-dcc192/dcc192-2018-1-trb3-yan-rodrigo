<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div>
    <h2>Lista dos Meus Coment�rios</h2>
    <table border="1">
    <thead>
    <th>Texto</th>
    <th>Data da Cria��o</th>
    <th>Data da �ltima atualiza��o</th>
    <th>Titulo do Item</th>
    <th>Avalia��o do Coment�rio</th>
    <th>Op��es</th>
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
           
                <a href="comentar.html?idItem=${comentario.getItem().getId()}" >Editar Coment�rio</a>
            
                    <a href="item-comentarios.html?idItem=${comentario.getItem().getId()}" >Exibir Coment�rios do Item</a>
            </td>
        </tr>
    </c:forEach>
    

        
    
</tbody>

</table>

</div>
<%@include file="jspf/rodape.jspf" %>