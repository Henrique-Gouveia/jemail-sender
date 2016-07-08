# JEmail Sender

Biblioteca java que tem por objetivo simplificar o processo de envio de Emails. Essa provê a possibilidade de configuração do servidor
de Emails através de um arquivo denomidado `email_config.properties` ou outro meio desejado, pois uma instância da classe `EmailConfig` 
contendo informações necessárias de configuração deverá ser repassado no construtor de uma classe que extenda `EmailSender`.

### Iniciando

Gerar a biblioteca JAR e instalar no repositório local:

    $ git clone git://github.com/henrique-gouveia/jemail-sender.git
    $ cd jemail-sender.git
    $ mvn install

Adicionar a dependência no pom.xml:

    <dependency>
      <groupId>br.com.ndevfactory</groupId>
      <artifactId>jemail-sender</artifactId>
      <version>1.0.0-SNAPSHOT</version>
      <scope>compile</scope>
    </dependency>

### Configuração


Para configuração através do arquivo `email_config.properties`, esse deverá ser criado no projeto que faz uso da biblioteca com
os seguintes pares de chave e valor:

    email.host_name=[smtp.provedor.com]
    email.smtp_port=[465]
    email.ssl=[true|false]
    email.from_name=[From Name]
    email.from_email=s[email@provedor.com]
    email.from_password=[1234]

Caso deseje, outro poderá ser desenvolvido, desde que, uma instância da classe `EmailConfig` com essas informações seja preparada
para ser fornecida no construtor de uma classe que deverá extender `EmailSender`. Caso opte pelo definição do arquivo, então a 
instância pode ser obtida a partir da chamada encadeada dos métodos `fromBundle().build()` presente na classe `EmailConfigBuilder`.

No projeto que faz uso da biblioteca, três classes deverão ser desenvolvidas, uma que extenda `EmailSender` e duas que implemente
as interfaces `Contatos` e `Email` respectivamente. 

A classe que extenderá `EmailSender` deverá implementar os métodos. O primeiro deles é o `getContatos()` que deverá retornar a classe 
que implemente a interface `Contatos`, em que, o método `getAll()` deverá prover os contatos, por exemplo, de um arquivo `XML`, `CSV` 
ou outro meio desejado. O segundo é o `getEmail()` que deverá retornar a  classe que implemente a interface `Email` e servirá como um 
`Adapter`, isso deverá possibilitar o uso de diferentes bibliotecas que viabilizam o envio de Emails, por exemplo, `JavaMail API` em 
conjunto com `Apache Commons Email`.
