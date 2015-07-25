/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import estructuras.genericas.NodoLD;

/**
 *
 * @author walter
 */
public class ListaDoble {
    private NodoLD<Objeto> origen, fin;
    private int size;
    
    public ListaDoble(){
        origen = fin = null;
        size = 0;
    }
    
    public void agregar(Objeto elemento){
        size++;
        NodoLD<Objeto>  aux = new NodoLD<>(elemento);
        
        if(!vacia()){
            fin.setSiguiente(aux);
            aux.setAnterior(fin);
            fin = aux;
        }else{
            origen = fin = aux;
        }
    }
    
    public boolean vacia(){
        return origen == null;
    }
}
