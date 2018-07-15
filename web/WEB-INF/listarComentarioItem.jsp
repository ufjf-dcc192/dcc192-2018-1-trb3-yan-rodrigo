<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<table border="1">
    <thead>
    <th>Usuario</th>
    <th>Texto</th>
    <th>Data da Cria��o</th>
    <th>Data da �ltima atualiza��o</th>
    <th>Avalia��o</th>
    <th>Avaliar</th>
</thead>
<tbody>
    <c:forEach var="comentario" items="${comentarios}">
        <tr>
            <td>${comentario.getUsuario().getNome()}</td>
            <td>${comentario.getTexto()}</td>
            <td>${comentario.getDataCriacao()}</td>
            <td>${comentario.getDataAtualizacao()}</td>
            <td>${comentario.getAvaliacao().getLike() - comentario.getAvaliacao().getDislike()}</td>
    <form method="post" action="item-comentarios.html?idComentario=${comentario.getId()}&idItem=${idItem}">
        <td>
            <input type="submit" value="Gostei"name="btnGostei"/>
            <input type="submit" value="N�o Gostei" name="btnNaoGostei"/>
            <input type="submit" value="Apagar Avalia��o" name="btnApagar"/>
        </td>
    </form>
</tr>
</c:forEach>
</tbody>

</table>


<%@include file="jspf/rodape.jspf" %>