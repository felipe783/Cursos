# @Value

- ``@Value`` no Spring Boot é usado para injetar valores em variáveis, geralmente vindos do application.properties ou application.yml.


## Resumo:

- Injeta valores diretamente em atributos,
- Pode ler propriedades externas ou valores fixos,
- Suporta expressões (${} para propriedades, #{} para SpEL).

## Como usar:

- Use ``@Value`` no atributo ou construtor.
- Informe a chave da propriedade.


Exemplo (application.properties):
```
app.nome=MinhaApp
app.versao=1.0
```
```java
app.nome=MinhaAppapp.versao=1.0
Classe usando @Value:
import org.springframework.beans.factory.annotation.Value;import org.springframework.stereotype.Component;@Componentpublic class ConfigApp {    @Value("${app.nome}")    private String nome;    @Value("${app.versao}")    private String versao;    public void exibir() {        System.out.println(nome + " - " + versao);    }}
Exemplo com valor padrão:
@Value("${app.descricao:Sem descrição}")private String descricao;
```

- Se a ``propriedade não existir``, ele ``usa "Sem descrição".``