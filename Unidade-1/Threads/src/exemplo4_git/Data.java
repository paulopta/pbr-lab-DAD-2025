package exemplo4_git;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author paulo
 */
public class Data {
    
    private boolean outOfSync; //quando o dado não está sincronizado
    private int value; //valor associado

    public boolean isOutOfSync(){
        return outOfSync;
    }
    
    public void setOutOfSync(boolean outOfSync){
        this.outOfSync = outOfSync;
    }
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public synchronized void sync(){
    
        System.out.println("Synchronizing data");    
        try{
            if(!outOfSync)
                this.wait(); //aguarda enquanto o recurso é liberado
            
            outOfSync = false;
            Thread.sleep(5000);
            System.out.println("Synchronized");
            this.notifyAll(); // avisa a todas as Threas que estão esperando o sincronismo (as de leitura)
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    
    /* Só vai ler se ele estiver sincronizado */
    public synchronized void read(){
    
        System.out.println("Reading data");    
        try{
            if(outOfSync)
                this.wait(); //aguarda enquanto o recurso é liberado
            
            Thread.sleep(2000);
            System.out.println("Data: "+value);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    
}
