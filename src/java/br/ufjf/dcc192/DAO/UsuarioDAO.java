package br.ufjf.dcc192.DAO;

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

public class UsuarioDAO {

    private static UsuarioDAO instancia;
    private static Connection conexao;

    public static UsuarioDAO getInstace() {
        if (instancia == null) {
            instancia = new UsuarioDAO();
        }
        return instancia;
    }

    public UsuarioDAO() {
        try {
            if (conexao == null) {
                conexao = DriverManager.
                        getConnection("jdbc:derby://localhost:1527/dcc-192-2018-tbr3",
                                "usuario", "usuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Usuario> listAll() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT * from Usuario");
            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setNome(resultado.getString("Nome"));
                usuario.setEmail(resultado.getString("Email"));
                usuario.setSenha(resultado.getString("Senha"));
                usuario.setUsuario(resultado.getString("nomeusuario"));
                usuarios.add(usuario);

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuarios;

    }

    

    public void removeUsuario(String id) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM Usuario WHERE id=%S",
                    id));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    public boolean verificaUsuario(String email, String nomeUsuario){
        boolean existe = false;
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT * from Usuario where Email = '"
                    +email+"' AND nomeUsuario = '"+nomeUsuario+"'");
            if(resultado.next()) {
                existe = true;
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }
    
    public Usuario getUsuario(int id){
       
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT * from Usuario where id = "+id );
            if(resultado.next()) {
                return new Usuario(id, resultado.getString("nome"), resultado.getString("nomeusuario"),
                        resultado.getString("email"), resultado.getString("senha"));
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public List<Usuario> troll(){
        List<Usuario> u = new ArrayList<>();
       
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT sum(curti-dislike) as numCurtidas,Usuario.ID,nome,nomeusuario,email,senha from Usuario inner join comentario on comentario.IDUSUARIO=Usuario.ID inner join avaliacao on avaliacao.IDCOMENTARIO = comentario.ID group by Usuario.id,nome,nomeusuario,email,senha  ");
            while(resultado.next()) {
                if(resultado.getInt("numCurtidas") < 0){
                Usuario user = new Usuario(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("nomeusuario"),
                    resultado.getString("email"), resultado.getString("senha"));
                u.add(user);
                }
                        
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return u;
    }
    
     public List<Usuario> curadores(){
        List<Usuario> u = new ArrayList<>();
       
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT sum(curti-dislike) as numCurtidas,Usuario.ID,nome,nomeusuario,email,senha from Usuario inner join comentario on comentario.IDUSUARIO=Usuario.ID inner join avaliacao on avaliacao.IDCOMENTARIO = comentario.ID group by Usuario.id,nome,nomeusuario,email,senha order by numCurtidas desc");
            while(resultado.next()) {
                Usuario user = new Usuario(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("nomeusuario"),
                    resultado.getString("email"), resultado.getString("senha"));
                u.add(user);         
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return u;
    }
    
    
    
    public void addUsuario(Usuario u) {
        try {
            Statement comando = conexao.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            
            
             comando.executeUpdate("INSERT INTO Usuario(Nome,Email,Senha,nomeusuario) VALUES('"+u.getNome()+
                     "','"+u.getEmail()+"','" + u.getSenha()
                     + "','"+u.getUsuario()+"')");
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Usuario validaUsuario(String username, String password) {
        int id = -1;
        Usuario usuario = null;
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT * from Usuario where nomeUsuario = '"
                    +username+"' AND senha = '"+password+"'");
            if(resultado.next()){
                usuario = new Usuario(resultado.getInt("id"),resultado.getString("nome"),username,
                resultado.getString("email"),password); 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

}
