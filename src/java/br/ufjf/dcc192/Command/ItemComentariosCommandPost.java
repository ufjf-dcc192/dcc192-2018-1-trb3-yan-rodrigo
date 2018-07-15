package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.DAO.AvaliacaoDAO;
import br.ufjf.dcc192.DAO.ComentarioDAO;
import br.ufjf.dcc192.DAO.ItensDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class ItemComentariosCommandPost implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            HttpSession session = request.getSession();
            int idUsuario = (int) session.getAttribute("id");
            int idItem = Integer.parseInt(request.getParameter("idItem"));
            int idComentario = Integer.parseInt(request.getParameter("idComentario"));
            request.setAttribute("comentarios", ComentarioDAO.getInstace().listComentariosPorData(Integer.parseInt(request.getParameter("idItem"))));
            request.setAttribute("idItem", request.getParameter("idItem"));
            RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/listarComentarioItem.jsp");
            request.setAttribute("titulo",
                    "Revisão de Itens");
            if ("Gostei".equals(request.getParameter("btnGostei")) ||
                    request.getAttribute("btnGostei") == "Gostei") {
                AvaliacaoDAO.getInstace().setAvaliacaoComentario(1, idUsuario, idItem, idComentario);
                
            }else if("Apagar Avaliação".equals(request.getParameter("btnApagar")) || 
                    request.getAttribute("btnApagar") == "Apagar Avaliação" ){
                AvaliacaoDAO.getInstace().setAvaliacaoComentario(0, idUsuario, idItem, idComentario);
            }else{
                AvaliacaoDAO.getInstace().setAvaliacaoComentario(-1, idUsuario, idItem, idComentario);
            }
            
            dispachante.forward(request, response);

        
    }
}