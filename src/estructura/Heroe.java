/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import constantes.EConstantes;
import estructura.genericas.NodoM;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author walter
 */
public class Heroe extends Objeto {
    private int puntos,vidas;
    private boolean play2;
    private NodoM<Cuadro> act;
    private boolean subiendo;
    public Heroe(String nombre){
        subiendo = false;
        puntos =0;
        vidas = 1;
        super.tipo = EConstantes.HEROE;
        this.nombre = nombre;
        this.img ="/recursos/luap33-sangoku.png";
    }

    //@Override
    public void keyTyped(KeyEvent e) {
        
    }

    //@Override
    public void keyPressed(KeyEvent e) {
        if(play2){
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                moverDerecha();
            else if(e.getKeyCode() == KeyEvent.VK_LEFT)
                moverIzquierda();
            else if(e.getKeyCode() == KeyEvent.VK_UP)
                if(!subiendo)
                moverArriba();
        }
           
    }

    //@Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    public void setVida(int vidas){
        this.vidas += vidas;
    }
    
    public int getVida(){
        return vidas;
    }
    
    public int getPuntos(){
        return puntos;
    }
    
    public void setPuntos(){
        puntos++;
    }
    
    public void setPlay(boolean play2){
        this.play2 = play2;
    }

    private void moverDerecha() {
        act = nodoInf.getArriba();
        NodoM<Cuadro> aux,aux2;
        aux2 = act.getSiguiente();
        if( act.getSiguiente()!= null){
            
            if(aux2.getElemento().vacio()){
                nodoInf = nodoInf.getSiguiente();
                aux = act.getSiguiente();
                aux.getElemento().setObj(this);
                act.getElemento().setObj(null);
                aux2 =nodoInf;
                if(!subiendo)
                if(aux2.getElemento().vacio()){
                    caida();
                }
            }else{
                Objeto obj;
                obj = aux2.getElemento().getObjeto();
                switch(obj.getTipo().getValue()){
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        vidas--;
                        break;
                    case 4:
                        nodoInf = nodoInf.getSiguiente();
                        aux2 = nodoInf;
                        aux = act.getSiguiente();
                        aux.getElemento().setObj(this);
                        act.getElemento().setObj(null);
                        puntos ++;
                        if(aux2.getElemento().vacio())
                            caida();
                        break;
                    case 5:
                        nodoInf = nodoInf.getSiguiente();
                        aux2=nodoInf;
                        aux = act.getSiguiente();
                        aux.getElemento().setObj(this);
                        act.getElemento().setObj(null);
                        vidas ++;
                        if(aux2.getElemento().vacio())
                            caida();
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null,"Ha ganado", "Gano",JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                        break;
                }
                
            }
        }
    }

    private void caida(){
        NodoM<Cuadro> aux;
        aux = act.getSiguiente();
        aux.getElemento().setObj(this);
        act.getElemento().setObj(null);
        act = aux;
        caidaG();
    }
    
    private void caidaIzq(){
        NodoM<Cuadro> aux;
        aux = act.getAnterior();
        aux.getElemento().setObj(this);
        act.getElemento().setObj(null);
        act = aux;
        caidaG();
    }
    
    private void caidaG(){
        NodoM<Cuadro> aux2;
        aux2 =nodoInf;
        if(!subiendo)
            if(aux2.getElemento().vacio()){
                new Thread(new Runnable() {

                @Override
                public void run() {
                        NodoM<Cuadro> ax, ax2;
                        act = nodoInf.getArriba();
                        ax2=nodoInf;
                        Heroe mario = (Heroe) act.getElemento().getObjeto();
                        boolean run = true;
                            
                        try{
                            Objeto auxo;
                            while(run){
                                if(!ax2.getElemento().vacio()){
                                    auxo =(Objeto) ax2.getElemento().getObjeto();
                                    switch(auxo.getTipo().getValue()){
                                        case 4:
                                            mario.puntos++;
                                            System.out.println(puntos);
                                            ax2.getElemento().setObj(null);
                                            break;
                                        case 5:
                                            mario.vidas ++;
                                            ax2.getElemento().setObj(null);
                                            break;
                                        case 1:
                                        case 0:
                                            run = false;
                                            break;
                                        case 2:
                                            ax2.getElemento().setObj(null);
                                            break;
                                        case 3:
                                            break;
                                        case 7:
                                            JOptionPane.showMessageDialog(null,"Ha ganado", "Gano",JOptionPane.INFORMATION_MESSAGE);
                                            System.exit(0);
                                            run = false;
                                            break;
                                    
                                    }
                                }else{
                                    act = nodoInf.getArriba();
                                    ax = nodoInf;
                                    ax.getElemento().setObj(act.getElemento().getObjeto());
                                    act.getElemento().setObj(null);
                                    nodoInf = nodoInf.getAbajo();
                                    ax2 = nodoInf;
                                }
                                sleep(200);
                            }
                        }catch (InterruptedException ex) {
                            Logger.getLogger(Heroe.class.getName()).log(Level.SEVERE, null, ex);
                        }  
                    }
                }).start();
            }
    }
    
    
    private void moverIzquierda() {
        act = nodoInf.getArriba();
        NodoM<Cuadro> aux,aux2;
        aux2 = act.getAnterior();
        if( act.getAnterior() != null){
            if(aux2.getElemento().vacio()){
                nodoInf = nodoInf.getAnterior();
                aux = act.getAnterior();
                aux.getElemento().setObj(this);
                act.getElemento().setObj(null);
                aux2 =nodoInf;
                if(!subiendo)
                if(aux2.getElemento().vacio()){
                    caidaIzq();
                }
            }else{
                Objeto obj;
                obj = aux2.getElemento().getObjeto();
                switch(obj.getTipo().getValue()){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null,"Ha ganado", "Gano",JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                        break;
                    case 2:
                        break;
                    case 3:
                        vidas--;
                        break;
                    case 4:
                        nodoInf = nodoInf.getSiguiente();
                        aux2 = nodoInf;
                        aux = act.getSiguiente();
                        aux.getElemento().setObj(this);
                        act.getElemento().setObj(null);
                        puntos ++;
                        if(aux2.getElemento().vacio())
                            caida();
                        break;
                    case 5:
                        nodoInf = nodoInf.getSiguiente();
                        aux2=nodoInf;
                        aux = act.getSiguiente();
                        aux.getElemento().setObj(this);
                        act.getElemento().setObj(null);
                        vidas ++;
                        if(aux2.getElemento().vacio())
                            caida();
                        break;
                }
                
            }
        }
    }

    private void moverArriba() {
       
        new Thread (new Runnable(){

            @Override
            public void run() {
                subiendo = true;
                NodoM<Cuadro> aux,aux2;
                int i =0;
                act = nodoInf.getArriba();
                try {   
                    Heroe mario =(Heroe) act.getElemento().getObjeto();
                    
                    while(i<2){
                        act = nodoInf.getArriba();
                        
                        aux = act.getArriba();
                        if(aux.getElemento().vacio()){
                            aux.getElemento().setObj(act.getElemento().getObjeto());
                            act.getElemento().setObj(null);
                            nodoInf= nodoInf.getArriba();
                        }else if(aux.getElemento().getObjeto().getTipo()==EConstantes.PARED){
                            break;
                        }else if(aux.getElemento().getObjeto().getTipo()==EConstantes.CASTILLO){
                            JOptionPane.showMessageDialog(null,"Ha ganado", "Gano",JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                            break;
                        }else if(aux.getElemento().getObjeto().getTipo() == EConstantes.SUELO){
                            break;
                        }else{
                            if(aux.getElemento().getObjeto().getTipo() == EConstantes.HONGO)
                                mario.vidas++;
                            else if(aux.getElemento().getObjeto().getTipo() == EConstantes.FICHA)
                                mario.puntos++;
                            
                            aux.getElemento().setObj(act.getElemento().getObjeto());
                            act.getElemento().setObj(null);
                            nodoInf= nodoInf.getArriba();
                        }
                        
                    
                        sleep(250);
                        i++;
                    
                    }
                    Objeto auxo;
                    sleep(300);
                    act = nodoInf.getArriba();
                    aux2 = nodoInf;
                    mario =(Heroe) act.getElemento().getObjeto();
                    boolean run= true;
                    i =0;
                    while(run){
                        i++;
                        if(!aux2.getElemento().vacio()){
                            auxo =(Objeto) aux2.getElemento().getObjeto();
                            switch(auxo.getTipo().getValue()){
                                case 4:
                                    mario.puntos++;
                                    aux2.getElemento().setObj(null);
                                    break;
                                case 5:
                                    mario.vidas ++;
                                    aux2.getElemento().setObj(null);
                                    break;
                                case 1:
                                    run = false;
                                    break;
                                case 0:
                                    run = false;
                                    break;
                                case 2:
                                    aux2.getElemento().setObj(null);
                                    break;
                                case 3:
                                    break;
                                case 7:
                                    JOptionPane.showMessageDialog(null,"Ha ganado", "Gano",JOptionPane.INFORMATION_MESSAGE);
                                    System.exit(0);
                                    run = false;
                                    break;
                                    
                            }
                        }else{
                            act = nodoInf.getArriba();
                            aux = nodoInf;
                            aux.getElemento().setObj(act.getElemento().getObjeto());
                            act.getElemento().setObj(null);
                            nodoInf = nodoInf.getAbajo();
                            aux2 = nodoInf;
                        }
                        System.out.println(i +" es esta?");
                        sleep(250);
                        
                    }
                    subiendo = false;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Heroe.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
        }).start();
        subiendo = false;
    }
}
