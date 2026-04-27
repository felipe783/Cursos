import java.util.Scanner;

public class NomeIdade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();

        // TODO: Divida a entrada em nome e idade, e valide se o nome não está vazio e a idade é maior ou igual a 18.
        // Dica: Use split para separar os dados e operadores lógicos para validar as condições.
        try{
            String[] texto = entrada.split(" ");
            if(texto[0] == null){
                System.out.println("Cadastro reprovado");
            }
            int numero = Integer.parseInt(texto[1]);

            if(numero>=18){
                System.out.println("Cadastro aprovado");
            }
            else{
                System.out.println("Cadastro reprovado");
            }
        }
        catch(Exception e){
            System.out.println("Cadastro reprovado");
        }
        scanner.close();
    }
}