/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import constantes.EConstantes;

/**
 *
 * @author walter
 */
public class Goomba extends Objeto implements Runnable {

    public Goomba(String nombre ){
        super.tipo = EConstantes.GOOMBA;
        this.nombre = nombre;
        this.img ="/recursos/zendams-cooldeviltux.png";
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
