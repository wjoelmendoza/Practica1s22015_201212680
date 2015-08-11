/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import estructura.Cuadro;
import estructura.Heroe;
import estructura.Matriz;
import estructura.genericas.NodoM;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author walter
 */
public class GMatrix extends JPanel implements Runnable , KeyListener {
    private Heroe mario;
    private Matriz m ;
    private Image fondo;
    private NodoM<Cuadro> aux;
    private boolean asignado = false;
    public GMatrix (Matriz m){
        this.m = m;
        this.mario = m.getHeroe();
        ubicarNodo();
        this.setFocusable(true);
        this.setBounds(25, 75, 800, 600);
        fondo = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/fondo.jpeg"));
        
    }
    
    private void ubicarNodo(){
        aux = m.getNodo(mario.getPosX(), mario.getPosY());
        mario.setNodoInferior(aux.getAbajo());
        aux = aux.getAbajo();
        asignado = true;
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(fondo,0, 0 ,800, 600, this);
        graficarMatriz(g2d);
    }
    
    private void graficarMatriz(Graphics2D g2d){
        Cuadro auxC;
        NodoM<Cuadro> aux1,aux2;
        aux1 = aux2 = aux;
        if(asignado){
            if(m.getX()<17&&m.getY()<13){
                for(int j = 0; j < m.getY(); j++ ){
                    for(int i = 0; i < m.getX(); i++){
                        auxC = aux1.getElemento();
                        if(!auxC.vacio())
                            g2d.drawImage(Toolkit.getDefaultToolkit().getImage( getClass().getResource(auxC.getImg())),50*i,550-50*j,50,50,this);
                    
                        aux1 = aux1.getSiguiente();
                    }
                    aux2 = aux2.getArriba();
                    aux1 = aux2;
                }   
            }else if(m.getX()>16 && m.getY()<13){
                for(int j = 0; j < m.getY(); j++ ){
                    for(int i = 0; i < 16; i++){
                        auxC = aux1.getElemento();
                        if(!auxC.vacio())
                            g2d.drawImage(Toolkit.getDefaultToolkit().getImage( getClass().getResource(auxC.getImg())),50*i,550-50*j,50,50,this);
                       
                        aux1 = aux1.getSiguiente();
                    }
                    aux2 = aux2.getArriba();
                    aux1 = aux2;
                }
            }else if(m.getX()<17 && m.getY()>12){
                for(int j =0; j < 12; j++){
                    for(int i =0; i < m.getX(); i++ ){
                        auxC = aux1.getElemento();
                        if(!auxC.vacio())
                            g2d.drawImage(Toolkit.getDefaultToolkit().getImage( getClass().getResource(auxC.getImg())),50*i,550-50*j,50,50,this);
                    
                        aux1 = aux1.getSiguiente();
                    }
                    aux2 = aux2.getArriba();
                    aux1 = aux2;
                }
            }else if(m.getX()>16 && m.getY() >12){
                for(int j =0; j < 12; j++){
                    for(int i =0; i < 16; i++ ){
                        auxC = aux1.getElemento();
                        if(!auxC.vacio())
                            g2d.drawImage(Toolkit.getDefaultToolkit().getImage( getClass().getResource(auxC.getImg())),50*i,550-50*j,50,50,this);
                        
                        aux1 = aux1.getSiguiente();
                    }
                    aux2 = aux2.getArriba();
                    aux1 = aux2;
                }
            }
        }
    }
    
    @Override
    public void run() {
        try{
        while(true){
            repaint();
            sleep(100);
        }
        } catch (InterruptedException ex) {
            Logger.getLogger(GMatrix.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        mario.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        mario.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        mario.keyReleased(e);
    }
    
    
}
