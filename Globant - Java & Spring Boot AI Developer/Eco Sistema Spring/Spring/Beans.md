# Bean

``@Bean`` no Spring Boot é uma anotação usada para declarar manualmente um objeto que será gerenciado pelo container do Spring (IoC). Em vez de deixar o Spring criar automaticamente, você define explicitamente como o objeto deve ser instanciado.

## Resumo:

-`` Marca um método`` que retorna um ``objeto gerenciado pelo Spring``, o objeto vira um “bean” dentro do contexto da aplicação,usado quando você precisa de controle sobre a criação do objeto (ex: classes de terceiros).

- Basicamente ``@Bean`` é usado quando você ``não sabe o codigo fonte da função(algo de terceiros)``, já o ``@Compponent`` você sabe como é o codigo fonte

## Como usar:

- Coloque ``@Bean`` em um método dentro de uma classe anotada com ``@Configuration``,o método retorna o objeto que você quer gerenciar.

```java
@Configuration
public class AppConfig {

    @Bean
    public Calculadora calculadora() {
        return new Calculadora();
    }
}
```
- Usando o bean em outro lugar:
```java
@Service
public class MeuServico {

    @Autowired
    private Calculadora calculadora;

    public int somar(int a, int b) {
        return calculadora.somar(a, b);
    }
}
```

## Boa Prática:

- Crie uma pasta/Classe chamada Beans ou algo parecido para armazenar eles