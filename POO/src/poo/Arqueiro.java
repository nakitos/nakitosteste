/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.util.Random;

/**
 *
 * @author senai
 */
public class Arqueiro extends Personagem{
    public Arqueiro(String nome, int hp,int hpMax,
            int forca, int destreza,
            int inteligencia){
        super(nome, hp,hpMax, forca, destreza, inteligencia);
    }
    public int atirarFlecha(Personagem alvo){
        Random r = new Random();
        int chance = r.nextInt(100);
        if(destreza > chance){
            return alvo.receberAtaque(ATAQUE_FISICO , forca);
        }
        else{
            return alvo.receberAtaque(ATAQUE_FISICO , forca + destreza);
        }
    }
}
