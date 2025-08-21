/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio_sorteador;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author paulo
 */
public class SorteioNumeros {
    
    public static Random gerador;
    public static int[] num_sorteados;
    public static int tam;
    
    public static void exibe_numeros(){
        int x = 0;
        while(x<100){
            System.out.println(" Posicao: " + x + " - "+num_sorteados[x]);   
            x = x + 1;
        }    
    }
    
    public static boolean armazena_numero(int num){
        
            int x = 0;
            boolean valido = true;
            
            while(x<=tam){
                if(num_sorteados[x]==num){
                    valido = false;
                }
                x = x + 1;
            }
            
            if(valido){
                num_sorteados[tam]=num;
                System.out.println("O numero "+num+" foi armazenado na posicao "+tam);
                tam++;
            }else{
                System.out.println("O numero "+num+" e invalido e nao foi armazenado na posicao "+tam);
            }
            
            return valido;
            
        }    
    
    public static void main(String[] args) {

        long tempoInicial = System.currentTimeMillis();
        
        //instância um objeto da classe Random usando o construtor padrão
        gerador = new Random();
        num_sorteados = new int[100];              
        tam = 0;
       
        
        while (tam<100) {
            int num = (gerador.nextInt(100)+1);
            if(armazena_numero(num)){
                System.out.println("Sorteio Valido");
            } else {
                System.out.println("Sorteio Invalido");
            }
        }
    
        //ordena os números que foram sorteados aleatoriamente em ordem crescente
        Arrays.sort(num_sorteados);
        
        exibe_numeros();
        
        
        long tempoFinal = System.currentTimeMillis();
        long tempoDeExecucao = tempoFinal - tempoInicial;

        System.out.println("Tempo de execucao: " + tempoDeExecucao + " ms");
        
    }
}
