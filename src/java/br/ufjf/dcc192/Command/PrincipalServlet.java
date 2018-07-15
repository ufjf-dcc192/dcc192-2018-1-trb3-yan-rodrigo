/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc192.Command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author YanNotebook
 */
@WebServlet(name = "PrincipalServlet", urlPatterns = {"/index.html",
    "/usuario-novo.html", "/cadastro.html","/login.html","/logout.html","/item-listar.html",
    "/item-novo.html","/item-excluir.html","/item-editar.html","/ranking.html","/item-ordena-listar.html",
    "/comentar.html","/item-comentarios.html" , "/avaliar.html"
    ,"/avaliarItem.html"
})
public class PrincipalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
        rotas.put("/index.html", "br.ufjf.dcc192.Command.IndexCommand");
        rotas.put("/usuario-novo.html", "br.ufjf.dcc192.Command.CadastroCommand");
        rotas.put("/login.html", "br.ufjf.dcc192.Command.LoginCommand");
        rotas.put("/logout.html", "br.ufjf.dcc192.Command.LogoutCommand");
        rotas.put("/item-listar.html", "br.ufjf.dcc192.Command.ItemListarCommand");
        rotas.put("/item-novo.html", "br.ufjf.dcc192.Command.ItemNovoCommand");
        rotas.put("/item-excluir.html", "br.ufjf.dcc192.Command.ItemExcluirCommand");
        rotas.put("/item-editar.html", "br.ufjf.dcc192.Command.ItemEditarCommand");
        rotas.put("/item-ordena-listar.html", "br.ufjf.dcc192.Command.ItemBuscarCommand");
        rotas.put("/item-comentarios.html", "br.ufjf.dcc192.Command.ItemComentariosCommand");
        rotas.put("/ranking.html", "br.ufjf.dcc192.Command.rankingCommand");
        rotas.put("/comentar.html", "br.ufjf.dcc192.Command.comentarCommand");
        rotas.put("/avaliar.html", "br.ufjf.dcc192.Command.AvaliarCommand");
        
       
    
        String clazzName = rotas.get(request.getServletPath());
        try {
            Command comando = (Command) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException ex) {
            response.sendError(500, "erro.  " + ex);
            Logger.getLogger(PrincipalServlet.class.getName()).log(Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            Logger.getLogger(PrincipalServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PrincipalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
        rotas.put("/index.html", "br.ufjf.dcc192.Command.IndexCommand");     
        rotas.put("/cadastro.html", "br.ufjf.dcc192.Command.CadastroCommandPost");     
        rotas.put("/login.html", "br.ufjf.dcc192.Command.LoginCommandPost");    
        rotas.put("/item-novo.html", "br.ufjf.dcc192.Command.ItemNovoCommandPost");
        rotas.put("/item-editar.html", "br.ufjf.dcc192.Command.ItemEditarCommandPost");
        rotas.put("/ranking.html", "br.ufjf.dcc192.Command.rankingCommandPost");
        rotas.put("/comentar.html", "br.ufjf.dcc192.Command.comentarCommandPost");
        rotas.put("/avaliarItem.html", "br.ufjf.dcc192.Command.AvaliarCommandPost");
        
    
        String clazzName = rotas.get(request.getServletPath());
        try {
            Command comando = (Command) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException ex) {
            response.sendError(500, "erro.  " + ex);
            Logger.getLogger(PrincipalServlet.class.getName()).log(Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            Logger.getLogger(PrincipalServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PrincipalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
