## FastMails
Principal motivo do projeto, é alcançar o entendimento do padrão de arquitetura 'Clean Architecture' do Uncle Bod, organizei os diretórios da maneira que compreendi sobre os ensinamentos.

## Testes unitários
O projeto conta com alguns simples testes unitários, você pode rodar os testes seguindo o pequeno tutorial abaixo.

### Passos
**Para rodar os testes unitários com Maven, basta acessar o diretório principal da aplicação, e rodar o seguinte comando**
```bash
mvn test
```
## Como o projeto funciona
De maneira simples, o serviço é uma API, para utiliza-lá, basta acessar o endpoint principal da API **localhost:8080/fastmail/v1/send
### Agora é precisa enviar um body na request da API, o formato deve ser em JSON, seguindo essa estrutura:
![Exemplo](https://images2.imgbox.com/cf/0c/bg0A2v4N_o.png)

