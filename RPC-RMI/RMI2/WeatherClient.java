/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI3;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class WeatherClient {
    public static void main(String[] args) {
        try {
            // Obtém uma referência para o registro RMI no servidor
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Busca o objeto remoto pelo nome
            WeatherService weatherService = (WeatherService) registry.lookup("WeatherService");

            // Invoca os métodos remotos
            String weather1 = weatherService.getWeather("Sao Paulo");
            System.out.println(weather1);

            String weather2 = weatherService.getWeather("Florianopolis");
            System.out.println(weather2);

        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}