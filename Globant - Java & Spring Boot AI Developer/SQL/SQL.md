# Formatador de SQL

- Apenas uma Ferramenta pra deixar os codigos SQL mais bonitos
- [Link](https://codebeautify.org/sqlformatter)
 
---

# Comentário em SQL

```sql
-- SELECT * FROM tbl_books
```

* O comentário em SQL é feito com `--`

---

# SELECT

## ⚒️ Pra que serve
- Selecionar e exibir dados de uma tabela

## 💻 Exemplos de código

```sql
SELECT * FROM tbl_games 
SELECT id, title FROM tbl_books;
```

* ``Select * FROM`` seleciona todos os dados da tabela
* Seleciona os dados `id` e `title` da tabela `tbl_books`

### WHERE

```sql
SELECT nome, preco FROM jogos WHERE genero = 'RPG';
```

* Seleciona apenas os dados: ``nome,preco`` na tabela ``jogos`` onde o ``genero é RPG`` 

### Order By

```sql
SELECT * FROM tabela ORDER BY id ASC;
```

* Seleciona todos os dados de uma tabela
* `ORDER BY id ASC` ordena os resultados pelo ID de forma ``crescente(ASC)``

### Ex com ORDER BY e WHERE:

```sql
SELECT * FROM tbl_games 
WHERE 
	rankNumber is not null;
ORDER BY
	rankNumber ASC
```

* Selecionar ``todos os dados(*)`` apenas onde o ``rankNumber`` não é ``NULL``
* ``ODER BY`` e ordena por ``ASC(ascendente)``

### Limit

* Restrige número de Resultados

```sql
SELECT * FROM show LIMIT 10
```

* Vai so mostrar 10 primeiros resutlados

### GROUP BY
```sql
SELECT brand, COUNT(*)
FROM shoes 
GROUP BY brand
```

### DISTINCT

* Remove registros duplicados

```sql
SELECT DISTINCT brand FROM shoes;
```

### AS(alias)

```sql
SELECT name AS modelo, price AS price FROM shoes;
```

* da um ``apelido`` pra ``coluna/tabela``

### IN,NOT IN,BETWEEN, LIKE, ILIKE

```sql
SELECT * FROM shoes WHERE brand IN ('Nike', 'Adidas');
SELECT * FROM shoes WHERE price BETWEEN 300 AND 800;
SELECT * FROM shoes WHERE brand ILIKE '%air%';
```

# Função de Agreções


---

# INSERT

## ⚒️ Pra que serve
- Adicionar novos dados em uma tabela ou banco de dados

## 💻 Exemplos de código

```sql
INSERT INTO tbl_product(name) VALUES ('super teclado vermelho');
```

* Insere um novo registro na tabela `tbl_product`
* Apenas a coluna `name` é informada
* O `id` pode ser gerado automaticamente por causa da constraint

```sql
INSERT INTO tbl_books(title, pages, author) VALUES ('Solo Leveling', 200, 'Chugong');
```

* Insere um novo registro na tabela `tbl_books`
* As colunas informadas são `title`, `pages` e `author`

---

# UPDATE
> Sempre lembra do ``WHERE``, senão ira atualizar tudo 

## ⚒️ Pra que serve
- Atualizar dados de uma tabela

## 💻 Exemplo de código

```sql
UPDATE jogos SET preco = 99.90 WHERE nome = 'Elden Ring';
UPDATE tbl_games SET bestWeeks = 3 WHERE id = 1;
UPDATE tbl_games SET bestWeeks = 4,bannerUrl = 'abc' WHERE id = 1; --Atualizar mais de uma coluna
```

* Atualiza o valor da coluna `preco` na tabela `jogos`
* `WHERE` define qual registro será alterado

---

# DELETE

> Sem o `WHERE`, você pode excluir tudo por acidente.

## ⚒️ Pra que serve
- Remover dados de uma tabela

## 💻 Exemplo de código

```sql
DELETE FROM tbl_games WHERE nome = 'Elden Ring';
DELETE FROM jogos WHERE id = 3;
```

* Remove o registro da tabela `jogos`
* `WHERE` define qual registro será excluído

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

* Cria um banco de dados com o nome `db_publisher`
* `WITH` → define as propriedades do banco
* `OWNER` → dono do banco ou quem pode acessá-lo
* `ENCODING` → sistema de codificação de caracteres
* `CONNECTION LIMIT` → limite de conexão
* `-1` → significa que não há limite

## CREATE TABLE

```sql
CREATE TABLE tbl_books(
	id SERIAL PRIMARY KEY,
	title VARCHAR(80) NOT NULL,
	publisher VARCHAR(80),
	description TEXT,
	isbn INTEGER,
	pages INTEGER NOT NULL,
	author VARCHAR(80) NOT NULL
    isNew boolean DEFAULT TRUE,
    price NUMERIC(5,2)
);
```

* `CREATE TABLE` → cria uma nova tabela no banco de dados
* `tbl_books` → nome da tabela

### Colunas

* `id` → identificador único do livro
  * `SERIAL` → auto incremento automático
  * `PRIMARY KEY` → chave primária da tabela
  * Mesmo se uma `QUERY` falhar, o número do `id` pode ser pulado
  * Isso acontece porque a sequência (`SEQUENCE`) é incrementada antes da confirmação da operação
  * Ou seja, o banco não volta atrás no contador mesmo com erro ou `ROLLBACK`

* `title`, `publisher` e `author` → campos com limite de 80 caracteres (`VARCHAR(80)`)
  * `NOT NULL` → o campo não pode ser vazio (`NULL`)
  * No caso de `title` e `author`, essa restrição é obrigatória

* `description` → definido como `TEXT`, ou seja, texto sem limite fixo de caracteres

* `isbn` → definido como `INTEGER`, ou seja, um número inteiro

* `pages` 
  * `INTEGER` → número inteiro
  * `NOT NULL` → campo obrigatório

* `isNew` 
  * `boolean` → valor Booleano
  *`DEFAULT TRUE` → o ``valor padrão`` será ``TRUE``

* `price` 
  * `NUMERIC` → basicamente um ``Float``
  *`(5,2)` → pode ter até ``5 casas inteira`` e ``2 decimais``(é utilizado "." para separar as casas Ex: 5.2, 78.60)  

---

# DROP TABLE

```sql
DROP TABLE tbl_books;
```

* Esse comando vai deletar a tabela

---

# ALTER TABLE

```sql
ALTER TABLE tbl_books RENAME COLUMN isdn TO isbn;
```

* `ALTER TABLE` → altera uma tabela
* `tbl_books` → tabela alvo
* `RENAME COLUMN` → renomeia uma coluna
* `isdn` → coluna atual
* `TO isbn` → novo nome da coluna

---

# CONSTRAINTS

* São regras aplicadas a colunas ou tabelas para garantir a integridade dos dados

## Exemplo 1

```sql
ALTER TABLE IF EXISTS public.tbl_product
ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY
(INCREMENT 1 START 1);
```

* Altera a coluna `id` da tabela `tbl_product`
* Define como auto incremento (`IDENTITY`)
* `START 1` → começa em 1
* `INCREMENT 1` → incrementa de 1 em 1
* `GENERATED ALWAYS` → o valor do `id` é sempre gerado automaticamente pelo banco

## Exemplo 2

```sql
ALTER TABLE public.tbl_product
ALTER COLUMN nome TYPE VARCHAR(30)
COLLATE pg_catalog."default";
```

* Altera o tipo da coluna `nome`
* Define um limite de até 30 caracteres
* `COLLATE` → define regras de comparação e ordenação de texto