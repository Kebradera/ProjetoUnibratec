package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import exceptions.DatabaseException;
/**
 *
 * @author professor
 */
public class GerenciadorConexaoMysql implements IGerenciadorConexao {
    private final String url;
    private final String usuario;
    private final String senha;
    private static GerenciadorConexaoMysql instancia;
            
    private GerenciadorConexaoMysql(){
        ResourceBundle rb = ResourceBundle.getBundle("util.banco");
        url = rb.getString("url");
        usuario = rb.getString("usuario");
        senha = rb.getString("senha");
    }
    
    /**
     * Implementa o padrao Singleton
     * @return Instancia unica da classe
     */
    public static GerenciadorConexaoMysql getInstancia(){
        if(instancia==null){
            instancia = new GerenciadorConexaoMysql();
        }
        return instancia;
    }
    
    @Override
    public Connection conectar()throws DatabaseException{
       Connection c;
       try{
           c = DriverManager.getConnection(url, usuario, senha);
       }catch(SQLException e){
           throw new DatabaseException(e);
       }
       return c;
    }
    
    @Override
    public void desconectar(Connection c)throws DatabaseException{
        try{
            c.close();
        }catch(SQLException e){
            throw new DatabaseException(e);
        }
    }
}
