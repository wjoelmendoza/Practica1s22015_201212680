/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura.interfaz;

import constantes.EConstantes;
import estructura.genericas.NodoM;
import java.awt.Graphics2D;

/**
 *
 * @author walter
 */
public interface IDibujar {
    public void dibujar(Graphics2D g2d);
    
    public String getImagen();
    
    public void setImagen(String img);
    
    public void setPosX(int posX);
    
    public void setPosY(int posY);
    
    public int getPosX();
    
    public int getPosY();
    
    public void setTamaño(int tamaño);
    
    public int getTamaño();
    
    public EConstantes getTipo();
    
    public void setTipo(EConstantes tipo);
    
    public void setNodoInferior(NodoM nodoInferior);
    
    public NodoM getNodoInferior();
    
    public String getNombre();
    
    public void setNombre(String nombre);
}
