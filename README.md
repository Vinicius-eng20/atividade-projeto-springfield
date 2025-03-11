# Atividade-projeto-springfield
Aluno: Vinícius Tinoco

---

## Endpoints

### 1. Listar Todos os Cidadãos
Lista todos os cidadãos cadastrados na tabela `CAD_CIDADAO`.

- **Método**: `GET`

- **Endpoint**: `/cidadaos`

- **Respostas**:

    - *200 OK*: Retorna a lista de cidadãos.

# 2. Buscar Cidadão por ID
Busca um cidadão pelo `id`.

- **Método**: `GET`

- **Endpoint**: `/cidadaos/{id}`

- **Exemplo**: `/cidadaos/10001`

- **Respostas**:

    - *200 OK*: Retorna os dados do cidadão.

    - *404 Not Found*: Cidadão não encontrado.

### 3. Cadastrar um Novo Cidadão
Cadastra um novo cidadão na tabela `CAD_CIDADAO`.

- **Método**: `POST`

- **Endpoint**: `/cidadaos`

- **Body (JSON)**:

```json
{
    "id": 10001,
    "nome": "João Silva",
    "endereco": "Rua das Flores, 123",
    "bairro": "Centro"
}
```

- **Respostas**:

    - *200 OK*: Cidadão cadastrado com sucesso.

### 4. Atualizar Dados de um Cidadão
Atualiza os dados de um cidadão existente.

- **Método**: `PUT`

- **Endpoint**: `/cidadaos/{id}`

- **Exemplo**: `/cidadaos/10001`

- **Body (JSON)**:

```json
{
    "id": 10001,
    "nome": "João Silva",
    "endereco": "Rua das Flores, 456",
    "bairro": "Centro"
}
```

- **Respostas**:

    - *200 OK*: Cidadão atualizado com sucesso.

    - *404 Not Found*: Cidadão não encontrado.

### 5. Cadastrar um Novo Usuário
Cadastra um novo usuário com `id`, `username` e `senha`. 

- **Método**: `POST`

- **Endpoint**: `/usuarios/cadastrar`

- **Body (JSON)**:

```json
{
    "id": 10001,
    "username": "joao.silva",
    "senha": "senha123"
}
```

- **Respostas**:

    - *200 OK*: Usuário cadastrado com sucesso.

    - *400 Bad Request*: Já existe um usuário cadastrado com este ID.

### 6. Realizar Login
Autentica um usuário com `username` e `senha`.

- **Método**: `POST`

- **Endpoint**: `/usuarios/login`

- **Body (JSON)**:

```json
{
    "username": "joao.silva",
    "senha": "senha123"
}
```

- **Respostas**:

    - *200 OK*: Login realizado com sucesso.

    - *400 Bad Request*: Usuário bloqueado, senha incorreta ou usuário não encontrado.

### 7. Trocar Senha
Atualiza a senha de um usuário.

- **Método**: `POST`

- **Endpoint**: `/usuarios/trocar-senha`

- **Body (JSON)**:

```json
{
    "id": 10001,
    "novaSenha": "novaSenha123"
}
```

- **Respostas**:

    - *200 OK*: Senha atualizada com sucesso.

### 8. Bloquear Usuário
Bloqueia um usuário pelo id.

- **Método**: `POST`

- **Endpoint**: `/usuarios/bloquear`

- **Body (JSON)**:

```json
{
    "id": 10001
}
```

- **Respostas**:

    - *200 OK*: Usuário bloqueado com sucesso.

### 9. Desbloquear Usuário
Desbloqueia um usuário pelo id.

- **Método**: `POST`

- **Endpoint**: `/usuarios/desbloquear`

- **Body (JSON)**:

```json
{
    "id": 10001
}
```

- **Respostas**:

    - *200 OK*: Usuário desbloqueado com sucesso.



