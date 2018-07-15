package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.Classes.Item;
import br.ufjf.dcc192.DAO.ItensDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class ItemCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            List<Item> itens = ItensDAO.getInstace().nomesItem();
            
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/buscaTudoItem.jsp");
                request.setAttribute("titulo",
                        "Revisão de Itens");
                request.setAttribute("itens", itens);
                dispachante.forward(request, response);
         
        }

    }

}
