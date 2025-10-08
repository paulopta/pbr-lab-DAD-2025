
package RPC;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CalculatorClient {
    
    public static void main(String[] args) {
        
        try (Socket socket = new Socket("localhost", 12345)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            System.out.println("Cliente RPC conectado ao servidor!");
            System.out.println("Digite operação no formato: operacao num1 num2");
            System.out.println("Exemplo: soma 10 20");

            String request = sc.nextLine();
            out.println(request);

            String response = in.readLine();
            System.out.println("Resposta do servidor: " + response);

            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
