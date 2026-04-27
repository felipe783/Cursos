# 📚 Sobrescrita e Sobrecarga (Java)

[Exercios](https://github.com/digitalinnovationone/exercicios-java-basico/tree/main/exercicios)

---

## 🔁 SOBRESCRITA (Override)

A sobrescrita acontece quando uma classe filha muda o comportamento de um método que já existe na classe pai.

Ou seja:
- O método já existe
- A classe filha cria uma nova versão dele
- O nome e a assinatura são os mesmos

### 💡 Ideia principal
Você mantém o mesmo método, mas muda o que ele faz dependendo da classe.

### 📌 Características
- Usa `@Override`
- Mesmo nome e mesmos parâmetros
- Executa um comportamento diferente do original
- Funciona junto com polimorfismo

---

## ➕ SOBRECARGA (Overload)

A sobrecarga acontece quando existem vários métodos com o mesmo nome, mas com diferenças nos parâmetros.

Ou seja:
- Mesmo nome de método
- Parâmetros diferentes (quantidade ou tipo)

### 💡 Ideia principal
Você cria várias formas de usar o mesmo método.

### 📌 Características
- Mesmo nome
- Parâmetros diferentes
- Pode mudar retorno, mas não é obrigatório
- Não precisa de herança

---

## ⚖️ DIFERENÇA ENTRE OS DOIS

| Conceito      | O que muda                 | Precisa de herança? |
|--------------|---------------------------|---------------------|
| Sobrescrita  | Comportamento do método   | Sim                 |
| Sobrecarga   | Parâmetros do método      | Não                 |

---

## 🚀 RESUMÃO

- **Sobrescrita** → muda o que o método faz
- **Sobrecarga** → muda como o método é chamado

---

## 💡 Conclusão

Esses dois conceitos ajudam a deixar o código:
- mais flexível
- mais organizado
- mais reutilizável

E são base pra escrever código mais limpo e profissional 😎🤙