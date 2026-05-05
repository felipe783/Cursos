# 9️⃣ CONSTRAINTS - Regras de Integridade

Aprenda sobre constraints que garantem a integridade dos dados no banco.

---

## ⚒️ Para que servem

**Constraints** são regras aplicadas a colunas ou tabelas para **garantir a qualidade e consistência dos dados**.

---

## 🔐 Tipos de Constraints

| Constraint | O que faz | Exemplo |
|-----------|----------|---------|
| `NOT NULL` | Campo obrigatório | `name VARCHAR(100) NOT NULL` |
| `UNIQUE` | Valores únicos | `email VARCHAR(100) UNIQUE` |
| `PRIMARY KEY` | Identifica registros únicos | `id SERIAL PRIMARY KEY` |
| `FOREIGN KEY` | Relaciona com outra tabela | `customer_id REFERENCES customers(id)` |
| `CHECK` | Valida intervalo de valores | `age CHECK (age >= 18)` |
| `DEFAULT` | Valor padrão | `status VARCHAR(20) DEFAULT 'ativo'` |

---

## ❌ NOT NULL

Coluna obrigatória - não pode estar vazia.

### Sintaxe

```sql
CREATE TABLE tbl_users(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20)  -- Opcional
);
```

### Exemplos com NOT NULL

```sql
-- Tentar inserir NULL vai dar erro
INSERT INTO tbl_users(name, email) 
VALUES ('João', NULL);
-- ❌ Erro: email não pode ser NULL

-- Correto
INSERT INTO tbl_users(name, email, phone)
VALUES ('João', 'joao@email.com', NULL);
-- ✅ OK: name e email têm valor, phone pode ser NULL
```

---

## 🔑 UNIQUE

Valores únicos - não pode repetir.

### Sintaxe

```sql
CREATE TABLE tbl_users(
    id SERIAL PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    username VARCHAR(50) NOT NULL UNIQUE
);
```

### Exemplos com UNIQUE

```sql
-- Dois usuários com o mesmo email
INSERT INTO tbl_users(email, username) 
VALUES ('joao@email.com', 'joao');

INSERT INTO tbl_users(email, username) 
VALUES ('joao@email.com', 'joao2');
-- ❌ Erro: email 'joao@email.com' já existe

-- Correto
INSERT INTO tbl_users(email, username) 
VALUES ('maria@email.com', 'maria');
-- ✅ OK: email único
```

### Diferença: UNIQUE vs PRIMARY KEY

| Aspecto | UNIQUE | PRIMARY KEY |
|--------|--------|-----------|
| Quantidade | Pode ter múltiplos | Apenas um |
| NULL | Pode ter múltiplos | Não pode ter NULL |
| Indexado | Sim | Sim |
| Uso | Email, username | ID, identificador |

---

## 🔐 PRIMARY KEY

Identifica de forma única cada registro.

### Sintaxe

```sql
CREATE TABLE tbl_products(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    price NUMERIC(7,2)
);
```

### Características

- ✅ Não pode ser NULL
- ✅ Não pode repetir
- ✅ Cada tabela tem apenas uma
- ✅ Automaticamente indexado

### PRIMARY KEY Composta

```sql
CREATE TABLE tbl_order_items(
    order_id INTEGER,
    product_id INTEGER,
    quantity INTEGER,
    PRIMARY KEY (order_id, product_id)
);
```

Combina duas colunas para criar uma chave única.

---

## 🔗 FOREIGN KEY

Relaciona dados entre duas tabelas.

### Sintaxe

```sql
CREATE TABLE tbl_orders(
    id SERIAL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    total NUMERIC(10,2),
    FOREIGN KEY (customer_id) REFERENCES tbl_customers(id)
);
```

### Exemplo Completo: Sistema de Pedidos

```sql
-- Tabela pai
CREATE TABLE tbl_customers(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- Tabela filho (com FOREIGN KEY)
CREATE TABLE tbl_orders(
    id SERIAL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    order_date DATE DEFAULT CURRENT_DATE,
    total NUMERIC(10,2),
    FOREIGN KEY (customer_id) REFERENCES tbl_customers(id)
);
```

### Comportamento

```sql
-- Inserir cliente
INSERT INTO tbl_customers(name, email)
VALUES ('João', 'joao@email.com');
-- customer_id = 1

-- Inserir pedido válido
INSERT INTO tbl_orders(customer_id, total)
VALUES (1, 150.00);
-- ✅ OK: customer_id 1 existe

-- Inserir pedido inválido
INSERT INTO tbl_orders(customer_id, total)
VALUES (999, 200.00);
-- ❌ Erro: customer_id 999 não existe em tbl_customers
```

### Opções de FOREIGN KEY

```sql
-- ON DELETE CASCADE: deletar pedidos quando cliente é deletado
CREATE TABLE tbl_orders(
    id SERIAL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    total NUMERIC(10,2),
    FOREIGN KEY (customer_id) REFERENCES tbl_customers(id)
        ON DELETE CASCADE
);

-- ON DELETE SET NULL: tornar NULL quando cliente é deletado
FOREIGN KEY (customer_id) REFERENCES tbl_customers(id)
    ON DELETE SET NULL

-- ON DELETE RESTRICT: impedir deleção se há pedidos
FOREIGN KEY (customer_id) REFERENCES tbl_customers(id)
    ON DELETE RESTRICT
```

---

## ✅ CHECK

Valida dados dentro de um intervalo.

### Sintaxe

```sql
CREATE TABLE tbl_shoes(
    id SERIAL PRIMARY KEY,
    size INTEGER CHECK (size >= 30 AND size <= 50),
    price NUMERIC(7,2) CHECK (price > 0)
);
```

### Exemplos

```sql
-- Validar idade
CREATE TABLE tbl_users(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    age INTEGER CHECK (age >= 18)
);

-- Validar preço
CREATE TABLE tbl_products(
    id SERIAL PRIMARY KEY,
    price NUMERIC(7,2) CHECK (price > 0),
    discount NUMERIC(5,2) CHECK (discount >= 0 AND discount <= 100)
);

-- Validar valores
CREATE TABLE tbl_orders(
    id SERIAL PRIMARY KEY,
    status VARCHAR(20) CHECK (status IN ('pendente', 'enviado', 'entregue'))
);
```

### Testando CHECK

```sql
-- Inserir sapato com tamanho válido
INSERT INTO tbl_shoes(size, price)
VALUES (42, 299.90);
-- ✅ OK

-- Inserir sapato com tamanho inválido
INSERT INTO tbl_shoes(size, price)
VALUES (100, 299.90);
-- ❌ Erro: size 100 viola CHECK (size <= 50)
```

---

## 📅 DEFAULT

Valor padrão quando nenhum é fornecido.

### Sintaxe

```sql
CREATE TABLE tbl_games(
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Exemplos

```sql
-- Inserir sem especificar active e created_at
INSERT INTO tbl_games(title)
VALUES ('Elden Ring');

-- Resultado:
-- id: 1
-- title: 'Elden Ring'
-- active: TRUE (padrão)
-- created_at: 2026-05-01 10:30:45 (hora atual)
```

### Valores DEFAULT Comuns

| Valor | O que faz | Exemplo |
|-------|----------|---------|
| `TRUE` / `FALSE` | Booleano | `active BOOLEAN DEFAULT TRUE` |
| `CURRENT_DATE` | Data de hoje | `date DATE DEFAULT CURRENT_DATE` |
| `CURRENT_TIMESTAMP` | Data e hora | `created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP` |
| `0` | Número | `stock INTEGER DEFAULT 0` |
| `'texto'` | Texto | `status VARCHAR(20) DEFAULT 'ativo'` |

---

## 🏆 Exemplo Completo: E-commerce

```sql
-- Tabela de clientes
CREATE TABLE tbl_customers(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de produtos
CREATE TABLE tbl_products(
    id SERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    price NUMERIC(10,2) NOT NULL CHECK (price > 0),
    stock INTEGER DEFAULT 0 CHECK (stock >= 0),
    active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de pedidos
CREATE TABLE tbl_orders(
    id SERIAL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT 'pendente' 
        CHECK (status IN ('pendente', 'processando', 'enviado', 'entregue', 'cancelado')),
    total NUMERIC(10,2) NOT NULL CHECK (total > 0),
    FOREIGN KEY (customer_id) REFERENCES tbl_customers(id) ON DELETE CASCADE
);

-- Tabela de itens do pedido
CREATE TABLE tbl_order_items(
    id SERIAL PRIMARY KEY,
    order_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL CHECK (quantity > 0),
    unit_price NUMERIC(10,2) NOT NULL CHECK (unit_price > 0),
    FOREIGN KEY (order_id) REFERENCES tbl_orders(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES tbl_products(id)
);
```

---

## 🔍 Visualizar Constraints

### PostgreSQL

```sql
-- Ver constraints de uma tabela
SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = 'tbl_orders';

-- Ver colunas e suas restrições
SELECT column_name, is_nullable, column_default
FROM information_schema.columns
WHERE table_name = 'tbl_orders';
```

---

## ➕ Adicionar Constraints a Tabela Existente

```sql
-- Adicionar NOT NULL
ALTER TABLE tbl_products
ALTER COLUMN name SET NOT NULL;

-- Adicionar UNIQUE
ALTER TABLE tbl_products
ADD CONSTRAINT unique_sku UNIQUE (sku);

-- Adicionar CHECK
ALTER TABLE tbl_products
ADD CONSTRAINT check_price CHECK (price > 0);

-- Adicionar FOREIGN KEY
ALTER TABLE tbl_orders
ADD CONSTRAINT fk_customer
FOREIGN KEY (customer_id) REFERENCES tbl_customers(id);
```

---

## 📋 Checklist de Constraints

- [ ] Todas as colunas obrigatórias têm `NOT NULL`?
- [ ] Colunas de identificação têm `PRIMARY KEY`?
- [ ] Relacionamentos têm `FOREIGN KEY`?
- [ ] Valores numéricos têm `CHECK` se necessário?
- [ ] Colunas únicas têm `UNIQUE`?
- [ ] Colunas têm `DEFAULT` quando apropriado?

---

## 🎓 Próximos Passos

- **[07 - CREATE](./07-create.md)** - Criar tabelas
- **[08 - ALTER & DROP](./08-alter-drop.md)** - Modificar estruturas
- **[02 - SELECT](./02-select.md)** - Consultar dados com integridade

---

**Última atualização:** 2026-05-01
