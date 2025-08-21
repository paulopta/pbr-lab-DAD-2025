/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio_sorteador;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author paulo
 */
public class SorteadorThreads {
    
    static int[] num_sorteados;
    static int tam;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        long tempoInicial = System.currentTimeMillis();
        
        num_sorteados = new int[100];              
        tam = 0;
        
        Thread a = new Thread(t1);
        Thread b = new Thread(t2);
        a.start();
        b.start();
        
        do{
        }while((a.isAlive())&&(b.isAlive()));
        
        //ordena os números que foram sorteados aleatoriamente em ordem crescente
        Arrays.sort(num_sorteados);
        
        //exibe os números em ordem crescente
        exibe_numeros();
    
        
        long tempoFinal = System.currentTimeMillis();
        long tempoDeExecucao = tempoFinal - tempoInicial;

        System.out.println("Tempo de execucao: " + tempoDeExecucao + " ms");
    }
    
    public static void exibe_numeros(){
        int x = 0;
        while(x<100){
            System.out.println(" Posicao: " + x + " - "+num_sorteados[x]);   
            x = x + 1;
        }    
    }
    
    public static boolean armazena_numero(int num, String thread){
        
            int x = 0;
            boolean valido = true;
            //int num = gerador.nextInt(100);
            
            System.out.println(thread + " gerou o numero - "+num);
            
            while(x<=tam){
                if(num_sorteados[x]==num){
                    valido = false;
                }
                x = x + 1;
            }
            
            if(valido){
                num_sorteados[tam]=num;
                System.out.println(thread + "O numero "+num+" foi armazenado na posicao "+tam);
                tam++;
            }else{
                System.out.println(thread + "O numero "+num+" e invalido e nao foi armazenado na posicao "+tam);
            }
            
            return valido;
            
        }  
    
         private static Runnable t1 = new Runnable() {
        public void run() {
            try{
                int num;
                while(tam<100){
                    num = ThreadLocalRandom.current().nextInt(1,100);
                    armazena_numero(num, "t1");
                }
            } catch (Exception e){}

        }
    };

    private static Runnable t2 = new Runnable() {
        public void run() {
            try{
                int num;
                while(tam<100){
                    num = ThreadLocalRandom.current().nextInt(1,100);
                    armazena_numero(num, "t2");
                }
            } catch (Exception e){}
       }
    };
    
    
}
