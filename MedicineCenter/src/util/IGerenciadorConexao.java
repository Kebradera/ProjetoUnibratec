
package util;
import exceptions.DatabaseException;
import java.sql.Connection;
/**
 *
 * @author aluno
 */
public interface IGerenciadorConexao {
    /**
     * Estabelece conexao com o BD
     * @return Objeto de Conexao
     * @throws meuprimeiroprojeto.erro.ConexaoException
     */
    public Connection conectar()throws DatabaseException;
    
    /**
     * Encerra uma conexao com o BD
     * @param c Objeto da cenexao a ser fechada
     * @throws meuprimeiroprojeto.erro.ConexaoException
     */
    public void desconectar(Connection c)throws DatabaseException;   
}
