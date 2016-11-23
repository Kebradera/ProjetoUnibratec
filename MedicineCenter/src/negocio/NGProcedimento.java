package negocio;


public class NGProcedimento{
    private IRepositorioProcedimento repProc = new RepositorioProcedimento();

    public void inserir(Procedimento proc) throws DatabaseException {
        try{
            repProc.inserir(proc);
        }catch(DatabaseException ex){
            throw new DatabaseException(ex);
        }
    }

    
}