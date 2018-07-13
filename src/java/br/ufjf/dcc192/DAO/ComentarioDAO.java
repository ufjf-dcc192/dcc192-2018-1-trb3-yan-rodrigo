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

public class ComentarioDAO {

    private static ComentarioDAO instancia;
    private static Connection conexao;

    public static ComentarioDAO getInstace() {
        if (instancia == null) {
            instancia = new ComentarioDAO();
        }
        return instancia;
    }

    public ComentarioDAO() {
        try {
            if (conexao == null) {
                conexao = DriverManager.
                        getConnection("jdbc:derby://localhost:1527/dcc-192-2018-tbr3",
                                "usuario", "usuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Item listItem(int idItem) {
        Item item = null;
        try {
            Statement comando = conexao.createStatement();
            Statement comando2 = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT * from Item WHERE id = " + idItem);
            if (resultado.next()) {
                int i = 0;
                item = new Item();
                item.setId(resultado.getInt("id"));
                item.setDataAtualizacao(resultado.getDate("dataatualizacao"));
                item.setDataCriacao(resultado.getDate("datacriacao"));
                item.setDescricao(resultado.getString("descricao"));
                item.setLink(resultado.getString("links"));
                item.setTitulo(resultado.getString("titulo"));
                item.setUsuario(UsuarioDAO.getInstace().getUsuario(resultado.getInt("idusuario")));
                ResultSet resultado2 = comando2.executeQuery("SELECT *,avaliacao.curti - avaliacao.dislike as curtidas from Comentario inner join Avaliacao "
                        + "on Comentario.id = idComentario "
                        + "WHERE Comentario.iditem ="
                        + item.getId() + " order by curtidas");
                while (resultado2.next() && i < 5) {
                    item.getComentarios().add(new Comentario(
                            UsuarioDAO.getInstace().getUsuario(resultado2.getInt("idusuario")),
                            resultado2.getString("texto"),
                            resultado2.getDate("dataCriacao"),
                            resultado2.getDate("dataAtualizacao"),
                            item,
                            resultado2.getInt("idComentario")
                    ));
                    i++;
                }
                resultado2.close();
                comando2.close();
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }
    
    public List<Item> listAll(int id) {
        List<Item> itens = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            Statement comando2 = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT * from Item WHERE idusuario = " + id);
            while (resultado.next()) {
                Item item = new Item();
                item.setId(resultado.getInt("id"));
                item.setDataAtualizacao(resultado.getDate("dataatualizacao"));
                item.setDataCriacao(resultado.getDate("datacriacao"));
                item.setDescricao(resultado.getString("descricao"));
                item.setLink(resultado.getString("links"));
                item.setTitulo(resultado.getString("titulo"));
                item.setUsuario(UsuarioDAO.getInstace().getUsuario(resultado.getInt("idusuario")));
                ResultSet resultado2 = comando2.executeQuery("SELECT idComentario,texto,datacriacao,dataatualizacao,(avaliacao.curti - avaliacao.dislike) as curtidas from Comentario inner join Avaliacao "
                         + "on Comentario.id = idComentario "
                        + "WHERE Comentario.iditem ="
                        + item.getId() + " order by curtidas");
                while (resultado2.next()) {
                    item.getComentarios().add(new Comentario(
                            UsuarioDAO.getInstace().getUsuario(id),
                            resultado2.getString("texto"),
                            resultado2.getDate("dataCriacao"),
                            resultado2.getDate("dataAtualizacao"),
                            item,
                            resultado2.getInt("idComentario")
                            
                    ));
                     resultado2.close();
                     comando2.close();
                }
                itens.add(item);
            }
            resultado.close();
           
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itens;
    }

    public void removeComentario(int idItem) {
        try {
            Statement comando = conexao.createStatement();
            AvaliacaoDAO.getInstace().removeAvaliacao(idItem);
            comando.executeUpdate(String.format("DELETE FROM comentario WHERE idITEM=%d",
                    idItem));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Comentario> listComentariosPorData(Item item) {
        ArrayList<Comentario> comentariosItem = null;
        try {
            comentariosItem = new ArrayList<>();
            Statement comando = conexao.createStatement();
            ResultSet resultado2 = comando.executeQuery("SELECT * from Comentario inner join Avaliacao "
                    + "on Comentario.id = idComentario "
                    + "WHERE Comentario.iditem ="
                    + item.getId() + " order by datacriacao");
            while (resultado2.next()) {
                Comentario c = new Comentario(
                        UsuarioDAO.getInstace().getUsuario(resultado2.getInt("idusuario")),
                        resultado2.getString("texto"),
                        resultado2.getDate("dataCriacao"),
                        resultado2.getDate("dataAtualizacao"),
                        item,
                        resultado2.getInt("idComentario")
                );
                c.setAvaliacao(new Avaliacao(resultado2.getInt("curtir")
                        , resultado2.getInt("Avaliacao.Dislike")
                        ,resultado2.getInt("Avaliacao.id")
                        , item.getUsuario().getId()
                        , item.getId()  
                        , resultado2.getInt("idComentario")));
                comentariosItem.add(c);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comentariosItem;
    }

}
