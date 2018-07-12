package br.ufjf.dcc192.Command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CadastroCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/cadastro.jsp");
                request.setAttribute("titulo",
                        "Mercado Preso");
                request.setAttribute("usuarioCadastrado", false);
                
                dispachante.forward(request, response);
         
        }

    }

}
