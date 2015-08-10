/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import constantes.EConstantes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author walter
 */
public class Heroe extends Objeto implements KeyListener{
    private int puntos,vidas;
    public Heroe(String nombre){
        puntos =0;
        vidas = 1;
        super.tipo = EConstantes.HEROE;
        this.nombre = nombre;
        this.img ="/recursos/luap33-sangoku.png";
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
