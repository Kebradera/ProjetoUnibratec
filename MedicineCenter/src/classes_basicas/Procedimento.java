
package classes_basicas;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Procedimento {
    private int cod_procedimento;
    private String descricao;
    private String custo_atual;
    
    private ArrayList<Plano_Saude> planos_saude;

    /**
     * @return the cod_procedimento
     */
    public int getCod_procedimento() {
        return cod_procedimento;
    }

    /**
     * @param cod_procedimento the cod_procedimento to set
     */
    public void setCod_procedimento(int cod_procedimento) {
        this.cod_procedimento = cod_procedimento;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the custo_atual
     */
    public String getCusto_atual() {
        return custo_atual;
    }

    /**
     * @param custo_atual the custo_atual to set
     */
    public void setCusto_atual(String custo_atual) {
        this.custo_atual = custo_atual;
    }

    /**
     * @return the planos_saude
     */
    public ArrayList<Plano_Saude> getPlanos_saude() {
        return planos_saude;
    }

    /**
     * @param planos_saude the planos_saude to set
     */
    public void setPlanos_saude(ArrayList<Plano_Saude> planos_saude) {
        this.planos_saude = planos_saude;
    }
}
