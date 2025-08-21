/*
 * PUC MINAS - BARREIRO / Sistemas de Informação
 * Exemplo Prático - Threads
 */
package exercicios_corredores;
/**
 * Software que implementa duas Threads
 * @author prof. Paulo Henrique Rodrigues
 */
public class ThreadsJava {

    /**
     * @param args the command line arguments
     */
    static int i = 0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        long tempoInicial = System.currentTimeMillis();
        
        Thread a = new Thread(t1);
        Thread b = new Thread(t2);
        a.start();
        b.start();
        do{
            //System.out.print(" - ");
        }while((a.isAlive())&&(b.isAlive()));
        
        long tempoFinal = System.currentTimeMillis();
        long tempoDeExecucao = tempoFinal - tempoInicial;

        System.out.println("Tempo de execucao: " + tempoDeExecucao + " ms");
    }
    
      private static void countMe(String name){
        i++;
        System.out.println("Current Counter is: " + i + ", updated by: " + name);
    }

    private static Runnable t1 = new Runnable() {
        public void run() {
            try{
                for(int i=0; i<5; i++){
                    countMe("t1");
                }
            } catch (Exception e){}

        }
    };

    private static Runnable t2 = new Runnable() {
        public void run() {
            try{
                for(int i=0; i<5; i++){
                    countMe("t2");
                }
            } catch (Exception e){}
       }
    };
}
