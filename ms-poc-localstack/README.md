# POC - Springboot 3.2.2 + AWS Systems Manager -> Parameter Store

### 1. Tecnologias Utilizadas

   - Java 17
   - Spring Boot
   - Lombok
   - Spring Actuator
   - SonarLint
   
### 2. Configuração 

##### Instale

* [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/download/) ou outra IDE;
* [Java JDK 17](https://openjdk.java.net/projects/jdk/17/);
* [Git](https://git-scm.com/downloads)
* [Postman Agent](https://www.postman.com/downloads/);
* [Sonar Lint](https://www.sonarsource.com/products/sonarlint/)


### 3. Dependências

<artifactId>spring-boot-starter-web</artifactId>
<artifactId>spring-cloud-starter</artifactId>
<artifactId>spring-boot-starter-test</artifactId>
<artifactId>spring-cloud-starter-bootstrap</artifactId>
<artifactId>spring-cloud-starter-aws-parameter-store-config</artifactId>
<artifactId>lombok</artifactId>
<artifactId>spring-boot-starter-actuator</artifactId>

### 4. AWS

1. Crie uma conta AWS
2. Acesse o console da sua conta
3. Crie um Parameter Store com o nome: 
	3.1 -> /config/{spring.application.name}_{spring.profiles}/{nome.variavel}
	3.2 -> Ficando assim: /config/ms-poc-localstack_develop/helloWorld
4. Se observar o bootstrap.yml, vai ver que a ligação com a AWS/paramstore está somente no profile "develop"
5. Então será possível testar de 2 formas, uma passando o profile "local" e o valor virá do YML, e se passar o profile "develop", virá da AWS.

### 5. Como conectar na AWS através do seu Windows Power Shell?

1. Baixar o azure-cli e instalar - next next next
2. Testar para ver se deu certo, digita "aws" no prompt
3. Próximo passo é estabelecer/configurar a confiança da sua conta AWS com sua máquina local
	3.1) Da onde vem esse id e senha?
		3.1.1) No console da AWS, eu entrei com meu email pessoal e criei um usuário novo lá dentro como IAM user
		3.1.2) Após criar este novo usuário, fui em "Security credentials/My security credentials" no canto superior direito.
		3.1.3) E acessei o console deste novo usuário em "Console sign-in link"
		3.1.4) Criei um Access keys em "Create access key", onde gerou um aws_access_key_id e aws_secret_access_key (GUARDE NO CORAÇÃO)
		3.1.5) Pronto.
	3.2) Agora vai no seu Powershell e digite este comando: "aws sts get-caller-identity"
	3.3) PRECISA exibir dados como este abaixo.
		3.3.1) Tomei erro nas primeiras vezes: "The security token included in the request is invalid"
	
			{
		    	"UserId": "21CARACTERES",
			    "Account": "<12NUMEROS>",
			    "Arn": "arn:aws:iam::<12NUMEROS>:user/<SEUUSER>"
			}
4) 
	4.1) Abra o powershell e com o comando "aws configure" é possível configurar o aws_access_key_id e aws_secret_access_key através de um prompt que ele abre para você.
		4.1) O AWS CLI quando instalou, ele criou a pasta ".aws" onde deverá existir os arquivos config e credentials
		4.2) Quem coloca dados nestes arquivos é justamente depois que configurar no comando aws configure
		4.3) Tem que ficar mais ou menos assim !!!!
			---arquivo credentials
			[default]
			aws_access_key_id = 20CARACTERES
			aws_secret_access_key = 40CARACTERES		
			
			---arquivo config
			[default]
			source_profile = default
			region = us-east-1
			output = json
		4.4) Essa KEY e Secret você guardou no passo 3.1.4
5) Execute este comando novamente: "aws sts get-caller-identity"
6) Se aparecer o mesmo resultado de antes, você vai poder executar a aplicação sem erro!


### 6. Rodar a aplicação

6.1) Executar normal pela sua IDE passando "develop" no profile para buscar da AWS ou "local" para pegar da variável do YML.


