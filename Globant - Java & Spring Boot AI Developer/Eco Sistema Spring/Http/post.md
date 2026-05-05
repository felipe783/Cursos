# HTTP POST

O método **POST** é usado para **enviar dados** ao servidor.

## Características
- Pode criar ou alterar dados
- Dados enviados no corpo (body)
- Não é cacheado

## Exemplo

```json
POST /usuarios HTTP/1.1
Host: api.exemplo.com
Content-Type: application/json

{
  "nome": "Felipe",
  "idade": 20
}
```

```js
fetch('https://api.exemplo.com/usuarios', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({
    nome: 'Felipe',
    idade: 20
  })
})
.then(res => res.json())
.then(data => console.log(data));
```