/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import constantes.EConstantes;
import graphViz.GraphViz;
import estructura.genericas.NodoM;
import java.io.File;


/**
 *
 * @author walter
 */
public class Matriz {
    private ListaEnemigo le;
    private NodoM<Cuadro> origen,fin;
    private Heroe mario;
    private int y;
    private int x;
    private GraphViz gv;
    private ListaDoble ld;
    /**
     * construye una matriz de 2 filas y 4 columnas
     * @param ld
     */
    public Matriz(ListaDoble ld){
        le = new ListaEnemigo();
        this.ld = ld;
        y = 2;
        x= 4;
        NodoM<Cuadro> aux1, nuevo;
        int i;
        for ( i = 0; i < x; i++){
            Cuadro cua = new Cuadro(this.ld);
            nuevo = new NodoM(cua);
            cua.setPos(nuevo);
            if(!vacia()){
                fin.setSiguiente(nuevo);
                nuevo.setAnterior(fin);
                fin = nuevo;
            }else
                origen = fin = nuevo;
        }
        aux1 = origen;
        
        for(i = 0; i < x; i++){
            Cuadro cua = new Cuadro(this.ld);
            nuevo = new NodoM(cua);
            cua.setPos(nuevo);
            
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
        if(!vacia()){
            if( y > 0){
                NodoM<Cuadro> aux = fin, aux1;
                while(aux.getAbajo()!=null)
                    aux = aux.getAbajo();
        
                for(int j =0; j < y; j++){
                    Cuadro cua = new Cuadro(this.ld);
                    cua.setPos(aux);
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
            }else{
                x++;
                Cuadro nuevo = new Cuadro(this.ld);
                NodoM<Cuadro> cua =new NodoM<>(nuevo);
                nuevo.setPos(cua);
                cua.setAnterior(fin);
                fin.setSiguiente(cua);
                fin = cua;
                
            }
        }else{
            x++;
            y++;
            Cuadro nuevo = new Cuadro(this.ld);
            NodoM<Cuadro> nu = new NodoM<>(nuevo);
            nuevo.setPos(nu);
            origen = fin = nu;
        }
        
    }
    
    /**
     * Este metodo agrega una fila mas sobre la ultima fila que se encuentre 
     * actualmente en la matriz, con x columnas que se encuentre dentro de esta
     * 
     */
    public void agregarFila(){
        if(!vacia()){
            if(x>0){
                NodoM<Cuadro> aux = origen,aux1;
        
                while(aux.getArriba() != null)
                    aux = aux.getArriba();
        
                for(int i = 0; i < x; i++){
                    Cuadro cua = new Cuadro(this.ld);
                    aux1 = new NodoM<>(cua);
                    cua.setPos(aux);
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
            }else{
                y++;
                Cuadro nuevo = new Cuadro(this.ld);
                NodoM<Cuadro> cua =new NodoM<>(nuevo);
                nuevo.setPos(cua);
                cua.setAbajo(fin);
                fin.setArriba(cua);
                fin = cua;
            }
        }else{
            y++;
            x++;
            Cuadro nuevo = new Cuadro(this.ld);
            NodoM<Cuadro> nu = new NodoM<>(nuevo);
            nuevo.setPos(nu);
            origen = fin = nu;
        }
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
        NodoM<Cuadro> aux = origen;
        NodoM<Cuadro> aux2 = origen;
        
        if(origen !=null){
            for(int j = 0; j < y; j++){
                for(int k = 0; k < x; k++){
                    gv.addln("n"+ i +" [ label = \"" + aux.getElemento().graf()+ "\"];");
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
        
        File ext = new File("Matriz.png");
        gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), "png"), ext);
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
            NodoM<Cuadro> aux1,aux2;
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
        if(y > 1){
            NodoM<Cuadro> aux, aux1;
            aux = origen;
            aux1 = aux.getArriba();
            origen = aux1;
        
            while( aux != null ){
            
                aux.setArriba(null);
                aux1.setAbajo(null);
                aux = aux.getSiguiente();
                aux1 = aux1.getSiguiente();
            }
            
            y--;
        }else{
            y--;
            x=0;
            origen = fin = null;
        }
            
    }
    
    /**
     * elimina la fila i-1
     * @param i representa graficamente el valor de la fila
     */
    private void eliminarIFila(int i){
        NodoM<Cuadro> aux, aux1;
        aux = origen;
        
        for(int j = 0; j < i - 1 ; j++)
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
            NodoM<Cuadro> aux1, aux2;
            
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
            NodoM<Cuadro> aux1,aux2;
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
            x--;
            y=0;
            origen = fin = null;
        }
    }
    
    /**
     * metodo auxiliar que elimina la columna i-1
     */
    private void eliminarIColumna(int i ){
        
        NodoM<Cuadro> aux1 = origen, aux2;
        
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
        else if(indice == y)
            eliminarUFila();
        else if(indice > 1 && indice < y)
            this.eliminarIFila(indice);
        else
            System.err.println("No existe la final con indice " + indice);
        
    }
    
    /**
     * 
     * @param i la posicion en x del nodo
     * @param j la posicion en y del nodo
     * @return el nodo x,y 
     * 
     */
    public NodoM<Cuadro> getNodo(int i,int j){
        NodoM<Cuadro> aux = null;
        if(i==0 && j==0)
            
            return origen;
        
        else if(i > 0 && j==0){
        
            aux= origen;
            
            for(int x =0; x < i; x++)
                aux = aux.getSiguiente();
            
            return aux;
            
        }else if( i==0 && j>0){
            
            aux = origen;
            
            for(int y =0 ; y < j; y++)
                aux = aux.getArriba();
            
            return aux;
            
        }else if( i>0 && j>0){
            aux = origen;
            
            for(int x=0; x<i; x++)
                aux = aux.getSiguiente();
            
            for(int y=0; y<j; x++)
                aux = aux.getArriba();
            
            return aux;
            
        }else
            return aux;
    }
    
    /**
     * Este metodo se  ejecuta juest antes de comenzar el juego para
     * tener puntos de refetencias validos de la forma x,y
     * +x hacia la derecha y +y hacia arriba
     **/
    public void asignarPosiciones(){
        NodoM<Cuadro> aux=origen, aux2=origen;
        int posx=0, posy=0;
        while(aux !=null){
            while(aux2!=null){
                aux2.getElemento().setX(posx);
                aux2.getElemento().setY(posy);
                if(!aux2.getElemento().vacio())
                    if(aux2.getElemento().getObjeto().getTipo()==EConstantes.HEROE){
                        mario =(Heroe) aux2.getElemento().getObjeto();
                        mario.setPosX(posx);
                        mario.setPosY(posy);
                        System.out.println("Mario encontrado");
                    }else if (aux2.getElemento().getObjeto().getTipo() == EConstantes.GOOMBA){
                        Goomba auxg = (Goomba) aux2.getElemento().getObjeto();
                        auxg.setNodoInferior(aux2.getAbajo());
                        le.addEnemigo(auxg);
                    }else if(aux2.getElemento().getObjeto().getTipo() == EConstantes.KOOPA){
                        Koopa auxk = (Koopa) aux2.getElemento().getObjeto();
                        auxk.setNodoInferior(aux2.getAbajo());
                        le.addEnemigo(auxk);
                    }
                aux2 = aux2.getSiguiente();
                posx++;
            }
            aux = aux.getArriba();
            aux2 = aux;
            posx=0;
            posy++;
        }
        
    }
    
    /**
     * llamar unicamente despues de haber realizado la asignacion de
     * posiciones
     * @return al heroe del juego
     */
    public Heroe getHeroe(){
        return mario;
    }
    
    /**
     * 
     */
    public void activarHilos(){
        le.activarHilos();
    }
    
    public void pausarHilos(){
        le.pausarHilos();
    }
    
    public void continuarHilos(){
        le.continuarHilos();
    }
}
