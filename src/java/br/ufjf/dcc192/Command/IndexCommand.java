package br.ufjf.dcc192.Command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class IndexCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/index.jsp");
                request.setAttribute("titulo",
                        "Mercado Preso");
                dispachante.forward(request, response);
         
        }

    }

}
