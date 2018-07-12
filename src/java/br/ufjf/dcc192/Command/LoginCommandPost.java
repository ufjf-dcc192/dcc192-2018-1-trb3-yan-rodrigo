/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.Classes.Usuario;
import br.ufjf.dcc192.DAO.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rodri
 */
public class LoginCommandPost implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            
                String username = request.getParameter("txtlogin");
                String password = request.getParameter("txtsenha");
                Usuario usuario = UsuarioDAO.getInstace().validaUsuario(username, password);
                if (usuario != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("id", usuario.getId());
                    session.setAttribute("nome", usuario.getNome());
                    response.sendRedirect("index.html");
                   
                } else {
                    response.sendRedirect("login.html?fail=1");
                    
                }
                
            
        }

    }

}
