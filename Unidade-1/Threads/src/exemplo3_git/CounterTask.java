
package exemplo3_git;

/**
 *
 * @author paulo
 */
public class CounterTask implements Runnable{
  private int counter;

 @Override
 public void run() {    //synchronized garante que os códigos no bloco delimitado sejam executados apenas se nenhuma outra Thread estiver executando
  synchronized (this) { //conceito de MUTEX que fecha o acesso ao bloco delimitado, como um semáforo um sinal
   counter++;
   System.out.println(Thread.currentThread().getName() + ": " + counter);
  }
 }
}
