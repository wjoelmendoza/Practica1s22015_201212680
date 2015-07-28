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
public class Castillo extends Objeto{
    public Castillo(String nombre){
        super.tipo = EConstantes.CASTILLO;
        this.nombre = nombre;
        img ="/recursos/pared1.png";
    }
    
}
