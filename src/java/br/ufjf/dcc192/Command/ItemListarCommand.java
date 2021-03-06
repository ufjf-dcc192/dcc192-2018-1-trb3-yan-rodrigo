package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.DAO.ItensDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class ItemListarCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            HttpSession session = request.getSession();
            String nome = (String) session.getAttribute("nome");
            if(nome != null && !nome.equals("")){
                request.setAttribute("itens", ItensDAO.getInstace().listAll((int) session.getAttribute("id")));
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/listaItens.jsp");
                request.setAttribute("titulo",
                        "Revisão de Itens");
                dispachante.forward(request, response);
            }else
                response.sendRedirect("login.html");
        }

    }

}
