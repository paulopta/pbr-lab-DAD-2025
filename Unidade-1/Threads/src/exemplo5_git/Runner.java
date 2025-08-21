/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo5_git;

/**
 *
 * @author paulo
 */
public class Runner implements Runnable{
    
    public Runner(Race race, String runner){
        super();
        this.race = race;
        this.runner = runner;
    }
    
    public Race race;
    public String runner;
    
    @Override
    public void run(){
        System.out.println(runner + "running...");
        System.out.println("Winner: "+runner);
        
        //checar se algum corredor encerrou
        //while(!race.isFinished()){
        //    race.setFinished(true);
        //    System.out.println("Wineer: "+runner);
        //    return;
        //}
        //System.out.println( runner + " lost :()");    
    }
    
    
}
