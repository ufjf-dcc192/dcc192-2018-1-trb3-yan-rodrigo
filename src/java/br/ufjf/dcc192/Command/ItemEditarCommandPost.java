package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.DAO.ItensDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class ItemEditarCommandPost implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
                ItensDAO.getInstace().editaItem(Integer.parseInt(request.getParameter("idItem")),
                        request.getParameter("txtTitulo"),
                        request.getParameter("txtDescricao"), 
                        request.getParameter("txtLink"));
                response.sendRedirect("item-listar.html");
         
        

    }

}
