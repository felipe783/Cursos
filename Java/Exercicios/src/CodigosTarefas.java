import java.util.Scanner;

public class CodigosTarefas {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // Lê a linha de códigos de tarefas e separa em um array
        String[] codigos = scanner.nextLine().split(" ");

        // Lê o código de tarefa a ser buscado
        String codigoBuscado = scanner.nextLine();
        int contador = 0;
        // TODO: Percorra o array 'codigos' e incremente 'contador' sempre que encontrar 'codigoBuscado'
        for(String s:codigos){
            if(s.equals(codigoBuscado)){
                contador++;
            }
            else{
                continue;
            }
        }
        // Imprima o resultado
        System.out.println(contador);

        scanner.close();
    }
}
