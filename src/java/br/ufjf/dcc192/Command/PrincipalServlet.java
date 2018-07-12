/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc192.Command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author YanNotebook
 */
@WebServlet(name = "PrincipalServlet", urlPatterns = {"/index.html"
    
})
public class PrincipalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
        rotas.put("/index.html", "br.ufjf.dcc192.Command.IndexCommand");
        
       
    
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
