<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="jspf/cabecalho.jspf" %>
<html>
    <form method="POST" action="login.html">
    <table border="1">
        <tbody>
            
        <tr>
            <td><h4>Nome de Usuário: </h4></td>
            <td><input type="text" name="txtlogin" value="" size="50" /></td>
        </tr>
        <tr>
            <td><h4>Senha: </h4></td>
            <td><input type="password" name="txtsenha" value="" size="50"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Entrar"/></td>
            </form>
        <form method="get" action="usuario-novo.html">
            <td><input type="submit" value="Cadastrar"/></td>
        </form>
        </tr>        
        </tbody>

    </table>

</html>
<%@include file="jspf/rodape.jspf" %>