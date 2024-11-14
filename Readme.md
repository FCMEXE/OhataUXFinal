

Erro 01 : Concatenação de Strings na Consulta SQL - Maneira não eficiente para 
mexer no banco de dados, facilitando a entrada de pacotes mal intencionados no 
banco de dados. Seria melhor aproveitado utilizar um State para setar o login e
 senha do Usuario.
 
 Erro 02 : JDBC Desatualizado - Baseado na documentação "https://docs.spring.io
 /spring-data/jdbc/docs/current-SNAPSHOT/reference/html/#reference", a utilização
 do "Class.forName("com.mysql.Driver.Manager")" na linha 13 esta desatualizado,
 recomendo utilizar "Class.forName("com.mysql.cj.jdbc.Driver")", para corrigir
supostos bugs em versoões antigas e ter suporte a novos pacotes. 

Erro 03 : Catch Vazio - Presentes na linha 11 e 32, existem 2 catch que não
 retornam nada, recomendo alterar ouacresentar um retorno para eles não ficarem
 absoletos no codigo.

Erro 04 : DB Abre mas não fecha, recomendo ao final do codigo fechar a conexão
 com o DB

Erro 05 : Dados sensiveis no codigo, para manter a segurança não utilizar dados
 sensiveis dos usuarios direto no codigo.

Erro 06 : Noes de variaveis confusas - Utilização de nomes de variaveis que não
são claras para que servem ou aonde são utilizadas.

Erro 07 : Result global, poderia ser local - Utilizar a const result Localmente
no escopo. para não haver confusão de consts.

Erro 08 : Não verificação do Null - Após chamar conn ele assumi que é Null, sem
fazer qualquer verificação.