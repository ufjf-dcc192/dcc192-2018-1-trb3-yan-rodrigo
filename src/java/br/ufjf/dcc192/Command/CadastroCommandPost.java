package br.ufjf.dcc192.Command;

import br.ufjf.dcc192.Classes.Usuario;
import br.ufjf.dcc192.DAO.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CadastroCommandPost implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            String email = request.getParameter("txtEmail");
            String nomeUsuario = request.getParameter("txtLogin");
            if (UsuarioDAO.getInstace().verificaUsuario(email, nomeUsuario)) {
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/cadastro.jsp");
                request.setAttribute("titulo",
                        "Mercado Preso");
                request.setAttribute("usuarioCadastrado", true);
                dispachante.forward(request, response);
            } else {
                Usuario novoUsuario = new Usuario();
                novoUsuario.setNome(request.getParameter("txtNome"));
                novoUsuario.setEmail(email);
                novoUsuario.setSenha(request.getParameter("txtSenha"));
                novoUsuario.setUsuario(nomeUsuario);
                //trocar dps pro jsp de dentro do sistema
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/index.jsp");
                request.setAttribute("titulo",
                        "Mercado Preso");
                UsuarioDAO.getInstace().addUsuario(novoUsuario);
                dispachante.forward(request, response);

            }

        }

    }

}
