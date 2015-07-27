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
    private int ptsVida;
    
    public Hongo(){
        super.tipo = EConstantes.HONGO;
    }
    
    public int getVida(){
        return ptsVida;
    }
}
