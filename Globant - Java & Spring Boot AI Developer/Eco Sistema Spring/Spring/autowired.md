# @Autowired

- ``@Autowired`` no Spring Boot é usado para fazer ``injeção de dependência automática``. Ele diz ao Spring para encontrar um bean compatível e injetá-lo na classe.

## Resumo:

- Injeta automaticamente um bean gerenciado pelo Spring,evita ``criar objetos`` manualmente ``com new``,funciona por tipo (por padrão).

## Como usar:

- Pode ser usado em atributos, construtores ou métodos setters,o Spring resolve e injeta a dependência automaticamente.
- Exemplo (injeção por atributo):

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

Exemplo (injeção por construtor - recomendado):

```java
@Service
public class MeuServico {

    private final Calculadora calculadora;

    public MeuServico(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    public int somar(int a, int b) {
        return calculadora.somar(a, b);
    }
}
```