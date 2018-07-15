package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.DAO.ItensDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class AvaliarCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            int idItem = Integer.parseInt(request.getParameter("idItem"));
            RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/avaliarItem.jsp");
            request.setAttribute("titulo",
                    "Revisão de Itens");
            request.setAttribute("item",ItensDAO.getInstace().getItem(idItem));
            request.setAttribute("idItem",idItem);
            dispachante.forward(request, response);
        }

    }

}
