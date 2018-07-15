package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.DAO.ItensDAO;
import br.ufjf.dcc192.DAO.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class TrollsCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            request.setAttribute("user",UsuarioDAO.getInstace().troll());
            RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/trolls.jsp");
            request.setAttribute("titulo",
                    "Revisão de Itens");
           
                    dispachante.forward(request, response);
         
        

    }

}
