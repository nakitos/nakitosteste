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
public class Guerreiro extends Personagem{
    public Guerreiro(String nome, int hp,int hpMax,
            int forca, int destreza,
            int inteligencia){
        super(nome, hp,hpMax, forca, destreza, inteligencia);
    }
    
    public int golpeBrutal(Personagem p){
        int vidaPerdida = this.hpMax - this.hp;
        this.hp -= (int)this.hpMax/5;
        return p.receberAtaque(ATAQUE_FISICO, 
                forca + (int)vidaPerdida/5);
    }
}
