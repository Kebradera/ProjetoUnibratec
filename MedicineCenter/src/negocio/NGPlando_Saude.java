package negocio;

import classes_basicas.Plano_Saude;
import dao.IRepositorioPlanoSaude;
import dao.RepositorioPlanoSaude;
import exceptions.DatabaseException;
import java.util.ArrayList;

/**
 *
 * @author macbookwhite
 */
public class NGPlando_Saude {
    IRepositorioPlanoSaude repPlando = new RepositorioPlanoSaude();
    
    public void inserirPlanoSaude(Plano_Saude ps) throws DatabaseException{
        try{
            repPlando.inserir(ps);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public void excluirPlanoSaude(Plano_Saude ps) throws DatabaseException{
        try{
            repPlando.excluir(ps);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public ArrayList<Plano_Saude> listarPlanoSaude(Plano_Saude ps) throws DatabaseException{
        try{
            return repPlando.listar();
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public void alterarPlanoSaude(Plano_Saude ps) throws DatabaseException{
        try{
            repPlando.alterar(ps);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
        
    }
    public ArrayList<Plano_Saude> pesquisar(int cod_plano) throws DatabaseException{     
        try{
            Plano_Saude plano = new Plano_Saude();
            plano.setCod_plano(cod_plano);
            return repPlando.pesquisar(plano);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public ArrayList<Plano_Saude> pesquisarPlanoSaudePorOperadora(String nome_operadora) throws DatabaseException{     
        try{
            return repPlando.pesquisarPorOperadora(nome_operadora);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
}
