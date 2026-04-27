import java.util.Scanner;

public class Commands {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String comando = scanner.nextLine();

        // TODO: Verifique se o comando é exatamente "START", "STOP" ou "RESTART" e imprima a resposta apropriada
        if(comando.equals("START") || comando.equals("STROP") || comando.equals("RESTART")){
            System.out.println("Command accepted");
        }
        else{
            System.out.println("Command rejected");
        }
        scanner.close();
    }
}
