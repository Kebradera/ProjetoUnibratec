/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author l.bezerra.ferreira
 */
public class ParametroInvalidoException extends Exception {
    public ParametroInvalidoException(){
        super();
    } 
    
    public ParametroInvalidoException(Exception ex){
        super(ex);
    }
}
