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
public class ThreadsCorredores2 {

    static int c1 = 0;
    static int c2 = 0;
    static int c3 = 0;
    static int c4 = 0;
    static volatile boolean campeao = false; // garante visibilidade entre threads
    
    public static void main(String[] args) {

        long tempoInicial = System.currentTimeMillis();

        Thread a = new Thread(t1);
        Thread b = new Thread(t2);
        Thread c = new Thread(t3);
        Thread d = new Thread(t4);

        a.start();
        b.start();
        c.start();
        d.start();

        // Espera as threads terminarem
        try {
            a.join();
            b.join();
            c.join();
            d.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long tempoFinal = System.currentTimeMillis();
        long tempoDeExecucao = tempoFinal - tempoInicial;

        System.out.println("\nCorrida encerrada!");
        System.out.println("Distância final -> C1: " + c1 + ", C2: " + c2 + ", C3: " + c3 + ", C4: " + c4);
        System.out.println("Tempo de execução: " + tempoDeExecucao + " ms");
    }

    private static synchronized void Correr(String name, int passos){
        if(campeao) return; // se já temos campeão, não precisa mais atualizar

        if(name.equalsIgnoreCase("c1")){
            c1 += passos;
            if(c1 >= 100 && !campeao){
                campeao = true;
                System.out.println("🏆 C1 ganhou com "+c1+" passos!");
            }
        }
        if(name.equalsIgnoreCase("c2")){
            c2 += passos;
            if(c2 >= 100 && !campeao){
                campeao = true;
                System.out.println("🏆 C2 ganhou com "+c2+" passos!");
            }
        }
        if(name.equalsIgnoreCase("c3")){
            c3 += passos;
            if(c3 >= 100 && !campeao){
                campeao = true;
                System.out.println("🏆 C3 ganhou com "+c3+" passos!");
            }
        }
        if(name.equalsIgnoreCase("c4")){
            c4 += passos;
            if(c4 >= 100 && !campeao){
                campeao = true;
                System.out.println("🏆 C4 ganhou com "+c4+" passos!");
            }
        }

        System.out.println("Corredor: " + name + " correu " + passos + " passos. [Total = "
                + (name.equals("c1") ? c1 : name.equals("c2") ? c2 : name.equals("c3") ? c3 : c4) + "]");
    }

    private static Runnable t1 = new Runnable() {
        public void run() {
            try{
                while (!campeao) {
                    int num = ThreadLocalRandom.current().nextInt(1,10);
                    Correr("c1", num);
                    Thread.sleep(100);
                }
            } catch (Exception e){}
        }
    };
    private static Runnable t2 = new Runnable() {
        public void run() {
            try{
                while (!campeao) {
                    int num = ThreadLocalRandom.current().nextInt(1,10);
                    Correr("c2", num);
                    Thread.sleep(1000);
                }
            } catch (Exception e){}
        }
    };
    private static Runnable t3 = new Runnable() {
        public void run() {
            try{
                while (!campeao) {
                    int num = ThreadLocalRandom.current().nextInt(1,10);
                    Correr("c3", num);
                    Thread.sleep(1000);
                }
            } catch (Exception e){}
        }
    };
    private static Runnable t4 = new Runnable() {
        public void run() {
            try{
                while (!campeao) {
                    int num = ThreadLocalRandom.current().nextInt(1,10);
                    Correr("c4", num);
                    Thread.sleep(1000);
                }
            } catch (Exception e){}
        }
    };
}
