/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // Cria instância da calculadora
            Calculator calc = new CalculatorImpl();

            // Inicia registro RMI na porta 1099
            LocateRegistry.createRegistry(1099);

            // Registra o objeto remoto com nome "CalcService"
            Naming.rebind("rmi://localhost:1099/CalcService", calc);

            System.out.println("Servidor RMI pronto!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
