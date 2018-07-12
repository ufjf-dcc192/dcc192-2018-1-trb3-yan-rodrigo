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

}
