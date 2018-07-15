package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.Classes.Comentario;
import br.ufjf.dcc192.DAO.AvaliacaoDAO;
import br.ufjf.dcc192.DAO.ComentarioDAO;
import br.ufjf.dcc192.DAO.ItensDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class comentarCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            HttpSession session = request.getSession();
            Comentario c = ComentarioDAO.getInstace().buscaComentario(Integer.parseInt(request.getParameter("idItem")),(int)session.getAttribute("id"));
            if(c != null){
                c.getAvaliacao().setLike(AvaliacaoDAO.getInstace().buscaContaAvaliacao(c.getId()));
            }
            request.setAttribute("comentario",c );
            request.setAttribute("idItem", request.getParameter("idItem"));
            RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/comentarioItem.jsp");
            request.setAttribute("titulo",
                    "Revisão de Itens");
            dispachante.forward(request, response);

        }

    }

}
