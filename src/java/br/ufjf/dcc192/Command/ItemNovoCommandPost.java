package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.Classes.Item;
import br.ufjf.dcc192.Classes.Usuario;
import br.ufjf.dcc192.DAO.ItensDAO;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class ItemNovoCommandPost implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            HttpSession session = request.getSession();
            Item i = new Item(request.getParameter("txtTitulo"), request.getParameter("txtDescricao"), "Vazio", new Date(), new Date());
            i.setUsuario((Usuario)session.getAttribute("user"));
            ItensDAO.getInstace().addItem(i);
            response.sendRedirect("item-listar.html");
        }

    }

}
