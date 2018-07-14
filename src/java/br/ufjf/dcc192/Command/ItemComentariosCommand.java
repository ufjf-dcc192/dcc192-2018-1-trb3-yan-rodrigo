package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.DAO.ComentarioDAO;
import br.ufjf.dcc192.DAO.ItensDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class ItemComentariosCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            HttpSession session = request.getSession();
            request.setAttribute("comentarios", ComentarioDAO.getInstace().listComentariosPorData(Integer.parseInt(request.getParameter("idItem"))));
            request.setAttribute("idItem", request.getParameter("idItem"));
            RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/listarComentarioItem.jsp");
            request.setAttribute("titulo",
                    "Revisão de Itens");
            dispachante.forward(request, response);

        
    }
}