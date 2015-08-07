/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import estructura.ListaDoble;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author walter
 */
public class PanelTablero extends JPanel implements MouseListener{
    private Image fondo;
    private ListaDoble ld;
    
    public PanelTablero(ListaDoble ld){
        this.setBounds(20, 150, 800, 600);
        this.ld = ld;
        this.setLayout(null);
        fondo= Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/fondo.jpeg"));
        //JLabel as  = new JLabel("mouse listener");
        //this.add(new JLabel("uno"));
        //as.addMouseListener(this);
        this.setFocusable(true);
        JPanel jp = new JPanel();
        jp.setBounds(0, 0, 40, 40);
        jp.addMouseListener(this);
        jp.setFocusable(true);
        jp.setBackground(Color.red);
        add(jp);
        JPanel jp1 = new JPanel();
        jp1.setBounds(40,0, 40, 40);
        jp1.addMouseListener(this);
        jp1.setFocusable(true);
        jp1.setBackground(Color.red);
        add(jp1);
        //add(as);
        //this.addMouseListener(this);
        //this.repaint();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d =(Graphics2D) g;
        g2d.drawImage(fondo,0,0,800,600, this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("solto el clic");
        System.out.println(this.getAlignmentX()+","+this.getAlignmentY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Entro el mouse");
        System.out.println(this.getAlignmentX());
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
