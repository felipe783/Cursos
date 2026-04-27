package Ex_01;
import java.util.Scanner;

public class Main {

    public static String Ex_01(String nome,int ano,int anoAtual){
        int resultado;
        resultado = anoAtual - ano;
        return  "Olá " + nome + " você tem " + resultado + " anos";
    }

    public static void Areas(double Lad_Qd, double base_Ret, double altura_Ret){
        System.out.println("Area Quadrado: " + Lad_Qd*Lad_Qd);
        System.out.println("Area Retangulo: " + base_Ret*altura_Ret);
    }

    public static String Ex_04(String nome, int idade, String nome2, int idade2){
        int diferenca = Math.abs(idade - idade2); ;
        return "Diferença de idade entre " + nome + " e " + nome2 + " é de " + diferenca + " anos";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //01
        System.out.println("Digite seu nome: ");
        String nome = input.nextLine();

        System.out.println("Digite seu ano de nascimento: ");
        int ano = input.nextInt();

        System.out.println(Ex_01(nome,ano,2026));

        //02 e 03
        System.out.println("Lado do quadrado: ");
        double lado = input.nextDouble();

        System.out.println("Digite a base do retangulo:");
        double base = input.nextDouble();

        System.out.println("Digite a altura do retangulo:");
        double altura = input.nextDouble();

        Areas(lado,base,altura);

        //04
        input.nextLine();

        System.out.println("Nome da primeira pessoa: ");
        String nomeP = input.nextLine();

        System.out.println("Idade da primeira pessoa: ");
        int idade = input.nextInt();

        input.nextLine();

        System.out.println("Nome da segunda pessoa: ");
        String nome2 = input.nextLine();

        System.out.println("Idade idade da segunda pessoa: ");
        int idade2 = input.nextInt();

        System.out.println(Ex_04(nomeP,idade,nome2,idade2));
    }
}
