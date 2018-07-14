package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.Classes.Comentario;
import br.ufjf.dcc192.Classes.Usuario;
import br.ufjf.dcc192.DAO.ComentarioDAO;
import br.ufjf.dcc192.DAO.ItensDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class comentarCommandPost implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {   
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            HttpSession session = request.getSession();
             
            if(request.getParameter("txtData") != null && !request.getParameter("txtData").equals("")){
                if(!request.getParameter("txtComentario").equals("")){
                    ComentarioDAO.getInstace().editaComentario(request.getParameter("txtComentario"),(int) session.getAttribute("id"),Integer.parseInt(request.getParameter("idItem")));
                }else{
                    ComentarioDAO.getInstace().removeComentario(Integer.parseInt(request.getParameter("idComentario")));
                }
            }else{
                Comentario c = new Comentario((Usuario)session.getAttribute("user"),request.getParameter("txtComentario") , new Date(), new Date(), ItensDAO.getInstace().getItem(Integer.parseInt(request.getParameter("idItem"))),0);
                ComentarioDAO.getInstace().addComentario(c);
            }
                response.sendRedirect("ranking.html");
        }

    }

}
