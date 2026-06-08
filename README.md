# Projeto Final LBD - Gestão de PetShop
Sistema de gerenciamento desenvolvido em Java com MySQL — projeto final da disciplina Laboratório de Banco de Dados.

## Sobre o projeto
O sistema gerencia o cadastro de tutores e pets, cadastro e controle de serviços, e registro/agenda de serviços prestados pelo petshop.

Principais funcionalidades:
- Cadastro e gerenciamento de tutores (donos) e pets
- Cadastro e gerenciamento de serviços (ex.: banho, tosa, vacinação)
- Registro de serviços realizados (com data, horário, status e pagamento)

## Estrutura do projeto
```
ProjetoFinal-Banco.de.Dados
- .git/
- LICENSE
- README.md
- petshopbd/
  - .gitignore
  - pom.xml
  - db/
    - schema.sql
  - docs/
    - Diagrama-de-classe.png
    - Projeto_Final_Conceitual.png
    - Projeto_Final_Lógico.png
  - src/
    - main/java/com/petshop/
            - App.java
            - connection/
            - dao/
            - model/
            - service/
            - ui/
    - test/java/com/petshop/
            - AppTest.java
  - target/
    - classes/ 
    - test-classes/ 
```

Observação: o código-fonte Java fica em `petshopbd/src/main/java/com/petshop`.

## Requisitos
- Java JDK 8 ou superior
- MySQL (servidor de banco de dados)
- MySQL Connector
- Maven (para build) — opcional se for executar pela IDE

## Como configurar e executar

1) Criar o banco de dados

Abra o MySQL Workbench (ou outro cliente MySQL) e execute o script SQL para criar o esquema e tabelas:

```
petshopbd/db/schema.sql
```

2) Configurar a conexão com o banco

Altere as constantes abaixo conforme seu ambiente MySQL:

```
private static final String URL = "jdbc:mysql://localhost:3306/PROJETOFINAL"; // ajuste host, porta e nome do DB
private static final String USUARIO = "root";   // seu usuário MySQL
private static final String SENHA = "";         // sua senha MySQL
```

3) Execução

Usando Maven:

```
mvn -f petshopbd clean package
mvn -f petshopbd dependency:copy-dependencies
```

Depois execute a aplicação (Windows):

```
java -cp "petshopbd/target/classes;petshopbd/target/dependency/*" com.petshop.App
```