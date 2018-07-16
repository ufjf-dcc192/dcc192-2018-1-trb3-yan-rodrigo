<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div>
    <h2>Avaliar Item : ${item.getId()}</h2>
<form method="POST" action="avaliarItem.html?idItem=${param.idItem}">
    <table border="1">
        <tbody>

            <tr>
                <td>Titulo</td>
                <td><input type="text" name="txtTitulo" value="${item.getTitulo()}" size="50" readonly="readonly"/></td>
            </tr>
            <tr>
                <td>Descricao</td>
                <td><input type="text" name="txtDescricao" value="${item.getDescricao()}" size="50" readonly="readonly"/></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="Gostei"name="btnGostei"/>
                    <input type="submit" value="Não Gostei" name="btnNaoGostei"/>
                    <input type="submit" value="Apagar Avaliação" name="btnApagar"/></td>
                </form>
        <form method="get" action="ranking.html">
            <td><input type="submit" value="cancelar"/></td>
        </form>
        </tr>        
        </tbody>

    </table>
                
            </div>

    <%@include file="jspf/rodape.jspf" %>