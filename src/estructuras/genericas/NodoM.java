/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.genericas;

/**
 *
 * @author walter
 */
public class NodoM <T> {
    private T elemento;
    private NodoM<T> siguiente;
    private NodoM<T> anterior;
    private NodoM<T> arriba;
    private NodoM<T> abajo;
    
    public NodoM(T elemento){
        this.elemento = elemento;
        siguiente = anterior = arriba = abajo=null;
    }
    
    public void setAbajo(NodoM<T> abajo){
        this.abajo = abajo;
    }
    
    public void setAnterior(NodoM<T> anterior){
        this.anterior = anterior;
    }
    
    public void setArriba(NodoM<T> arriba){
        this.arriba = arriba;
    }
    
    public void setSiguiente(NodoM<T> siguiente){
        this.siguiente = siguiente;
    }
    
    public NodoM<T> getAbajo(){
        return abajo;
    }
    
    public NodoM<T> getAnterior(){
        return anterior;
    }
    
    public NodoM<T> getArriba(){
        return arriba;
    }
    
    public NodoM<T> getSiguiente(){
        return siguiente;
    }
    
    public T getElemento(){
        return elemento;
    }
}
