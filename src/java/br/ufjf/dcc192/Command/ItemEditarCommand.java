package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.Classes.Item;
import br.ufjf.dcc192.DAO.ItensDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class ItemEditarCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/itemEditar.jsp");
        Item  i = ItensDAO.getInstace().getItem(Integer.parseInt(request.getParameter("idItem")));
        request.setAttribute("item", i);
        request.setAttribute("titulo",
                "Revisão de Itens");
        dispachante.forward(request, response);

    }

}
