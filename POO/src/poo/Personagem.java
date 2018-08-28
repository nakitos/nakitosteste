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
public class Personagem {
    public static final int ATAQUE_FISICO = 0;
    public static final int ATAQUE_MAGICO = 1;
    
    public static final int RECEBEU_ATAQUE = 0;
    public static final int DESVIOU_ATAQUE = 1;
    
    protected String nome;
    protected int hp, hpMax, forca, destreza, inteligencia;
    
    public Personagem(String nome, int hp, int hpMax,
            int forca, int destreza,
            int inteligencia){
        this.nome = nome;
        this.hp = hp;
        this.hpMax = hpMax;
        this.forca = forca;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
    }
    
    public int autoAtaque(Personagem p){
        return p.receberAtaque(ATAQUE_FISICO, forca);
    }
    public int receberAtaque(int tipo, int qtd){
        Random r = new Random();
        int chance = r.nextInt(100);
        if(this.destreza < chance){
            if(tipo == ATAQUE_FISICO){
                this.hp -= qtd - (int)(this.forca/2);
            }else if(tipo == ATAQUE_MAGICO){
                this.hp -= qtd - (int)(this.inteligencia/2);
            }
            return RECEBEU_ATAQUE;
        }
        return DESVIOU_ATAQUE;
    }
    public boolean isDead(){
        return (this.hp <= 0);
    }
}
