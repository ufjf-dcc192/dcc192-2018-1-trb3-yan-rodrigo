package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.DAO.ItensDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class NaoAvaliadosCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            HttpSession session = request.getSession();
            String nome = (String) session.getAttribute("nome");
            if (nome != null && !nome.equals("")) {
                request.setAttribute("logado", true);
            } else {
                request.setAttribute("logado", false);
            }
           
            RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/naoAvaliadosItem.jsp");
            request.setAttribute("titulo",
                    "Revisão de Itens");
            request.setAttribute("itens", ItensDAO.getInstace().naoComentados((int) session.getAttribute("id")));
            request.setAttribute("itensAvaliar", ItensDAO.getInstace().naoAvaliados((int) session.getAttribute("id")));
            dispachante.forward(request, response);
        }

    }

}
