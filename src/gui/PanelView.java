/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import estructura.ListaDoble;
import estructura.Objeto;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author walter
 */
class PanelView extends JPanel implements MouseListener {
    ListaDoble ld;
    public PanelView(ListaDoble ld){
        this.setBounds(97, 17, 45, 45);
        this.ld = ld;
        this.repaint();
        this.setFocusable(true);
        addMouseListener(this);
    }
    
    public Objeto getObjeto(){
        
        return ld.extraerElemento();
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Image im = Toolkit.getDefaultToolkit().createImage(getClass().getResource(ld.preView().getImagen()));
        g2d.drawImage(im, 0, 0,40,40,this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ld.extraerElemento();
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
