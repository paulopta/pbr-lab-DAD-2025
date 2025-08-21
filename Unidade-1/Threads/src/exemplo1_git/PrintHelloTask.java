/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo1_git;

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
  System.out.println("Hello, " + name + "!");
 }

}
