<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<form method="post">
    <label>Selecione o Item a exibir: 
        <select name ="itens" >
            <c:forEach var="item" items="${itens}">                
                <option value="${item.getId()}">${item.getId()} - ${item.getTitulo()}</option>  
            </c:forEach>
        </select>
        <input type="submit" value="Buscar">
        </form>
    </label>

    <%@include file="jspf/rodape.jspf" %>