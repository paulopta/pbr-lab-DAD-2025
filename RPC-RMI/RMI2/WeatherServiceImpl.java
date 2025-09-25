/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class WeatherServiceImpl extends UnicastRemoteObject implements WeatherService {

    // Simula um banco de dados de dados meteorológicos
    private Map<String, String> weatherData;

    public WeatherServiceImpl() throws RemoteException {
        super(); // Chama o construtor da classe pai (UnicastRemoteObject)
        weatherData = new HashMap<>();
        weatherData.put("Sao Paulo", "Nublado, 20°C");
        weatherData.put("Rio de Janeiro", "Ensolarado, 28°C");
        weatherData.put("Curitiba", "Chuvoso, 15°C");
    }

    @Override
    public String getWeather(String city) throws RemoteException {
        String data = weatherData.get(city);
        if (data != null) {
            return "Previsão para " + city + ": " + data;
        } else {
            return "Dados de previsão não disponíveis para " + city;
        }
    }
}
