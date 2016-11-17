
package classes_basicas;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Plano_Saude {
    private int cod_plano;
    private String nome_operadora;
    private String telefone;
    private String desc_plano;
    
    private ArrayList<Procedimento> procedimentos;

    /**
     * @return the cod_plano
     */
    public int getCod_plano() {
        return cod_plano;
    }

    /**
     * @param cod_plano the cod_plano to set
     */
    public void setCod_plano(int cod_plano) {
        this.cod_plano = cod_plano;
    }

    /**
     * @return the nome_operadora
     */
    public String getNome_operadora() {
        return nome_operadora;
    }

    /**
     * @param nome_operadora the nome_operadora to set
     */
    public void setNome_operadora(String nome_operadora) {
        this.nome_operadora = nome_operadora;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the desc_plano
     */
    public String getDesc_plano() {
        return desc_plano;
    }

    /**
     * @param desc_plano the desc_plano to set
     */
    public void setDesc_plano(String desc_plano) {
        this.desc_plano = desc_plano;
    }

    /**
     * @return the procedimentos
     */
    public ArrayList<Procedimento> getProcedimentos() {
        return procedimentos;
    }

    /**
     * @param procedimentos the procedimentos to set
     */
    public void setProcedimentos(ArrayList<Procedimento> procedimentos) {
        this.procedimentos = procedimentos;
    }
}
