package exemplo2_git;

/**
 *
 * @author Paulo Henrique Rodrigues
 * @reference: https://medium.com/swlh/understanding-java-threads-once-and-for-all-711f71e0ec1e
 */

public class Exemplo2 {
 
 public static void main(String [] args) {
  Thread task1 = new Thread(new PrintHelloTask("Task 1"));
  Thread task2 = new Thread(new PrintHelloTask("Task 2"));
  Thread task3 = new Thread(new PrintHelloTask("Task 3"));
  Thread task4 = new Thread(new PrintHelloTask("Task 4"));
  
  task1.start();
  task2.start();
  task3.start();
  task4.start();
  
 }

    
}
