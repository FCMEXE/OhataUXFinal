# Sistema de Verificação de Login

Este projeto contém a classe `User` que implementa a verificação de login e senha de um usuário em um banco de dados MySQL. Ele utiliza a tecnologia JDBC para realizar a conexão com o banco de dados e autenticar o usuário com base no login e senha fornecidos.

## Pré-requisitos

Antes de executar o código, é necessário garantir que o ambiente esteja configurado corretamente.

### 1. JDK (Java Development Kit)

O projeto requer o JDK instalado. Para verificar se você já tem o JDK instalado, execute o seguinte comando no terminal:

```bash
java -version

Caso não tenha o JDK, faça o download e instale a versão mais recente do JDK aqui.
2. Banco de Dados MySQL

O código utiliza o MySQL como banco de dados para armazenar informações dos usuários. O MySQL deve estar configurado e em funcionamento. Certifique-se de que as credenciais e o banco de dados estejam corretos.
3. Driver JDBC

Este projeto utiliza o driver JDBC para conectar ao banco de dados MySQL. Caso você esteja utilizando um sistema de gerenciamento de dependências como Maven, adicione a dependência do MySQL no seu arquivo pom.xml:

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.28</version>
</dependency>

Se não estiver usando Maven, baixe o driver JDBC do MySQL e coloque o arquivo .jar no classpath do seu projeto.
Configuração do Banco de Dados

Antes de executar o código, você precisará garantir que o banco de dados MySQL esteja funcionando corretamente e com as credenciais configuradas de acordo com o que está definido no código. O código utiliza a seguinte URL de conexão para acessar o banco de dados:

String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";

    127.0.0.1: Endereço IP do servidor de banco de dados (no caso, o localhost).
    test: Nome do banco de dados a ser utilizado.
    lopes: Usuário do banco de dados.
    123: Senha do banco de dados.

Certifique-se de ajustar essas credenciais de acordo com sua configuração local.
Como Usar
1. Importando a Classe User

A classe User oferece métodos para verificar o login e a senha do usuário.

    O método verificarUsuario recebe o login e a senha e retorna true se o usuário for encontrado e autenticado corretamente.

2. Exemplo de Uso

A seguir, um exemplo de como utilizar a classe User para autenticar um usuário:

public class Main {
    public static void main(String[] args) {
        User user = new User();
        
        // Verifica se o usuário existe no banco de dados
        boolean autenticado = user.verificarUsuario("usuario", "senha123");

        // Exibe o nome do usuário se autenticado ou uma mensagem de erro
        if (autenticado) {
            System.out.println("Usuário autenticado: " + user.nome);
        } else {
            System.out.println("Login ou senha inválidos.");
        }
    }
}

3. Executando o Código

    Compile o código utilizando o seguinte comando:

javac User.java

Execute o código com:

    java User

Nota: Certifique-se de que o MySQL esteja em funcionamento e a URL de conexão seja configurada corretamente no código.
Descrição da Classe User

A classe User é responsável por realizar a autenticação do usuário em um banco de dados MySQL. Ela utiliza JDBC para se conectar ao banco e verificar se o login e senha fornecidos são válidos.
Métodos
1. conectarBD()

Este método estabelece a conexão com o banco de dados MySQL. Retorna a conexão se for bem-sucedida ou null caso ocorra algum erro.

public Connection conectarBD()

2. verificarUsuario(String login, String senha)

Este método verifica se o usuário existe no banco de dados, comparando o login e a senha fornecidos. Retorna true se o usuário for encontrado e autenticado, e false caso contrário.

public boolean verificarUsuario(String login, String senha)

Variáveis

    nome: O nome do usuário, retornado após a autenticação bem-sucedida.
    result: Indica se o login foi bem-sucedido ou não. O valor padrão é false.