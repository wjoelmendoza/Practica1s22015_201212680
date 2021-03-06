/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import constantes.EConstantes;
import estructura.interfaz.IDibujar;
import estructura.genericas.NodoM;
import java.awt.Graphics2D;

/**
 *
 * @author walter
 */
public class Objeto implements IDibujar {
    protected String img;
    protected String nombre;
    protected int posX,posY,tamaño;
    protected NodoM nodoInf;
    protected EConstantes tipo;
    
    @Override
    public void dibujar(Graphics2D g2d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getImagen() {
        return img;
    }

    @Override
    public void setImagen(String img) {
        this.img = img;
    }

    @Override
    public void setPosX(int posX) {
        this.posX = posX;
    }

    @Override
    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public int getPosX() {
        return posX;
    }

    @Override
    public int getPosY() {
        return posY;
    }

    @Override
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public int getTamaño() {
        return tamaño;
    }

    @Override
    public EConstantes getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(EConstantes tipo) {
        this.tipo = tipo;
    }

    @Override
    public void setNodoInferior(NodoM nodoInferior) {
        this.nodoInf = nodoInferior;
    }

    @Override
    public NodoM getNodoInferior() {
        return nodoInf;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
