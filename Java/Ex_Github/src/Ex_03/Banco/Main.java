package Ex_03.Banco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int opcao = 0;
        System.out.println("----");
        //System.out.println("1 - Criar conta");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("----");

        Conta conta = new Conta(500, 200);

        while(true){
            switch(opcao){
                /*
                case 1:
                    System.out.println("Digite o valor inicial da conta: ");
                    double inicial = input.nextDouble();
                    System.out.println("Digite o valor base para cheque especial: ");
                    double cheque = input.nextDouble();
                    Conta conta = new Conta(inicial, cheque);
                    System.out.println("Conta criada com sucesso");
                    break;

               */
                case 2:
                    System.out.println("Quanto deseja sacar?");
                    double sacar = input.nextDouble();
                    conta.setSaldo(conta.getSaldo() - sacar);
                    if(conta.getSaldo()<=0){ //Usou o cheque especial
                        conta.setUsando(true);
                    }
                    break;
                case 3:
                    System.out.println("Quanto deseja Depositas?");
                    double deposito = input.nextDouble();
                    if (conta.getSaldo() >= 0) { //Para de usar pq a conta saiu do vermelho
                        conta.setUsando(false);
                    }
                    break;
            }
        }

    }
}