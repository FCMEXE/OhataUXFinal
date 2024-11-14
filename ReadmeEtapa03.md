# 📝 **ETAPA 3 - Análise de Caixa Branca**

## 🔍 **Grafo de Fluxo**

![Grafo de Fluxo](image.png)


### **Explicação dos Pontos:**
- **1:** O método `verificarUsuario` é iniciado, verificando o login e senha do usuário.
- **2:** A conexão com o banco de dados é estabelecida.
- **3:** A consulta SQL é executada para buscar o nome do usuário.
- **4:** A decisão de verificar se o resultado foi encontrado (`rs.next()`).
- **5:** Caso o usuário seja encontrado, o nome é atribuído à variável `nome` e o método retorna `true`.
- **6:** Se ocorrer um erro, a exceção é capturada e armazenada, mas o método segue retornando `false`.

## 📊 **Complexidade Ciclomática**

\[
V(G) = E - N + 2P = 4 - 3 + 2 = 2
\]

Onde:
- \(E\) é o número de arestas (conexões entre as etapas).
- \(N\) é o número de nós (pontos de decisão ou ações).
- \(P\) é o número de componentes conectados (no nosso caso, \(P = 1\)).

## 🚶‍♂️ **Caminhos Identificados**

Existem 10 possíveis caminhos para o fluxo do código:

1. **Caminho 1:** O usuário é autenticado com sucesso. A consulta SQL retorna um usuário válido, o nome é atribuído à variável `nome`, e o método retorna `true`.

2. **Caminho 2:** O login ou senha está incorreto. A consulta SQL não encontra nenhum usuário correspondente, e o método retorna `false`.

3. **Caminho 3:** O banco de dados está fora do ar ou inacessível, o que causa um erro na execução da consulta SQL. A exceção é capturada, mas o método retorna `false`, sem tratamento ou aviso ao usuário.

4. **Caminho 4:** A consulta SQL gera um erro, como um erro de sintaxe ou problema na construção da query. A exceção é capturada e armazenada, mas o método não retorna um erro específico, apenas `false`.

5. **Caminho 5:** A conexão com o banco de dados não foi estabelecida corretamente (provavelmente devido a falha no driver ou na configuração do banco de dados). O método `conectarBD` retorna `null`, mas o código continua a execução com `conn` nulo, o que pode resultar em erro durante a execução da consulta SQL.

6. **Caminho 6:** O banco de dados está acessível, mas o usuário tem permissões insuficientes para realizar a consulta. A exceção é capturada, mas o método não retorna nenhuma mensagem de erro ao usuário, retornando `false`.

7. **Caminho 7:** A consulta SQL retorna um usuário válido, mas o campo `nome` está vazio ou nulo. O nome atribuído à variável `nome` é um valor nulo ou vazio, mas o método ainda retorna `true`.

8. **Caminho 8:** O `login` ou `senha` fornecido é nulo ou vazio. A consulta SQL é mal formada e pode gerar um erro de sintaxe. A exceção é capturada, mas o método retorna `false`.

9. **Caminho 9:** O `login` e `senha` fornecido são válidos, mas há um erro no código (fora do escopo da consulta SQL), como uma exceção ao acessar a variável `conn` ou `st`. A exceção é capturada e o método retorna `false`.

10. **Caminho 10:** Durante a execução, uma falha ocorre na criação da `Statement` (por exemplo, problemas no driver JDBC). A exceção é capturada, mas o método retorna `false` sem informar ao usuário o motivo exato da falha.

---
