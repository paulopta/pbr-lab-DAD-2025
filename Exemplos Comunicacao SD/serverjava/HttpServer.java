/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverjava;

import java.io.*;
import java.net.*;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Porta 8080
        System.out.println("Servidor iniciado na porta 8080");

        while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado");
                
                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String line;
                while ((line = reader.readLine()) != null && !line.isEmpty()) {
                    System.out.println(line);
                }
                
                String response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html\r\n" +
                        "\r\n" +
                        "<html><body><h1>Hello, World!</h1></body></html>";
                output.write(response.getBytes());
                
                output.close();
                input.close();
            
            System.out.println("Cliente desconectado");
        }
    }
}