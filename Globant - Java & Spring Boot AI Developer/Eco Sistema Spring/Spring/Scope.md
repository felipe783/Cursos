# @Scope('prototype')

- ``@Scope('prototype')`` define que um bean terá uma nova instância a cada vez que for solicitado, diferente do padrão (singleton), que usa a mesma instância sempre.

## Resumo:

- Cria um novo objeto a cada injeção/uso,usado quando você precisa de objetos independentes,``funciona junto`` com ``@Component`` ou ``@Bean``.

## Como usar:

- `Adicione` @Scope("prototype") na classe do bean.

## Exemplo:


```java
@Component
@Scope("prototype")
public class Calculadora {

    private int contador = 0;

    public int somar(int a, int b) {
        contador++;
        return a + b;
    }

    public int getContador() {
        return contador;
    }
}
```

---

```java
@Service
public class MeuServico {

    @Autowired
    private Calculadora calc1;

    @Autowired
    private Calculadora calc2;

    public void executar() {
        calc1.somar(1, 2);
        calc2.somar(3, 4);

        System.out.println(calc1.getContador()); // 1
        System.out.println(calc2.getContador()); // 1
    }
}
```java