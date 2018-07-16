<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div>
    <h2>Buscar Item</h2>
    <form method="post">
    <label>Ordenar por: 
        <select name ="itens" >
            <c:forEach var="item" items="${itens}">                
                <option value="${item}">${item}</option>  
            </c:forEach>
        </select>
        <input type="submit" value="Buscar">
        </form>
    </label>

    <%@include file="jspf/rodape.jspf" %>
</div>