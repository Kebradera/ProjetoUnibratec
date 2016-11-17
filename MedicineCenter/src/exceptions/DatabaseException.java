/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author aluno
 */
public class DatabaseException extends Exception{
    public DatabaseException(){
        super();
    } 
    
    public DatabaseException(Exception ex){
        super(ex);
    }
}
