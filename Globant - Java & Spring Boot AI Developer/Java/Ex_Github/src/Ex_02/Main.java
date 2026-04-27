package Ex_02;
import java.util.Scanner;

public class Main {

    public static void tabuada(int numero) {
        System.out.println("Tabuada do " + numero);
        for (int i = 0; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }

    public static void calcularIMC(double peso, double altura) {
        double imc = peso / (altura * altura);

        System.out.println("IMC: " + imc);

        if (imc <= 18.5) {
            System.out.println("Abaixo do peso");
        }
        else{
            if (imc <= 24.9) {
                System.out.println("Peso ideal");
            }
            else{
                if (imc <= 29.9) {
                    System.out.println("Levemente acima do peso");
                }
                else{
                    if (imc <= 34.9) {
                        System.out.println("Obesidade Grau I");
                    }
                    else{
                        if (imc <= 39.9) {
                            System.out.println("Obesidade Grau II (Severa)");
                        }
                        else {
                            System.out.println("Obesidade III (Mórbida)");
                        }
                    }
                }

            }

        }
    }

    public static void intevalo(int n1, int n2, String tipo) {
        System.out.println("Resultado:");
        for (int i = n2; i >= n1; i--) {
            if (tipo.equalsIgnoreCase("par") && i % 2 == 0) {
                System.out.print(i + " ");
            } else if (tipo.equalsIgnoreCase("impar") && i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void Divisao(int primeiro, Scanner input) {
        int numero;
        System.out.println("Digite numeros (para parar, resto diferente de 0):");
        while (true) {
            numero = input.nextInt();

            if (numero < primeiro) {
                continue; // ignora
            }

            if (numero % primeiro != 0) {
                System.out.println("Parou! Número não divisível por " + primeiro);
                break;
            }

            System.out.println(numero + " é divisível por " + primeiro);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //01
        System.out.print("Digite um numero para a tabuada: ");
        int num = input.nextInt();
        tabuada(num);

        //02
        System.out.print("Digite seu peso: ");
        double peso = input.nextDouble();

        System.out.print("Digite sua altura: ");
        double altura = input.nextDouble();
        calcularIMC(peso, altura);

        //03
        System.out.print("Digite o primeiro numero: ");
        int n1 = input.nextInt();

        System.out.print("Digite o segundo numero: ");
        int n2 = input.nextInt();

        input.nextLine();
        System.out.print("Escolhar (par/impar): ");
        String tipo = input.nextLine();
        intevalo(n1, n2, tipo);

        // 4
        System.out.print("Digite o número inicial: ");
        int primeiro = input.nextInt();
        Divisao(primeiro, input);
    }
}
