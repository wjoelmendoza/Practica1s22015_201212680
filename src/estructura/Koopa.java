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
public class Koopa extends Goomba {
    public Koopa(String nombre){
        super(nombre);
        super.tipo = EConstantes.KOOPA;
        img = "/recursos/tarazan-virusp.png";
    }
}
