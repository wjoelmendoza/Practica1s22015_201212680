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
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
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
    
    public void eliminarFila(){
        if(origen!=null){
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
    
    public void elimarColumna(){
        if(origen != null){
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
    
    
    public boolean vacia(){
        return origen == null;
    }
}
