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
import java.util.Date;
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
            AvaliacaoDAO.getInstace().removeAvaliacaoComentario(idItem);
            comando.executeUpdate(String.format("DELETE FROM comentario WHERE id=%d",
                    idItem));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public void removeComentarioItem(int idItem) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM comentario WHERE idITEM=%d",
                    idItem));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addComentario(Comentario c) {
        try {
            Statement comando = conexao.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            comando.executeUpdate("INSERT INTO comentario(texto, datacriacao,dataatualizacao,idusuario,iditem)"
                    + " VALUES('" + c.getTexto()
                    + "','" + sdf.format(c.getDataCriacao())
                    + "','" + sdf.format(c.getDataAtualizacao())
                    + "'," + c.getUsuario().getId()
                    + "," + c.getItem().getId()
                    + ")");
            
            comando.executeUpdate("INSERT INTO avaliacao(curti,dislike,idusuario,idcomentario) VALUES(0,0,"+c.getUsuario().getId()+","+buscaComentario(c.getItem().getId(), c.getUsuario().getId()).getId()+")");
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Comentario buscaComentario(int idItem,int idUsuario) {
        Comentario c = null;
        Item item = ItensDAO.getInstace().getItem(idItem);
        try {

            Statement comando = conexao.createStatement();
            ResultSet resultado2 = comando.executeQuery("SELECT texto,dataCriacao,dataAtualizacao,Avaliacao.idComentario,curti,Dislike,Avaliacao.id,Avaliacao.idusuario from Comentario inner join Avaliacao "
                    + "on Comentario.id = Avaliacao.idComentario "
                    + "WHERE Comentario.iditem ="
                    + idItem + " AND Comentario.idusuario= " +idUsuario);
            if (resultado2.next()) {
                c = new Comentario(
                        UsuarioDAO.getInstace().getUsuario(resultado2.getInt("Avaliacao.idusuario")),
                        resultado2.getString("texto"),
                        resultado2.getDate("dataCriacao"),
                        resultado2.getDate("dataAtualizacao"),
                        item,
                        resultado2.getInt("Avaliacao.idComentario")
                );
                c.setAvaliacao(new Avaliacao(resultado2.getInt("curti"),
                         resultado2.getInt("Dislike"),
                         resultado2.getInt("Avaliacao.id"),
                         item.getUsuario().getId(),
                         item.getId(),
                         resultado2.getInt("Avaliacao.idComentario")));

            }else{
                resultado2 = comando.executeQuery("SELECT * from Comentario"
                    + " WHERE iditem ="
                    + idItem + " AND idusuario= " +idUsuario);
            if (resultado2.next()) {
                c = new Comentario(
                        UsuarioDAO.getInstace().getUsuario(resultado2.getInt("idusuario")),
                        resultado2.getString("texto"),
                        resultado2.getDate("dataCriacao"),
                        resultado2.getDate("dataAtualizacao"),
                        item,
                        resultado2.getInt("id")
                );
                c.setAvaliacao(new Avaliacao(resultado2.getInt("curtir"),
                         resultado2.getInt("Avaliacao.Dislike"),
                         resultado2.getInt("Avaliacao.id"),
                         item.getUsuario().getId(),
                         item.getId(),
                         resultado2.getInt("id")));

            } 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

     public void editaComentario(String texto,int idUsuario,int idItem) {
        try {
            Statement comando = conexao.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            comando.executeUpdate("Update Comentario set texto= '" + texto + "' , "
                    + " dataatualizacao= '" + sdf.format(new Date())
                    + "' where idUsuario =" + idUsuario + " AND idItem =" +idItem);
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ItensDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public ArrayList<Comentario> listComentariosPorData(int idItem) {
        ArrayList<Comentario> comentariosItem = null;
        Item item = ItensDAO.getInstace().getItem(idItem);
        try {
            comentariosItem = new ArrayList<>();
            Statement comando = conexao.createStatement();
            ResultSet resultado2 = comando.executeQuery("SELECT c.texto,c.dataCriacao,c.dataAtualizacao,"
                    + "a.idComentario,a.curti,a.Dislike,a.id,c.idusuario "
                    + "from Comentario as c inner join Avaliacao as a "
                    + "on c.id = a.idComentario "
                    + "WHERE c.iditem ="
                    + idItem + " order by c.datacriacao");
            
            while (resultado2.next()) {
                Comentario c = new Comentario(
                        UsuarioDAO.getInstace().getUsuario(resultado2.getInt("idusuario")),
                        resultado2.getString("texto"),
                        resultado2.getDate("dataCriacao"),
                        resultado2.getDate("dataAtualizacao"),
                        item,
                        resultado2.getInt("idComentario")
                );
                c.setAvaliacao(new Avaliacao(resultado2.getInt("curti"),
                         resultado2.getInt("Dislike"),
                         resultado2.getInt("id"),
                         item.getUsuario().getId(),
                         item.getId(),
                         resultado2.getInt("idComentario")));
                comentariosItem.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comentariosItem;
    }

}
