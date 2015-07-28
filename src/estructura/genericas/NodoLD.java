/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura.genericas;

/**
 *
 * @author walter
 */
public class NodoLD <T> {
    private T elemento;
    private NodoLD<T> siguiente;
    private NodoLD<T> anterior;
    
    public NodoLD(T elemento){
        this.elemento = elemento;
        siguiente = anterior = null;
    }
    
    public void setSiguiente(NodoLD<T> siguiente){
        this.siguiente = siguiente;
    }
    
    public void setAnterior(NodoLD<T> anterior){
        this.anterior = anterior;
    }
    
    public NodoLD<T> getSiguiente(){
        return siguiente;
    }
    
    public NodoLD<T> getAnterior(){
        return anterior;
    }
    
    public T getElemento(){
        return elemento;
    }
}
