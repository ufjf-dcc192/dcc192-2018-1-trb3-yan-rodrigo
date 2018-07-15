package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.Classes.Item;
import br.ufjf.dcc192.DAO.ComentarioDAO;
import br.ufjf.dcc192.DAO.ItensDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class MeusComentariosCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String nome = (String) session.getAttribute("nome");
        if(nome != null && !nome.equals("")){
        RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/meusComentarios.jsp");
        int id = (int)session.getAttribute("id");
        request.setAttribute("comentarios", ComentarioDAO.getInstace().meusComentarios(id));
      
        request.setAttribute("titulo",
                "Revisão de Itens");
        dispachante.forward(request, response);
        }else
            response.sendRedirect("login.html");

    }

}
