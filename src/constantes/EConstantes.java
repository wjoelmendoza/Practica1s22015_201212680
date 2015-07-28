/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constantes;

/**
 *
 * @author walter
 */
public enum EConstantes {
    SUELO(0),
    PARED(1),
    GOOMBA(2),
    KOOPA(3),
    FICHA(4),
    HONGO(5),
    HEROE(6),
    CASTILLO(7);
    
    private final int value;
    
    EConstantes(int value){
        this.value =value;
    }
    /**
     * 
     * @return el valor de la constante asignada
     */
    public int getValue(){
        return value;
    }
}
