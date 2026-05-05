# @Compponents

- ``@Component`` no Spring Boot é uma anotação usada para marcar uma classe como um bean gerenciado automaticamente pelo Spring.

## Resumo:

- Indica que a classe deve ser ``detectada`` pelo`` component scan``,o Spring cria e gerencia a instância automaticamente, evita precisar declarar manualmente com @Bean.

## Como usar:

- Coloque ``@Component`` na classe,o Spring encontra essa classe e registra como bean no contexto.

```java
@Component
public class Calculadora {

    public int somar(int a, int b) {
        return a + b;
    }
}
```

---

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