

public class Main{
    public static void main(String[] args){
        var person = new Person("Felipe",18);
        System.out.println("Prints fora do Records:");
        System.out.println(person);
        System.out.println(person.name()); //É um "getName", mas no record tem que ser por metodos(Função)
        System.out.println(person.age());
        System.out.println("=====");
        System.out.println("'Overide' no Records:");
        System.out.println(person.getInfo());
        System.out.println("=====");
        System.out.println("Construtor secundario:");
        var person2 = new Person("Ana");
        System.out.println("Prints fora do Records:");
        System.out.println(person2.name());
        System.out.println(person2.age());
    }
}
