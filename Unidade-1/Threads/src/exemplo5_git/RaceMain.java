/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo5_git;

/**
 *
 * @author paulo
 */
public class RaceMain {
    
    public static void main (String args[]){
    
        Race race = new Race();
        Thread runner1 = new Thread(new Runner(race,"Runner 1"));
        Thread runner2 = new Thread(new Runner(race,"Runner 2"));
        System.out.println("Starting...");
        runner1.start();
        runner2.start();
        
        /* 1 - Execução 
          os dois ganham porque eles executam sua função normalmente
        */
        
        /* 2 - Execução 
          os dois ganham porque eles executam sua função normalmente
        */
    }
}
