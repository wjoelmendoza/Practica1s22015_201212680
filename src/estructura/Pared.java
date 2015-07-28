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
public class Pared extends Objeto {
    public Pared(String nombre){
        tipo = EConstantes.PARED;
        this.nombre = nombre;
        this.img = "/recursos/pared.png";
    }
}
