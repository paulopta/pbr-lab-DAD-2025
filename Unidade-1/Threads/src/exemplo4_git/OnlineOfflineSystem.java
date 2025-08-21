/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo4_git;

/**
 *
 * @author paulo
 */
public class OnlineOfflineSystem {
    
    public static void main (String[] args){
        
        Data data = new Data();
        //Depois comentar para simular loope eterno no Sync
        data.setOutOfSync(true); // dado desincronizado
        Thread readData = new Thread(new ReadDataThread(data));
        Thread syncData = new Thread(new SyncDataThread(data));
        readData.start();
        //Corrigir o loope eterno tornando a thread daemon
        //syncData.setDaemon(true); -- será encerrada enquando nenhuma outra estiver em execução
        syncData.start();
        
        /* 1ª Execução 
            2s pra Read -- começou
            5s Sync data -- ficou esperando
            2s Ler -- continuou a leitura e imprimiu o dado
        */
        
        /* 2ª Execução  - 
            alterar o data não syncronizado ou comentar a primeira linha acima da criação da primeira Thread
            Ele tenta ler mas ele nunca vai ficar outOfSync e por isso a Thread fica 
            eterna por causa do comando wait
            Utiliza o conceito de Daemon nesse caso
        */
        
    }
    
}
