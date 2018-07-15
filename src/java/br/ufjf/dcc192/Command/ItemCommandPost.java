package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.DAO.ItensDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class ItemCommandPost implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            request.setAttribute("item",ItensDAO.getInstace().listItem(Integer.parseInt(request.getParameter("itens"))));
            RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/listarbuscaTudoItem.jsp");
            request.setAttribute("titulo",
                    "Revisão de Itens");
            String nome = (String) session.getAttribute("nome");
                if(nome != null && !nome.equals(""))
                    request.setAttribute("logado", true);
                else
                    request.setAttribute("logado", false);
                    dispachante.forward(request, response);
         
        

    }

}
