<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<h2>Editar Item ${param.idItem}</h2>
<form method="Post" action="item-editar.html?idItem=${item.getId()}">
    <table border="1">
        <tbody>
            <tr>
                <td><h4>Titulo: </h4></td>
                <td><input type="text" name="txtTitulo" value="${item.getTitulo()}" /></td>
            </tr>
            <tr>
            <tr>
                <td><h4>Descrição: </h4></td>
                <td><input type="text" name="txtDescricao" value="${item.getDescricao()}" /></td>
            </tr>
            <tr>
            <tr>
                <td><h4>Links??: </h4></td>
                <td><input type="text" name="txtLink" value="${item.getLink()}" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Salvar Edição"/></td>
                </form>
                  <form method="get" action="item-listar.html">
                        <td><input type="submit" value="cancelar"/></td>
                   </form>
                 
            </tr>        
        </tbody>

    </table>

    <%@include file="jspf/rodape.jspf" %>
