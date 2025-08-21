/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo2_git;


/**
 *
 * @author paulo
 */
public class PrintHelloTask implements Runnable {

    private String name;

 public PrintHelloTask(String name) {
  this.name = name; 
 }

 @Override
 public void run() {
   try {
   Thread.sleep(60000);
  } catch (InterruptedException e) {
   System.out.println(name + "foi interrompida!");
   e.printStackTrace();
  }
  System.out.println("Hello " + name + "!");
 }
}

