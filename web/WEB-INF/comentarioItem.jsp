<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div>
<h2>Dados do meu comentário</h2>
<form method="post" action="comentar.html?idItem=${idItem}">
    
    <label>Data da Criação : ${comentario.getDataCriacao()}</label><br>
    <label>Data da última atualização : ${comentario.getDataAtualizacao()}</label><br>
    <label>Nota de Avaliação : ${comentario.getAvaliacao().getLike()}</label> <br>          
    <input type="hidden" name="txtData" value="${comentario.getDataCriacao()}">
    <input type="hidden" name="idComentario" value="${comentario.getId()}">
    
    <br><h3>Comentário: </h3>
    <textarea name="txtComentario" rows="5" cols="50">${comentario.getTexto()}</textarea><br>
<input type="submit" value="Salvar"/> </label><br>

</form>
</div>
<%@include file="jspf/rodape.jspf" %>