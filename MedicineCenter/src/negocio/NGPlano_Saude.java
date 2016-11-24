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
public class NGPlano_Saude {
    IRepositorioPlanoSaude repPlano;

    public NGPlano_Saude() {
        this.repPlano = new RepositorioPlanoSaude();
    }
    
    public void inserirPlanoSaude(Plano_Saude ps) throws DatabaseException{
        try{
            repPlano.inserir(ps);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public void excluirPlanoSaude(Plano_Saude ps) throws DatabaseException{
        try{
            repPlano.excluir(ps);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public ArrayList<Plano_Saude> listarPlanoSaude(Plano_Saude ps) throws DatabaseException{
        try{
            return repPlano.listar();
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public void alterarPlanoSaude(Plano_Saude ps) throws DatabaseException{
        try{
            repPlano.alterar(ps);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
        
    }
    public ArrayList<Plano_Saude> pesquisarPlanoPorCodigo(int cod_plano) throws DatabaseException{     
        try{
            return repPlano.pesquisarPorCodigo(cod_plano);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public ArrayList<Plano_Saude> pesquisarPlanoSaudePorOperadora(String nome_operadora) throws DatabaseException{     
        try{
            return repPlano.pesquisarPorOperadora(nome_operadora);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
}
