# teste_azulseguros
Codigo para o desafio azul seguros

Banco de dados utilizado foi o mysql 8.0, para criar o banco de dados utilizado no projeto rodar a seguinte query:

CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `cep` varchar(45) NOT NULL,
  `logradouro` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

Com os seguintes valores no application proprieties:

#Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)

spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase?useSSL=false
spring.datasource.username=root
spring.datasource.password=admin

#Dialeto SQL melhorar o SQL gerado pelo Hibernate

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect



O servidor de aplicação utlizado foi o tomcat apenas por uma questão de facilidade de setar o ambiente, mas não acredito que tenha problemas em rodar em qualquer outro servidor de aplicação.


