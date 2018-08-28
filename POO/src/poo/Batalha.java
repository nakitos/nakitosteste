/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author senai
 */
public class Batalha {
    private Personagem p1;
    private Personagem p2;
    private Personagem pVez;
    public Batalha(Personagem p1, Personagem p2){
        this.p1 = p1;
        this.p2 = p2;
        this.pVez = definirVez();
    }
    
    public void iniciarBatalha(){
        mostrarInicio();
        while(!isFimDeJogo()){  
            pedirEExecutarComando();
            this.pVez = trocarVez();
            mostrarStatus();
        }
        mostrarPersonagemVitorioso();
    }
    private boolean isFimDeJogo(){
        return (p1.isDead() || p2.isDead());
    }
    
    private Personagem definirVez() {
        Random r = new Random();
        int vez = r.nextInt(2);
        if(vez == 0){
            return this.p1;
        }
        else{
            return this.p2;
        }
    }

    private void mostrarInicio() {
        String s = 
                "Uma batalha épica vai começar! \n" +
                this.pVez.nome + " irá começar a batalha!";
        System.out.println(s);
    }

    private void pedirEExecutarComando() {
        String s = "\n" + this.pVez.nome + " escolha um comando:"+
                "\n1 - Ataque";
        Class classe = this.pVez.getClass();
        if(classe == Mago.class){
            s += "\n2 - Soltar Bola de Fogo"
                    + "\n 3 - Soltar Raio";
        }
        else if(classe == Arqueiro.class){
            s += "\n2 - Atirar flecha";
        }
        else if(classe == Guerreiro.class){
            s+= "\n 2 - Golpe Fatal";
        }
        System.out.println(s);
        Scanner sc = new Scanner(System.in);
        int comando = sc.nextInt();
        sc.nextLine();
        //System.out.println("Escolha o alvo: ");
        Personagem p = getPersonagemRestante();
        int resultadoAtaque = -1;
        if(classe == Mago.class){
            Mago m = (Mago)pVez;
            switch(comando){
                case 2: 
                    resultadoAtaque = 
                            m.soltarMagia(Mago.BOLADEFOGO, p);
                    break;
                case 3:
                    resultadoAtaque = 
                            m.soltarMagia(Mago.RAIO, p);
                    break;
            }

        }
        else if(classe == Arqueiro.class){
            Arqueiro arqueiro = (Arqueiro)pVez;
            switch(comando){
                case 2: 
                    resultadoAtaque = 
                            arqueiro.atirarFlecha(p);
                    break;
            }
        }
        else if(classe == Guerreiro.class){
            Guerreiro g = (Guerreiro)pVez;
            switch(comando){
                case 2: 
                    resultadoAtaque = g.golpeBrutal(p);
                    break;
            }
        }
        switch(resultadoAtaque){
            case Personagem.RECEBEU_ATAQUE:
                System.out.println("\nRecebeu Ataque");
                break;
            case Personagem.DESVIOU_ATAQUE:
                System.out.println("\nDesviou Ataque");
                break;
        }
    }

    private Personagem getPersonagemRestante() {
        if(this.pVez == this.p1){
            return this.p2;
        }
        return this.p1;
    }

    private void mostrarPersonagemVitorioso() {
        String s = "\n";
        if(p1.isDead()){
            s = p2.nome;
        }
        else if(p2.isDead()){
            s = p1.nome;
        }
        s += " GANHOU O JOGO!!!";
        System.out.println(s);
    } 

    private Personagem trocarVez() {
        if(this.pVez == p1){
            return this.p2;
        }
        else{
            return this.p1;
        }
    }

    private void mostrarStatus() {
        String s = "\n\n=====================\n"+
                p1.nome + ": hp: " + p1.hp + 
                "\n" + p2.nome + ": hp: " + p2.hp +
                "\n=====================\n";
        System.out.println(s);
    }
}
