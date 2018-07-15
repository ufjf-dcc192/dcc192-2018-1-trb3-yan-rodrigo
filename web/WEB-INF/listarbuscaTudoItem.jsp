<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<h2>Dados do Item :</h2>
<table border="1">
    <thead>
    <th>Titulo</th>
    <th>Descricao</th>
    <th>Data da Cria��o</th>
    <th>Data da �ltima atualiza��o</th>
    <th>Link</th>
    <th>Avalia��es</th>
    <th>Op��es</th>
</thead>
<tbody>

        <tr>
            <td>${item.getTitulo()}</td>
            <td>${item.getDescricao()}</td>
            <td>${item.getDataCriacao()}</td>
            <td>${item.getDataAtualizacao()}</td>
            <td>${item.getLink()}</td>
            <td>${item.getNum()}</td>
            <td>
            <c:if test="${logado}">
                <a href="comentar.html?idItem=${item.getId()}" >Comentar</a> <a href="avaliar.html?idItem=${item.getId()}">Avaliar</a>
            </c:if>
                    <a href="item-comentarios.html?idItem=${item.getId()}" >Exibir Coment�rios</a>
            </td>
        </tr>
   
    

        
    
</tbody>

</table>
<h3>Os 5 Coment�rios Mais Bem Avaliados:</h3>

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
    <c:forEach var="comentario" items="${item.getComentarios()}">
        <tr>
            <td>${comentario.getUsuario().getNome()}</td>
            <td>${comentario.getTexto()}</td>
            <td>${comentario.getDataCriacao()}</td>
            <td>${comentario.getDataAtualizacao()}</td>
            <td>${comentario.getAvaliacao().getLike()}</td>
            <c:if test="${logado}">
                
    <form method="post" action="item-comentarios.html?idComentario=${comentario.getId()}&idItem=${item.getId()}">
        <td>
            <input type="submit" value="Gostei"name="btnGostei"/>
            <input type="submit" value="N�o Gostei" name="btnNaoGostei"/>
            <input type="submit" value="Apagar Avalia��o" name="btnApagar"/>
        </td>
    </form>
            </c:if>
</tr>
</c:forEach>
</tbody>

</table>

<%@include file="jspf/rodape.jspf" %>