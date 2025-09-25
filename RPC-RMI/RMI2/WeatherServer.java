/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI3;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class WeatherServer {
    public static void main(String[] args) {
        try {
            // Instancia a implementação do serviço
            WeatherService weatherService = new WeatherServiceImpl();

            // Cria um registro RMI na porta 1099 (padrão)
            Registry registry = LocateRegistry.createRegistry(1099);

            // Registra o objeto de serviço com um nome
            registry.rebind("WeatherService", weatherService);
            // Ligacao do objeto ao registro
        
            System.out.println("Registered: "+ weatherService.getClass().getName() + "[" + weatherService + "]");

            System.out.println("Servidor de Clima pronto e em execução...");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
