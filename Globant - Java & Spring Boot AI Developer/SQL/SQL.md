# Formatador de SQL

* Apenas uma ferramenta para deixar os códigos SQL mais bonitos.
* [Link](https://codebeautify.org/sqlformatter)

---

# Comentário em SQL

```sql
-- SELECT * FROM tbl_books
```

* O comentário em SQL é feito com `--`.

---

# SELECT

## ⚒️ Pra que serve
* Selecionar e exibir dados de uma tabela.

## 💻 Exemplos de código

```sql
SELECT * FROM tbl_games;
SELECT id, title FROM tbl_books;
```

* `SELECT * FROM` seleciona todos os dados da tabela.
* `SELECT id, title` seleciona apenas as colunas `id` e `title` da tabela `tbl_books`.

### WHERE

```sql
SELECT nome, preco FROM jogos WHERE genero = 'RPG';
```

* Seleciona apenas os dados `nome` e `preco` da tabela `jogos` onde `genero` é `RPG`.

### ORDER BY

```sql
SELECT * FROM tabela ORDER BY id ASC;
```

* Seleciona todos os dados de uma tabela.
* `ORDER BY id ASC` ordena os resultados pelo `id` em ordem crescente.

### Exemplo com ORDER BY e WHERE

```sql
SELECT * FROM tbl_games
WHERE rankNumber IS NOT NULL
ORDER BY rankNumber ASC;
```

* Seleciona todos os dados apenas quando `rankNumber` não é `NULL`.
* `ORDER BY` organiza os resultados por `rankNumber` em ordem crescente.

### LIMIT

* Restringe a quantidade de resultados.

```sql
SELECT * FROM show LIMIT 10;
```

* Mostra apenas os 10 primeiros resultados.

### GROUP BY

```sql
SELECT brand, COUNT(*)
FROM shoes
GROUP BY brand;
```

* Agrupa os registros pela coluna `brand`.
* `COUNT(*)` conta quantos registros existem em cada grupo.

### DISTINCT

```sql
SELECT DISTINCT brand FROM shoes;
```

* Remove valores duplicados e retorna apenas valores únicos.

### AS (alias)

```sql
SELECT name AS modelo, price AS preco FROM shoes;
```

* Dá um apelido para colunas ou tabelas.
* `name AS modelo` faz a coluna `name` aparecer com o nome `modelo`.

### IN, NOT IN, BETWEEN, LIKE, ILIKE

```sql
SELECT * FROM shoes WHERE brand IN ('Nike', 'Adidas');
SELECT * FROM shoes WHERE price BETWEEN 300 AND 800;
SELECT * FROM shoes WHERE brand ILIKE '%air%';
```

* `IN` verifica se o valor está dentro de uma lista.
* `BETWEEN` verifica se o valor está dentro de um intervalo.
* `LIKE` faz busca por padrão.
* `ILIKE` faz a mesma busca de `LIKE`, mas ignorando maiúsculas e minúsculas.

---

# Funções de Agregação

## COUNT(), AVG(), SUM(), MIN(), MAX()

```sql
SELECT AVG(price) AS preco_medio FROM shoes;
SELECT MAX(release_date) AS mais_recente FROM shoes;
```

* `COUNT()` conta registros.
* `AVG()` calcula a média.
* `SUM()` soma valores.
* `MIN()` retorna o menor valor.
* `MAX()` retorna o maior valor.

---

# INSERT

## ⚒️ Pra que serve
* Adicionar novos dados em uma tabela ou banco de dados.

## 💻 Exemplos de código

```sql
INSERT INTO tbl_product(name) VALUES ('super teclado vermelho');
```

* Insere um novo registro na tabela `tbl_product`.
* Apenas a coluna `name` é informada.
* O `id` pode ser gerado automaticamente por causa da constraint.

```sql
INSERT INTO tbl_books(title, pages, author) VALUES ('Solo Leveling', 200, 'Chugong');
```

* Insere um novo registro na tabela `tbl_books`.
* As colunas informadas são `title`, `pages` e `author`.

---

# UPDATE

> Sempre lembre do `WHERE`, senão irá atualizar tudo.

## ⚒️ Pra que serve
* Atualizar dados de uma tabela.

## 💻 Exemplos de código

```sql
UPDATE jogos SET preco = 99.90 WHERE nome = 'Elden Ring';
UPDATE tbl_games SET bestWeeks = 3 WHERE id = 1;
UPDATE tbl_games SET bestWeeks = 4, bannerUrl = 'abc' WHERE id = 1;
```

* Atualiza o valor da coluna `preco` na tabela `jogos`.
* `WHERE` define qual registro será alterado.
* Também é possível atualizar mais de uma coluna ao mesmo tempo.

---

# DELETE

> Sem o `WHERE`, você pode excluir tudo por acidente.

## ⚒️ Pra que serve
* Remover dados de uma tabela.

## 💻 Exemplos de código

```sql
DELETE FROM tbl_games WHERE nome = 'Elden Ring';
DELETE FROM jogos WHERE id = 3;
```

* Remove o registro da tabela indicada.
* `WHERE` define qual registro será excluído.

---

# CREATE

## CREATE DATABASE

```sql
CREATE DATABASE db_publisher
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
```

* Cria um banco de dados com o nome `db_publisher`.
* `WITH` define propriedades do banco.
* `OWNER` define o dono do banco ou quem pode acessá-lo.
* `ENCODING` define a codificação de caracteres.
* `CONNECTION LIMIT` define o limite de conexões.
* `-1` significa que não há limite.

## CREATE TABLE

```sql
CREATE TABLE tbl_books(
    id SERIAL PRIMARY KEY,
    title VARCHAR(80) NOT NULL,
    publisher VARCHAR(80),
    description TEXT,
    isbn INTEGER,
    pages INTEGER NOT NULL,
    author VARCHAR(80) NOT NULL,
    isNew BOOLEAN DEFAULT TRUE,
    price NUMERIC(5,2)
);
```

* `CREATE TABLE` cria uma nova tabela no banco de dados.
* `tbl_books` é o nome da tabela.

### Colunas

* `id` → identificador único do livro.
  * `SERIAL` → auto incremento automático.
  * `PRIMARY KEY` → chave primária da tabela.
  * Mesmo se uma query falhar, o número do `id` pode ser pulado.
  * Isso acontece porque a sequência (`SEQUENCE`) é incrementada antes da confirmação da operação.
  * Ou seja, o banco não volta atrás no contador mesmo com erro ou `ROLLBACK`.

* `title`, `publisher` e `author` → campos com limite de 80 caracteres (`VARCHAR(80)`).
  * `NOT NULL` → o campo não pode ser vazio (`NULL`).
  * No caso de `title` e `author`, essa restrição é obrigatória.

* `description` → definido como `TEXT`, ou seja, texto sem limite fixo de caracteres.

* `isbn` → definido como `INTEGER`, ou seja, um número inteiro.

* `pages`
  * `INTEGER` → número inteiro.
  * `NOT NULL` → campo obrigatório.

* `isNew`
  * `BOOLEAN` → valor lógico.
  * `DEFAULT TRUE` → valor padrão será `TRUE`.

* `price`
  * `NUMERIC` → tipo numérico com casas decimais.
  * `(5,2)` → até 5 dígitos no total, sendo 2 casas decimais.
  * Exemplo: `5.20`, `78.60`.

---

# DROP TABLE

```sql
DROP TABLE tbl_books;
```

* Deleta a tabela indicada.

---

# ALTER TABLE

```sql
ALTER TABLE tbl_books RENAME COLUMN isdn TO isbn;
```

* `ALTER TABLE` altera uma tabela.
* `RENAME COLUMN` renomeia uma coluna.
* `isdn` é o nome atual da coluna.
* `TO isbn` é o novo nome da coluna.

---

# CONSTRAINTS

* São regras aplicadas a colunas ou tabelas para garantir a integridade dos dados.

## Exemplo 1

```sql
ALTER TABLE IF EXISTS public.tbl_product
ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY
(INCREMENT 1 START 1);
```

* Altera a coluna `id` da tabela `tbl_product`.
* Define a coluna como auto incremento (`IDENTITY`).
* `START 1` → começa em 1.
* `INCREMENT 1` → incrementa de 1 em 1.
* `GENERATED ALWAYS` → o valor do `id` é sempre gerado automaticamente pelo banco.

## Exemplo 2

```sql
ALTER TABLE public.tbl_product
ALTER COLUMN nome TYPE VARCHAR(30)
COLLATE pg_catalog."default";
```

* Altera o tipo da coluna `nome`.
* Define um limite de até 30 caracteres.
* `COLLATE` define regras de comparação e ordenação de texto.