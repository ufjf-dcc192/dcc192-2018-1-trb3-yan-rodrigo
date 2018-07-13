package br.ufjf.dcc192.Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class rankingCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            List<String> itens = new ArrayList<>();
            itens.add("Data de Criação");
            itens.add("Data de Atualização");
            itens.add("Número de Avaliações");
            itens.add("Melhor Avaliação");
            itens.add("Pior Avaliação");
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/buscaItens.jsp");
                request.setAttribute("titulo",
                        "Revisão de Itens");
                request.setAttribute("itens", itens);
                dispachante.forward(request, response);
         
        }

    }

}
