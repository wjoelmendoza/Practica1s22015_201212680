/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

import constantes.EConstantes;

/**
 *
 * @author walter
 */
public class Principal {
    
    public static void main(String[] args){
        System.out.println("hola java");
        EConstantes a  = EConstantes.CASTILLO;
        if(a == EConstantes.CASTILLO)
            System.out.println("es un castillo");
    }
}
