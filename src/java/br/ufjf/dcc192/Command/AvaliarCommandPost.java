package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.DAO.AvaliacaoDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class AvaliarCommandPost implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            HttpSession session = request.getSession();
            int idUsuario = (int) session.getAttribute("id");
            int idItem = Integer.parseInt(request.getParameter("idItem"));
            if ("Gostei".equals(request.getParameter("btnGostei")) ||
                    request.getAttribute("btnGostei") == "Gostei") {
                AvaliacaoDAO.getInstace().setAvaliacaoItem(1, idUsuario, idItem);
                
            }else if("Apagar Avaliação".equals(request.getParameter("btnApagar")) || 
                    request.getAttribute("btnApagar") == "Apagar Avaliação" ){
                AvaliacaoDAO.getInstace().setAvaliacaoItem(0, idUsuario, idItem);
            }else{
                AvaliacaoDAO.getInstace().setAvaliacaoItem(-1, idUsuario, idItem);
            }
            response.sendRedirect("ranking.html");;

        }

    }

}
