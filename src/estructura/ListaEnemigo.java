/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import estructura.genericas.NodoLD;

/**
 *
 * @author walter
 */
public class ListaEnemigo {
    
    private NodoLD<Goomba> origen , fin;
    private boolean hilosact;
    
    public ListaEnemigo(){
        hilosact = false;
        origen = fin = null;
    }
    
    public void addEnemigo(Goomba nuevo){
        NodoLD<Goomba> nuevold = new NodoLD<>(nuevo);
        if(!vacia()){
            fin.setSiguiente(nuevold);
            nuevold.setAnterior(fin);
            fin = nuevold;
        }else
            origen = fin = nuevold;
    }
    
    public boolean  vacia(){
        return origen == null;
    }
    
    public void activarHilos(){
        if(!vacia()&&!hilosact){
            NodoLD<Goomba> aux = origen;
            Goomba auxg;
            while(aux != null){
                auxg = aux.getElemento();
                new Thread(auxg).start();
                aux = aux.getSiguiente();
            }
            hilosact = true;
        }else
            System.out.println("lista vacia o hilos activos");
    }
    
    public void pausarHilos(){
        if(!vacia()){
            NodoLD<Goomba> aux = origen;
            Goomba auxg;
            while(aux!= null){
                auxg = aux.getElemento();
                auxg.setPlay(false);
                aux = aux.getSiguiente();
            }
        }else{
            System.out.println("lista vacia");
        }
    }
    
    public void continuarHilos(){
        if(!vacia()){
            NodoLD<Goomba> aux = origen;
            Goomba auxg;
            while(aux!=null){
                auxg = aux.getElemento();
                auxg.setPlay(true);
                aux = aux.getSiguiente();
            }
        }else{
            System.out.println("lista esta vacia");
        }
    }
}
