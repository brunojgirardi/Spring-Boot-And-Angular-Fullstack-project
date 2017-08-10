# todo app

A aplicação é separada entre backend e front-end

##frontend
Para rodar o backend basta liberar o conteúdo da pasta em algum servidor web. A aplicação considera que o backend está em localhost:8080. No arquivo TodoCtrl.js é possível alterar essa configuração. 

A aplicação foi feita utilizando-se do angular 1.5, boostrap 3 e  jquery. A navegação é feita com o módulo 'ng-route', padrão do angular. 

##backend  
O servidor de backend é uma API REST que pode ser usada pela página web ou aplicativos de celular, o CORS está habilitado através de annotations para permitir que o server seja chamado de origens diferentes(outros servers ou aplicações rodando em outras portas ). 

A aplicação foi criada utilizando-se os plugins sprint boot(base da aplicação),  spring data(para persistência). A aplicação é construída com gradle, para rodá-la deve-se executar o comando ./gradlew bootRun, ainda é possível gerar um jar executável com o comando ./gradlew build. Como ele 'embarca' um tomcat, é possível rodá-lo como qualquer outro jar, sem necessidade de application server.

### Banco de dados
Utilizou-se o baco de dados MySql5. Deve-se criar um banco chamado "todo", com usuário e senha todoapp. Essas configurações podem ser alteradas no arquivo application.properties.
A cada execução da aplicação, o banco é limpo. Essa configuração pode ser alterada no mesmo arquivo de propriedes que a senha e usuário.