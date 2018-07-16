<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div>
    <h2>Novo Item</h2>
    <form method="POST" action="item-novo.html">
    <table border="1">
        <tbody>
        
            <tr>
                <td>Titulo</td>
                <td><input type="text" name="txtTitulo" value="" size="50" /></td>
            </tr>
             <tr>
                <td>Descricao</td>
                <td><input type="text" name="txtDescricao" value="" size="50" /></td>
            </tr>
                <tr>
                    <td><input type="submit" value="Inserir Item"/></td>
                    </form>
                   <form method="get" action="item-listar.html">
                        <td><input type="submit" value="cancelar"/></td>
                   </form>
                   </tr>        
        </tbody>
        
    </table>
<div>
<%@include file="jspf/rodape.jspf" %>