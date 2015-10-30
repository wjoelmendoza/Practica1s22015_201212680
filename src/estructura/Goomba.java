/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import constantes.EConstantes;
import estructura.genericas.NodoM;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author walter
 */
public class Goomba extends Objeto implements Runnable {
    private boolean hiloAct, play;
    private Thread t;
    private int dir=1;
    //dir 1 izq, dir 0 der
    
    public Goomba(String nombre ){
        t = new Thread();
        super.tipo = EConstantes.GOOMBA;
        this.nombre = nombre;
        this.img ="/recursos/zendams-cooldeviltux.png";
    }
    
    @Override
    public void run() {
        try{
            while(true){
                if(play){
                    if(dir == 1){
                        moverIzq();
                    }else
                        moverDer();
                }else
                    System.out.println("pausa");
                sleep(500);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Goomba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setHiloAct(boolean hiloAct){
        this.hiloAct= hiloAct;
    }
    
    public void setPlay(boolean play){
        this.play = play;
    }
    
    public boolean isPlaying(){
        return play;
    }
    
    public boolean isRun(){
        return hiloAct;
    }

    private void moverIzq() {
        NodoM<Cuadro> act,izq;
        act = nodoInf.getArriba();
        izq = act.getAnterior();
        if(izq!=null)
            if(izq.getElemento().vacio()){
                nodoInf = nodoInf.getAnterior();
                izq.getElemento().setObj(this);
                act.getElemento().setObj(null);
            }else {
                dir =0;
            }
        else
            dir =0;
    }

    private void moverDer() {
        NodoM<Cuadro> act, der;
        act = nodoInf.getArriba();
        der = act.getSiguiente();
        if(der!=null){
            if(der.getElemento().vacio()){
                nodoInf = nodoInf.getSiguiente();
                der.getElemento().setObj(this);
                act.getElemento().setObj(null);
            }else
                dir = 1;
        }else{
            dir =1;
        }
    }
}
