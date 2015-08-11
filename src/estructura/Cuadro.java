/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import estructura.genericas.NodoM;
import gui.LabelObjeto;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author walter
 */
public class Cuadro extends JPanel implements MouseListener {
    private Objeto obj;
    private ListaDoble ld;
    private LabelObjeto lblo;
    private NodoM<Cuadro> posact;
    private int px,py;
    
    public Cuadro(ListaDoble ld){
        this.ld = ld;
        this.addMouseListener(this);
        this.setBounds(60, 10, 50, 50);
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()== MouseEvent.BUTTON1){
            if(this.vacio()){
                this.obj = ld.extraerElemento();
                if(!ld.vacia()){
                    String im = ld.preView().getImagen();
                    lblo.setIcon(im);
                }else{
                    lblo.setIcon("");
                }
                this.getParent().repaint();
            }
        }else if(e.getButton()== MouseEvent.BUTTON3){
            if(!this.vacio()){
                ld.agregar(obj);
                obj=null;
                lblo.setIcon(ld.preView().getImagen());
                this.getParent().repaint();
            }
        }
    }

    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public void setLabel(LabelObjeto lblo){
        this.lblo = lblo;
    }
    
    public void setLista(ListaDoble ld){
        this.ld = ld;
    }
    
    public boolean vacio(){
        return obj ==null;
    }
    
    public String graf(){
        if(!vacio()){
            return obj.getNombre() +"\n" + obj.getTipo();
        }else{
            return "Vacio";
        }
    }
    
    public String getImg(){
        return obj.getImagen();
    }
    
    public void setPos(NodoM<Cuadro> posact){
        this.posact = posact;
    }
    
    public void setX(int px){
        this.px = px;
    }
    
    public void setY(int py){
        this.py = py;
    }
    
    public int getPosX(){
        return px;
    }
    
    public int getPosY(){
        return py;
    }
    
    public Objeto getObjeto(){
        return obj;
    }
    
    public void setObj(Objeto obj){
        this.obj = obj;
    }
    
}
