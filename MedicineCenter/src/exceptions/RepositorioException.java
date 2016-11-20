/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Skywalker
 */
public class RepositorioException extends Exception{
    public RepositorioException(){
        super();
    } 
    
    public RepositorioException(Exception ex){
        super(ex);
    }
}
