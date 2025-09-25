/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sockets;

import client.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulo
 */
public class ClientJava {
    
    public static void main(String[] args) {
        String host = "localhost", host_name="", ip="";
        int porta = 12345;
        try {
            host_name = InetAddress.getLocalHost().getHostName();
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClientJava.class.getName()).log(Level.SEVERE, null, ex);
        }            

        try (Socket socket = new Socket(host, porta);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Dados: HOST: " + host_name + " - IP:" + ip);
            System.out.println("Conectado ao servidor em " + host + ":" + porta);            

            String userInput;
            while (true) {
                System.out.print("Digite uma mensagem (ou 'bye' para sair): ");
                userInput = scanner.nextLine();
                if ("bye".equalsIgnoreCase(userInput)) {
                    break;
                }
                userInput = "Mensagem: "+ userInput + " - HOST: " + host_name + " - IP: " +ip;
                out.println(userInput);
                String response = in.readLine();
                System.out.println("Resposta do servidor: " + response);
            }
            System.out.println("Desconectado do servidor.");

        } catch (UnknownHostException e) {
            System.err.println("Host desconhecido: " + host);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Erro na conexão com o servidor: " + e.getMessage());
            System.exit(1);
        }
    }
}
