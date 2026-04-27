

---
```sql
SELECT * FROM
```
## Selecionar tudo de uma tabela, e ordenar por ID da forma ascendente
- SELECT * FROM public.tbl_product
- ORDER BY id ASC 

--- 

#  CONSTRAIN

- É uma regra que será aplicada para determinada coluna,tabela

## Comandos:

```sql
ALTER TABLE IF EXISTS public.tbl_product
    ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 );
```

- Altera a **coluna "id"** da tabela **"tbl_product"** e faz com que ele *incremente começando do 1*, o IDENTITY é uma função onde so pode ter aquele ID 

---

```sql
ALTER TABLE public.tbl_product
    ALTER COLUMN name TYPE character varying(30) COLLATE pg_catalog."default";
```

- Altera a **coluna "name"** da tabela **"tbl_product"** e troca a linha *"name"* para suportar *30 char*, 