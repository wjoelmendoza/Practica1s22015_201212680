/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import estructura.ListaDoble;
import estructura.Objeto;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author walter
 */
public class LabelObjeto extends JLabel implements MouseListener {
    private ImageIcon im;
    private ListaDoble ld ;
    
    public LabelObjeto(ListaDoble ld){
        this.ld = ld;
        
    }
    
    public void setIcon(String dir){
        if(!dir.isEmpty()){
            Image aux = Toolkit.getDefaultToolkit().getImage(getClass().getResource(dir));
            Image aux2= aux.getScaledInstance(50, 50, 0);
            im = new ImageIcon(aux2);
            super.setIcon(im);
        }else{
            this.setText("vacio");
            super.setIcon(null);
            
        }
    }
    
    public Objeto getObjeto(){
        Objeto obj =ld.extraerElemento();
        if(!ld.vacia()){
            setIcon(ld.preView().getImagen());
           // System.out.println(ld.preView().getImagen());
        }else{
            setIcon("");
        }
        updateUI();
        return obj;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        getObjeto();
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
}
