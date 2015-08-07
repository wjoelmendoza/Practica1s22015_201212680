/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import graphViz.GraphViz;
import estructura.genericas.NodoM;
import java.io.File;


/**
 *
 * @author walter
 */
public class Matriz {
    private NodoM<Cuadrante> origen,fin;
    private int y;
    private int x;
    private GraphViz gv;
    /**
     * construye una matriz de 2 filas y 4 columnas
     */
    public Matriz(){
        y = 2;
        x= 4;
        NodoM<Cuadrante> aux1, nuevo;
        int i;
        for ( i = 0; i < x; i++){
            Cuadrante cua = new Cuadrante();
            cua.setText("" + i + ",0");
            nuevo = new NodoM(cua);
            if(!vacia()){
                fin.setSiguiente(nuevo);
                nuevo.setAnterior(fin);
                fin = nuevo;
            }else
                origen = fin = nuevo;
        }
        aux1 = origen;
        
        for(i = 0; i < x; i++){
            Cuadrante cua = new Cuadrante();
            cua.setText("" + i + ",1" );
            nuevo = new NodoM(cua);
            
            if(i!=0){
                fin.setSiguiente(nuevo);
                nuevo.setAnterior(fin);
                aux1.setArriba(nuevo);
                nuevo.setAbajo(aux1);
                fin = nuevo;
            }else{
                nuevo.setAbajo(aux1);
                aux1.setArriba(nuevo);
                fin = nuevo;
            }
                aux1 = aux1.getSiguiente();
        }
        
    }
    
    /**
     * Este metodo agrega una columna a la derecha de la ultima columna que se 
     * encuentra actualmente en la matris con las y filas que se encuentren en esta
     */
    public void agregarColumna(){
        NodoM<Cuadrante> aux = fin, aux1;
        while(aux.getAbajo()!=null)
            aux = aux.getAbajo();
        
        for(int j =0; j < y; j++){
            Cuadrante cua = new Cuadrante();
            cua.setText("" + x + "," + j);
            aux1 = new NodoM(cua);
            if(j != 0){
                aux.setSiguiente(aux1);
                aux1.setAnterior(aux);
                fin.setArriba(aux1);
                aux1.setAbajo(fin);
                fin = aux1;
            }else{
                aux.setSiguiente(aux1);
                aux1.setAnterior(aux);
                fin = aux1;
            }
            aux = aux.getArriba();
        }
        
        x++;
        
    }
    
    /**
     * Este metodo agrega una fila mas sobre la ultima fila que se encuentre 
     * actualmente en la matriz, con x columnas que se encuentre dentro de esta
     * 
     */
    public void agregarFila(){
        NodoM<Cuadrante> aux = origen,aux1;
        
        while(aux.getArriba() != null)
            aux = aux.getArriba();
        
        
        for(int i = 0; i < x; i++){
            Cuadrante cua = new Cuadrante();
            cua.setText("" + i +"," + y);
            aux1 = new NodoM<>(cua);
            if(i != 0){
                aux1.setAbajo(aux);
                aux.setArriba(aux1);
                fin.setSiguiente(aux1);
                aux1.setAnterior(fin);
                fin = aux1;
            }else{
                aux1.setAbajo(aux);
                aux.setArriba(aux1);
                fin = aux1;
            }
            
            aux = aux.getSiguiente();
        }
        y++;
    }
    /**
     *
     * @return El tamaño de la matriz en x
     */
    public int getX(){
        return x;
    }
    
    /**
     * 
     * @return El tamaño de la matriz en el eje y
     */
    public int getY(){
        return y;
    }
    
    
    /**
     * Este metodo se encarga de graficar con GraphViz como se encuentra
     * estructurada la matriz al momento de llamar este metodo
     */
    public void graficar(){
        int i =0;
        gv = new GraphViz();
        gv.add(gv.start_graph());
        gv.addln("rankdir = BT;");
        gv.addln("rank = same;");
        NodoM<Cuadrante> aux = origen;
        NodoM<Cuadrante> aux2 = origen;
        
        if(origen !=null){
            for(int j = 0; j < y; j++){
                for(int k = 0; k < x; k++){
                    gv.addln("n"+ i +" [ label = \"" + aux.getElemento().getText() + "\"];");
                    i++;
                    aux = aux.getSiguiente();
                }
                aux2 = aux2.getArriba();
                aux = aux2;
            }
            
        }
        addPunterosSi();
        addPunterosAn();
        addPunterosAb();
        addPunterosAr();
        gv.add(";");
        gv.addln(gv.end_graph());
        
        File ext = new File("Matriz.gif");
        gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), "gif"), ext);
    }
    /**
     * metodo auxiliar que agrega los punteros siguientes en la grafica
     */
    private void addPunterosSi(){
        int i = 0;
        for(int j = 0; j < y; j++){
            gv.addln("subgraph sg" + j + "{");
            
            if(i < (x*y) && i > 0)
                gv.add("n" + i);
            
            for(int k = 0; k < x; k++){
                if(j == 0 && k == 0)
                    gv.add("n0");
                else{
                    if(i%x != 0){
                        gv.add("->n" + i);
                    }
                }
                i++;
            }
            gv.addln(";}");
        }
    }
    /**
     * metodo auxiliar que agrega los punteros anteriores a la grafica
     */
    private void addPunterosAn(){
        int i = x*y - 1;
        gv.add("n" + i);
        i--;
        
        for(int j = 0; j < y; j++){
            
            for(int k = 0; k < x; k++){
                if(j==0 && k==0)
                    continue;
                if(k%x != 0)
                  gv.add("->n" + i);
                else if(i > 0)
                    gv.add(";n"+i);
                i--;
            }
            
        }
        
    }
    
    /**
     *metodo auxiliar que agrega los punteros hacia abajo de los nodos en la grafica
     */
    private void addPunterosAb(){
        int i =0, s = 0;
        gv.add(";n0");
        
        for(int j = 0; j < x; j++){
            for(int k = 0; k < (y - 1); k++){
                if(j==0 && k==0)
                    gv.add("->n" + (i+x));
                else
                    gv.add("->n" + (i+x) );
                i += x;
            }
            s++;
            i=s;
            if( i < (x*y) )
                gv.add(";n" + i);
        }
    }
    
    /**
     * metodo auxiliar que agrega los punteros hacia arriba de los nodos en la grafica
     */
    private void addPunterosAr(){
        int i,s;
        i = x*y - 1;
        s = i;
        
        gv.add(";n" + i);
        
        for(int j = 0; j < x; j++){
            for(int k = 0; k < y - 1; k++){
                i -= x;
                if(i > 0){
                    gv.add("->n" + i);
                }else
                    gv.add("->n0");
            }
            s--;
            gv.add(";n"+s);
            i=s;
        }
    }
    
    /**
     * metodo auxiliar que elimina la ultima fila
     */
    private void eliminarUFila(){
        if(!vacia()){
            NodoM<Cuadrante> aux1,aux2;
            aux2 = fin.getAbajo();
            aux1 = fin;
            fin = aux2;
            while(aux1 != null){
                aux1.setAbajo(null);
                aux2.setArriba(null);
                aux1 = aux1.getAnterior();
                aux2 = aux2.getAnterior();
            }
            y--;
        }
    }
    
   /**
    *metodo auxiliar que elimina la primera fila
    */
    private void eliminarPFila(){
        if(y>1){
            NodoM<Cuadrante> aux, aux1;
            aux = origen;
            aux1 = aux.getSiguiente();
            origen = aux;
        
            while( aux != null ){
            
                aux.setSiguiente(null);
                aux1.setAnterior(null);
                aux = aux.getArriba();
                aux1 = aux.getArriba();
            }
        
            y--;
        }else{
            y--;
            origen = fin = null;
        }
            
    }
    
    /**
     * elimina la fila i-1
     * @param i representa graficamente el valor de la fila
     */
    private void eliinarIFila(int i){
        NodoM<Cuadrante> aux, aux1;
        aux = origen;
        
        for(int j = 0; j < i ; j++)
            aux = aux.getArriba();
        
        aux1 = aux.getArriba();
        
        while(aux != null){
            aux1.setAbajo(aux.getAbajo());
            aux.getAbajo().setArriba(aux1);
            aux.setAbajo(null);
            aux.setArriba(null);
            aux = aux.getSiguiente();
            aux1 = aux1.getSiguiente();
        }
        
        y--;
    }
    
    /**
     *metodo auxiliar que elimina la ultima columna
     */
    private void elimarUColumna(){
        if( !vacia()){
            NodoM<Cuadrante> aux1, aux2;
            
            aux1 = fin;
            aux2 = fin.getAnterior();
            fin = aux2;
            while( aux1!= null){
                aux1.setAnterior(null);
                aux2.setSiguiente(null);
                aux1 = aux1.getAbajo();
                aux2 = aux2.getAbajo();
            }
            x--;
        }
    }
    
    /**
     * metodo auxiliar que elimina la primera columna
     */
    private void eliminarPColumna(){
        if(x>1){
            NodoM<Cuadrante> aux1,aux2;
            aux1 = origen;
            aux2 = origen.getSiguiente();
            origen = aux2;
            while(aux1!=null){
                aux1.setSiguiente(null);
                aux2.setAnterior(null);
                aux1 = aux1.getArriba();
                aux2 = aux2.getArriba();
            }
            
            x--;
        }else{
            origen = fin = null;
        }
    }
    
    /**
     * metodo auxiliar que elimina la columna i-1
     */
    private void eliminarIColumna(int i ){
        
        NodoM<Cuadrante> aux1 = origen, aux2;
        
        for(int j=0; j < i-1; j++){
            aux1 = aux1.getSiguiente();
            System.out.println(j);
        }
        
        aux2 = aux1.getSiguiente();
        
        while(aux1!=null){
            aux1.getAnterior().setSiguiente(aux2);
            aux2.setAnterior(aux1.getAnterior());
            aux1.setSiguiente(null);
            aux1.setAnterior(null);
            aux1 = aux1.getArriba();
            aux2 = aux2.getArriba();
        }
        
        x--;
                 
    }
    
    /**
     * verifica si la matriz esta vacia y
     * @return true si la lista no tienen ningun elemento false en otro caso
     */
    public boolean vacia(){
        return origen == null;
    }
    
    /**
     * elimina la columna indice - 1
     * @param indice que se le da graficamente a la columna
     */
    public void eliminarColumna(int indice){
        
        if(indice == 1)
            eliminarPColumna();
        else if(x == indice)
            this.elimarUColumna();
        else if(indice > 1 && indice < x)
            eliminarIColumna(indice);
        else 
            System.err.println("No existe la columna con indice " + indice);
    }
    
    public void eliminarFila(int indice){
        if(indice == 1)
            eliminarPFila();
        else if(indice == x)
            eliminarUFila();
        else if(indice > 1 && indice < x)
            this.eliinarIFila(indice);
        else
            System.err.println("No existe la final con indice " + indice);
        
    }
}
