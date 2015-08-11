/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import estructura.Cuadro;
import estructura.Heroe;
import estructura.ListaDoble;
import estructura.Matriz;
import estructura.genericas.NodoM;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

/**
 *
 * @author walter
 */
public class PanelTablero extends JPanel {
    private Image fondo;
    private ListaDoble ld;
    private Matriz m;
    private LabelObjeto obj;
    Cuadro cua; 
    Cuadro cua1;
    Cuadro cua2;
    private NodoM<Cuadro> aux;
    private Heroe mario;
    private int pvx, pvy;
        
    public PanelTablero(ListaDoble ld, Matriz m, LabelObjeto obj){
        pvx = 16;
        pvy = 12;
        this.setBounds(20, 150, 800, 600);
        this.m = m;
        this.ld = ld;
        this.obj = obj;
        this.setLayout(null);
        fondo= Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/fondo.jpeg"));
        this.setFocusable(true);
        aux = m.getNodo(0, 0);
        adjMatriz();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d =(Graphics2D) g;
        g2d.drawImage(fondo,0,0,800,600, this);
        g2d.setStroke(new BasicStroke(3.0f));
        g2d.setColor(Color.YELLOW);
//     
       grid(g2d);
       graficarMatriz(g2d);
        
        
    }
    
    private void grid(Graphics2D g2d){
        if(m.getY() < 13 && m.getX() < 17){
            for(int i = 0; i < m.getY(); i++){
                g2d.draw(new Line2D.Float(0,550-50*i,50*m.getX(),550 - 50*i));
            }
            
            for(int i = 0; i < m.getX(); i++){
                g2d.draw(new Line2D.Float(50 + 50 * i, 600, 50 + 50 * i, 600- 50*m.getY()));
            }
        }else if(m.getY()< 13 && m.getX() > 16){
            for(int i = 0; i < m.getY(); i++){
                g2d.draw(new Line2D.Float(0,550-50*i,800, 550 - 50*i));
            }
            
            for(int i = 0; i < 16; i++){
                g2d.draw(new Line2D.Float(50 + 50*i,600,50+50*i, 600 - 50*m.getY()));
            }
        }else if(m.getX()<17 && m.getY()>12){
            for(int i = 0; i < 13; i++){
                g2d.draw(new Line2D.Float(0,550-50*i,50*m.getX(), 550 - 50*i));
            }
            
            for(int i = 0; i < m.getX(); i++){
                g2d.draw(new Line2D.Float(50 + 50 * i, 600, 50 + 50 * i, 0));
            }
        }else{
            for(int i = 0; i < 13; i++){
                g2d.draw(new Line2D.Float(0,550-50*i,800, 550 - 50*i));
            }
            
            for(int i = 0; i < 16; i++){
                g2d.draw(new Line2D.Float(50 + 50 * i, 600, 50 + 50 * i, 0));
            }
        }
    }
    
    private void graficarMatriz(Graphics2D g2d){
        Cuadro auxC;
        NodoM<Cuadro> aux1,aux2;
        aux1 = aux2 = aux;
        
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
    
    
    public void adjMatriz(){
        this.removeAll();
        NodoM<Cuadro> aux1, aux2;
        aux1 = aux;
        aux2 = aux;
        Cuadro auxC;
        
        if(m.getX()<17&&m.getY()<13){
            for(int j = 0; j < m.getY(); j++ ){
                for(int i = 0; i < m.getX(); i++){
                    auxC = aux1.getElemento();
                    auxC.setLabel(obj);
                    auxC.setBounds(50*i, 550 - 50 * j, 50, 50);
                    this.add(auxC);
                    aux1 = aux1.getSiguiente();
                }
                aux2 = aux2.getArriba();
                aux1 = aux2;
            }
        }else if(m.getX()>16 &&m.getY()<13){
            
            for(int j = 0; j < m.getY(); j++ ){
                for(int i = 0; i < 16; i++){
                    auxC = aux1.getElemento();
                    auxC.setLabel(obj);
                    auxC.setBounds(50*i, 550 - 50 * j, 50, 50);
                    this.add(auxC);
                    aux1 = aux1.getSiguiente();
                }
                aux2 = aux2.getArriba();
                aux1 = aux2;
            }
            
        }else if(m.getX()<17 && m.getY()>12){
            for(int j = 0; j<12 ; j++ ){
                for(int i = 0; i < m.getX(); i++){
                    auxC = aux1.getElemento();
                    auxC.setLabel(obj);
                    auxC.setBounds(50*i, 550 - 50 * j, 50, 50);
                    this.add(auxC);
                    aux1 = aux1.getSiguiente();
                }
                aux2 = aux2.getArriba();
                aux1 = aux2;
            }
        }else if(m.getX()>16 && m.getY()>12){
             for(int j = 0; j<12 ; j++ ){
                for(int i = 0; i < 16; i++){
                    auxC = aux1.getElemento();
                    auxC.setLabel(obj);
                    auxC.setBounds(50*i, 550 - 50 * j, 50, 50);
                    this.add(auxC);
                    aux1 = aux1.getSiguiente();
                }
                aux2 = aux2.getArriba();
                aux1 = aux2;
            }
        }
    }
    
    public void moverXder(){
        System.out.println(pvx);
        if(pvx < m.getX()){
            pvx++;
            aux = aux.getSiguiente();
            adjMatriz();
            repaint();
        }
    }
    
   public void moverXIzq(){
       if(aux.getAnterior() != null){
           pvx--;
           aux = aux.getAnterior();
           adjMatriz();
           repaint();
       }
   }
   
   public void moverYArriba(){
       if(pvy <m.getY()){
           pvy ++;
           aux = aux.getArriba();
           adjMatriz();
           repaint();
       }
   }
   
   public void moverYAbajo(){
       if(aux.getAbajo()!=null){
           pvy--;
           aux = aux.getAbajo();
           adjMatriz();
           repaint();
       }
   }
   
   public Heroe getHero(){
       return mario;
   }
}
