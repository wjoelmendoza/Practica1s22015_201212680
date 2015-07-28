/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import constantes.EConstantes;
import estructura.genericas.NodoLD;
import graphViz.GraphViz;
import java.io.File;

/**
 *
 * @author walter
 */
public class ListaDoble {
    private NodoLD<Objeto> origen, fin;
    private int size, suelo,heroe,castillo,goomba,koopa,pared,ficha,hongo;
    private GraphViz gv;
    
    public ListaDoble(){
        origen = fin = null;
        castillo = heroe = suelo = size = 0;
        goomba = koopa = pared= ficha = hongo =0;
    }
    
    public void agregar(Objeto elemento){
        size++;
        conteoTipo(elemento.tipo,1);
        NodoLD<Objeto>  aux = new NodoLD<>(elemento);
        
        if(!vacia()){
            fin.setSiguiente(aux);
            aux.setAnterior(fin);
            fin = aux;
        }else{
            origen = fin = aux;
        }
    }
    
    private void conteoTipo(EConstantes e,int n){
        if(e == EConstantes.CASTILLO){
            castillo += n;
        }else if(e == EConstantes.FICHA){
            ficha += n;
        }else if(e == EConstantes.GOOMBA){
            goomba += n;
        }else if(e == EConstantes.HEROE){
            heroe += n;
        }else if(e == EConstantes.HONGO){
            hongo += n;
        }else if(e == EConstantes.KOOPA){
            koopa += n;
        }else if(e==EConstantes.PARED){
            pared += n;
        }else if(e == EConstantes.SUELO){
            suelo +=n;
        }else{
            System.out.println("tipo no identificando");
        }
        
    }
    
    public boolean vacia(){
        return origen == null;
    }
    
    public void grafica(){
        if(!vacia()){
            int i =0;
            gv = new GraphViz();
            gv.addln(gv.start_graph());
            gv.addln("rankdir = LR;");
            NodoLD<Objeto> aux = origen;

            while(aux != null){
                gv.addln("n"+i+"[ label= \"" + aux.getElemento().getTipo().getValue() +"\"];");
                aux = aux.getSiguiente();
                i++;
            }
            i=1;
            aux = origen.getSiguiente();
            System.out.print("n0");
            gv.add("n0");
            while(aux != null){
                System.out.print("->n" + i);
                gv.add("->n"+i);
                i++;
                aux = aux.getSiguiente();
                
            }
            System.out.print(";\n");
            gv.add(";\n");
            i--;
            
            while(i>0){
                gv.add("n"+i+"->");
                System.out.print("n"+i+"->");
                i--;
            }
            System.out.println("n0;");
            gv.add("n0;\n");
            gv.addln(gv.end_graph());
            
            File ext = new File("listaDoble.png");
            
            gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), "png"), ext);
            
        }else
            System.out.println("no existe ningun elemento que graficar");
    }
}
