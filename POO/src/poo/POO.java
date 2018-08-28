/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

/**
 *
 * @author senai
 */
public class POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Mago mago1 = new Mago("Roberto", 10,
            8,2,3,9);
        System.out.println(mago1.nome);
        Mago mago2 = new Mago("Cleiton", 10,
            8,2,3,9);
        mago2 = mago1;
        
        if(mago1 == mago2){
            System.out.println("É o mesmo objeto!");
        }
        else{
            System.out.println("Não são o mesmo objeto!");
        }
        mago2.nome = "Jorge";
        System.out.println(mago1.nome);*/
        Mago m = new Mago("Mago Devanir", 30,30,20,6,8,15);
        Guerreiro g = new Guerreiro(
                "Guerreiro Mateus", 45,45,17,10,3);
        Batalha b = new Batalha(m,g);
        b.iniciarBatalha();
    }
    
}
