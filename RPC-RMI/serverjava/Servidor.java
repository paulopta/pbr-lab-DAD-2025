/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverjava;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        int porta = 12345;
        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("Servidor ouvindo na porta " + porta);
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Recebido do cliente: " + inputLine);
                        out.println("Servidor recebeu: " + inputLine);
                    }
                } catch (IOException e) {
                    System.err.println("Erro na conexão com o cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Não foi possível ouvir na porta: " + porta + ", " + e.getMessage());
            System.exit(-1);
        }
    }
}