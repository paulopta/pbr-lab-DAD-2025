/*
 * PUC MINAS - BARREIRO / Sistemas de Informação
 * Exemplo Prático - Threads
 */
package exercicios_corredores;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Software que implementa corredores com o uso de Threads
 * @author prof. Paulo Henrique Rodrigues
 */
public class ThreadsCorredores {

    /**
     * @param args the command line arguments
     */
    static int c1 = 0;
    static int c2 = 0;
    static int c3 = 0;
    static int c4 = 0;
    static volatile boolean campeao = false;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        long tempoInicial = System.currentTimeMillis();
                
        Thread a = new Thread(t1);
        Thread b = new Thread(t2);
        Thread c = new Thread(t3);
        Thread d = new Thread(t4);
        a.start();
        b.start();
        c.start();
        d.start();
        do{
            System.out.print("\n correndo \n ");
            System.out.print("\n c1 " + c1);
            System.out.print("\n c2 " + c2);
            System.out.print("\n c3 " + c3);
            System.out.print("\n c4 " + c4);
        }while(!campeao);
        
        long tempoFinal = System.currentTimeMillis();
        long tempoDeExecucao = tempoFinal - tempoInicial;

        System.out.println("Tempo de execucao: " + tempoDeExecucao + " ms");
    }
    
    private static synchronized void Correr(String name, int passos){
        
        if (campeao) return;
        
        if(name.equals("c1")){
            c1 = c1 + passos;
            if(c1>=100){
                campeao = true;
                System.out.println(" \n C1 ganhou com "+c1+" passos ");
            }else{
                System.out.println("\n Corredor: " + name + ", correu: " + passos);
            }
            
        }
        if(name.equals("c2")){
            c2 = c2 + passos;
            if(c2>=100){
                campeao = true;
                System.out.println("\n C2 ganhou com "+c2+" passos ");
            }else{
                System.out.println("\n Corredor: " + name + ", correu: " + passos);
            }
            
        }
        if(name.equals("c3")){
            c3 = c3 + passos;
            if(c3>=100){
                campeao = true;
                System.out.println("\n C3 ganhou com "+c3+" passos ");
            }else{
                System.out.println("\n Corredor: " + name + ", correu: " + passos);
            }
            
        }
        if(name.equals("c4")){
            c4 = c4 + passos;
            if(c4>=100){
                campeao = true;
                System.out.println("\n C4 ganhou com "+c4+" passos ");
            }else{
                System.out.println("\n Corredor: " + name + ", correu: " + passos);
            }
            
        }
    }

    private static Runnable t1 = new Runnable() {
        public void run() {
            try{
                do{
                    int num = ThreadLocalRandom.current().nextInt(1,10);
                    Correr("c1",num); 
                }while(!campeao);
            } catch (Exception e){}

        }
    };
    private static Runnable t2 = new Runnable() {
        public void run() {
            try{
               do{
                    int num = ThreadLocalRandom.current().nextInt(1,10);
                    Correr("c2",num); 
                }while(!campeao);
            } catch (Exception e){}

        }
    };
    private static Runnable t3 = new Runnable() {
        public void run() {
            try{
               do{
                    int num = ThreadLocalRandom.current().nextInt(1,10);
                    Correr("c3",num); 
                }while(!campeao);
            } catch (Exception e){}

        }
    };
    private static Runnable t4 = new Runnable() {
        public void run() {
            try{
               do{
                    int num = ThreadLocalRandom.current().nextInt(1,10);
                    Correr("c4",num); 
                }while(!campeao);
            } catch (Exception e){}

        }
    };

}
