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
public class Hongo extends Objeto {
    private final int ptsVida;
    
    public Hongo(String nombre){
        super.tipo = EConstantes.HONGO;
        ptsVida = 1;
        this.nombre = nombre;
        this.img = "/recursos/hongo2.png";
    }
    
    public int getVida(){
        return ptsVida;
    }
}
