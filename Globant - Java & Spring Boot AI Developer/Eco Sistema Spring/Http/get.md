# HTTP GET

O método **GET** é usado para **buscar dados** de um servidor.

## Características
- Não altera dados (somente leitura)
- Parâmetros enviados pela URL
- Pode ser cacheado

## Exemplo

```json
GET /usuarios?id=1 HTTP/1.1
Host: api.exemplo.com
```

```js
fetch('https://api.exemplo.com/usuarios?id=1')
  .then(res => res.json())
  .then(data => console.log(data));
```