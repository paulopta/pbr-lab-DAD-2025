
package RMI;

import java.rmi.Naming;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Localiza o serviço remoto
            Calculator calc = (Calculator) Naming.lookup("rmi://localhost:1099/CalcService");

            Scanner sc = new Scanner(System.in);
            System.out.println("Cliente RMI conectado ao servidor!");
            System.out.println("Escolha uma operação: soma, subtracao, multiplicacao, divisao");

            String op = sc.nextLine();
            System.out.print("Digite o primeiro número: ");
            double n1 = sc.nextDouble();
            System.out.print("Digite o segundo número: ");
            double n2 = sc.nextDouble();

            double resultado = 0;
            switch (op.toLowerCase()) {
                case "soma": resultado = calc.soma(n1, n2); break;
                case "subtracao": resultado = calc.subtracao(n1, n2); break;
                case "multiplicacao": resultado = calc.multiplicacao(n1, n2); break;
                case "divisao": resultado = calc.divisao(n1, n2); break;
                default: System.out.println("Operação inválida");
            }

            System.out.println("Resultado: " + resultado);
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
