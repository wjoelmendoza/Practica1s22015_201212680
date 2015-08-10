/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import estructura.Heroe;
import estructura.Matriz;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author walter
 */
public class GMatrix extends JPanel implements Runnable {
    private Heroe mario;
    private Matriz m ;
    private Image fondo;
    public GMatrix (Matriz m, Heroe mario){
        this.mario = mario;
        this.m = m;
        this.setFocusable(true);
        this.addKeyListener(mario);
        this.setBounds(25, 25, 800, 600);
        fondo = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/fondo.jpeg"));
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(fondo, 800, 600, this);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
