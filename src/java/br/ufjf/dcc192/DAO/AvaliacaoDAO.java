package br.ufjf.dcc192.DAO;

import br.ufjf.dcc192.Classes.Avaliacao;
import br.ufjf.dcc192.Classes.Comentario;
import br.ufjf.dcc192.Classes.Item;
import br.ufjf.dcc192.Classes.Usuario;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AvaliacaoDAO {

    private static AvaliacaoDAO instancia;
    private static Connection conexao;

    public static AvaliacaoDAO getInstace() {
        if (instancia == null) {
            instancia = new AvaliacaoDAO();
        }
        return instancia;
    }

    public AvaliacaoDAO() {
        try {
            if (conexao == null) {
                conexao = DriverManager.
                        getConnection("jdbc:derby://localhost:1527/dcc-192-2018-tbr3",
                                "usuario", "usuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void removeAvaliacaoItem(int idItem) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM Avaliacao WHERE idItem=%d",
                    idItem));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeAvaliacaoComentario(int idItem) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM Avaliacao WHERE idComentario=%d",
                    idItem));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addItem(Item i) {
        try {
            Statement comando = conexao.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            comando.executeUpdate("INSERT INTO Item(titulo, descricao,links,datacriacao,dataatualizacao,idusuario)"
                    + " VALUES('" + i.getTitulo()
                    + "','" + i.getDescricao() + "','" + i.getLink()
                    + "','" + sdf.format(i.getDataCriacao())
                    + "','" + sdf.format(i.getDataAtualizacao())
                    + "'," + i.getUsuario().getId()
                    + ")");
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setAvaliacaoItem(int curtida, int idUsuario, int idItem) {
        try {
            if (curtida == 0) {
                Statement comando = conexao.createStatement();
                comando.executeUpdate(String.format("DELETE FROM Avaliacao WHERE idItem=%d AND idUsuario=%d",
                        idItem, idUsuario));
                comando.close();
            } else if (curtida == 1) {
                //colocar um curtir no banco
                Statement comando = conexao.createStatement();
                comando.executeUpdate("INSERT INTO Avaliacao(curti, dislike,idUsuario,idItem)"
                        + " VALUES(" + 1
                        + "," + 0 + "," + idUsuario
                        + "," + idItem
                        + ")");
                comando.close();
            } else {
                //colocar dislik no banco
                Statement comando = conexao.createStatement();
                comando.executeUpdate("INSERT INTO Avaliacao(curti, dislike,idUsuario,idItem)"
                        + " VALUES(" + 0
                        + "," + 1 + "," + idUsuario
                        + "," + idItem
                        + ")");
                comando.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItensDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
