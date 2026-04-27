public record Person(String name, int age) {

    //TODO: O record é um objeto imutavel, é um jeito de trabalhar com objetos mas ele sendo imutavel
    //Pra mudar algo nele tem que declarar outro objeto
    //So propriedades estaticas

    public Person{ //Quando declarar o objeto ele vai rodar isso daqui primeiro
        //TODO: Pode ser usado pra regras de negocios,validação
        System.out.println("=====");
        System.out.println("Nome:" + name);
        System.out.println("Idade:" + age);
        System.out.println("=====");
    }

    public Person(String name){ //Subclasse
        this(name, 19);
    }

    public String getInfo(){
        return "\uD83E\uDD76\uD83D\uDD25Nome: " + name + "\n\uD83C\uDF82\uD83D\uDCC6Idade: " + age;
    }
}
