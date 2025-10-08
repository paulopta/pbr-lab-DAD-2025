/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RPC;

import java.io.*;
import java.net.*;

public class CalculatorServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor RPC iniciado na porta 12345...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado!");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Lê requisição do cliente
                String request = in.readLine();
                System.out.println("Requisição recebida: " + request);

                // Processa requisição
                String[] parts = request.split(" ");
                String operacao = parts[0];
                double num1 = Double.parseDouble(parts[1]);
                double num2 = Double.parseDouble(parts[2]);
                double resultado = 0;

                switch (operacao.toLowerCase()) {
                    case "soma":
                        resultado = num1 + num2;
                        break;
                    case "subtracao":
                        resultado = num1 - num2;
                        break;
                    case "multiplicacao":
                        resultado = num1 * num2;
                        break;
                    case "divisao":
                        if (num2 != 0)
                            resultado = num1 / num2;
                        else
                            out.println("Erro: divisão por zero");
                        break;
                    default:
                        out.println("Operação inválida");
                        continue;
                }

                // Retorna resultado
                out.println("Resultado: " + resultado);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

