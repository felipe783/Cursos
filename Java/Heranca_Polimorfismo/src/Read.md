# 📚 Resumo Básico de POO

[Exercios](https://github.com/digitalinnovationone/exercicios-java-basico/tree/main/exercicios)

---

## 🧬 HERANÇA 
Uma classe pode usar coisas de outra.  
É como se uma "filha" aproveitasse o que a "mãe" já tem.  
Evita repetir código e deixa tudo mais simples.

### 💻 Termos técnicos
- Permite que uma classe **herde atributos e métodos** de outra
- Usa a palavra-chave `extends`
- Promove **reutilização de código**
- Cria uma relação de hierarquia entre classes

---

## 🔄 POLIMORFISMO
Um mesmo tipo pode se comportar de jeitos diferentes.  
Você usa ele de forma geral, mas por trás cada um age do seu próprio jeito.

### 💻 Termos técnicos
- Um objeto pode ser referenciado por um tipo mais genérico
- Exemplo: `domain.Employee manager = new domain.Manager();`
- Em tempo de compilação, só acessa métodos da classe base
- Em tempo de execução, usa a implementação da classe real
- Relacionado a **sobrescrita de métodos (override)**

---

## 🧱 CLASSE ABSTRATA 
É um modelo base.  
Não pode ser usado direto, só serve pra outras classes usarem.

### 💻 Termos técnicos
- Declarada com `abstract`
- Não pode ser instanciada
- Pode ter métodos abstratos (sem implementação)
- Deve ser herdada por outras classes
- Serve como base para especializações

---

## 🚫 FINAL 
Essa classe não pode ser usada como base pra outras.  
Ela é o fim da linha.

### 💻 Termos técnicos
- Declarada com `final`
- Impede que a classe seja herdada (`extends`)
- Também pode ser usada em métodos e variáveis
- Garante que o comportamento não será alterado

---

## 🔒 SEALED
Só algumas classes podem usar ela como base.  
Você controla quem pode usar.

### 💻 Termos técnicos
- Declarada com `sealed`
- Usa `permits` para definir quais classes podem herdar
- Restringe a hierarquia de herança
- As subclasses devem ser:
    - `final`
    - `sealed`
    - ou `non-sealed`
- Introduzido no Java moderno (Java 17+)

---

## 💡 Observação
Esses conceitos ajudam a organizar melhor o código,  
evitar repetição e deixar tudo mais fácil de manter.

## 🔥 RESUMO 

- `extends` → herança entre classes
- `super` → acessa coisas da classe pai
- Polimorfismo → um tipo, vários comportamentos
- Cada objeto responde do seu próprio jeito

Isso deixa o código mais:
- reutilizável
- organizado
- fácil de expandir 🚀