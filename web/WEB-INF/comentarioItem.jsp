<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div>
<h2>Dados do meu coment�rio</h2>
<form method="post" action="comentar.html?idItem=${idItem}">
    
    <label>Data da Cria��o : ${comentario.getDataCriacao()}</label><br>
    <label>Data da �ltima atualiza��o : ${comentario.getDataAtualizacao()}</label><br>
    <label>Nota de Avalia��o : ${comentario.getAvaliacao().getLike()}</label> <br>          
    <input type="hidden" name="txtData" value="${comentario.getDataCriacao()}">
    <input type="hidden" name="idComentario" value="${comentario.getId()}">
    
    <br><h3>Coment�rio: </h3>
    <textarea name="txtComentario" rows="5" cols="50">${comentario.getTexto()}</textarea><br>
<input type="submit" value="Salvar"/> </label><br>

</form>
</div>
<%@include file="jspf/rodape.jspf" %>