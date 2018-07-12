<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<form method="POST" action="cadastro.html">
    <table border="1">
        <tbody>
        <c:if test="${usuarioCadastrado}">
                <h1>USUARIO JÁ ESTÁ CADASTRADO NO SISTEMA</h1>
        </c:if>
            <tr>
                <td><h4>Nome Completo: </h4></td>
                <td><input type="text" name="txtNome" value="" size="50" /></td>
            </tr>
            <tr>
            <tr>
                <td><h4>e-mail: </h4></td>
                <td><input type="text" name="txtEmail" value="" size="50" /></td>
            </tr>
            <tr>
                <td><h4>Nome de Usuário: </h4></td>
                <td><input type="text" name="txtLogin" value="" size="50" /></td>
            </tr>
            <tr>
            <tr>
                <td><h4>Senha: </h4></td>
                <td><input type="password" name="txtSenha" value="" size="50"/></td>
            </tr>
                <tr>
                    <td><input type="submit" value="cadastrar"/></td>
                    </form>
                   <form method="get" action="index.html">
                        <td><input type="submit" value="cancelar"/></td>
                   </form>
                   </tr>        
        </tbody>
        
    </table>

<%@include file="jspf/rodape.jspf" %>