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
public class Ficha extends Objeto {
    public Ficha(String nombre){
        super.tipo = EConstantes.FICHA;
        this.nombre = nombre;
        this.img ="/recursos/ficha.png";
    }
    
}
