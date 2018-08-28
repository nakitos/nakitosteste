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
public class Mago extends Personagem{
    public static final int BOLADEFOGO = 0;
    public static final int RAIO = 1;
    
    public static final int CUSTO_BOLADEFOGO = 5;
    public static final int CUSTO_RAIO = 6;
    
    private int mana;
    
    public Mago(String nome, int hp,int hpMax, int mana,
            int forca, int destreza, int inteligencia){
        
        super(nome,hp,hpMax,forca,destreza,inteligencia);
        this.mana = mana;
    }
    public int soltarMagia(int tipo, Personagem alvo){
        if(tipo == BOLADEFOGO &&
                this.mana >= CUSTO_BOLADEFOGO){
            this.mana -= CUSTO_BOLADEFOGO;
            return alvo.receberAtaque(ATAQUE_MAGICO, inteligencia);
            
        }
        else if(tipo == RAIO &&
                this.mana >= CUSTO_RAIO){
            this.mana -= CUSTO_RAIO;
            return alvo.receberAtaque(ATAQUE_MAGICO, inteligencia);
        }
        return -1;
    }

    @Override
    public int autoAtaque(Personagem p){
        int i = super.autoAtaque(p);
        return p.receberAtaque(ATAQUE_FISICO, 
                inteligencia);
    }
}
