/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RMI3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface WeatherService extends Remote {
    String getWeather(String city) throws RemoteException;
}

