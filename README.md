# bank
Desafio Java Backend

Estudo de Caso: Cadastro de Clientes durante a jornada de contratação de seguro.
 
Nosso time de atendimento em loja necessita realizar cadastros de clientes, para seguir com a
Jornada de Onboarding no Banco, é necessário informar alguns dados como:
CPF, Nome, Data de Nascimento, Telefone e Endereço completo.
Após realizar o cadastro o cliente terá acesso numa jornada muito importante de &quot;Contratação
de Seguros&quot;, nela será possível simular e contratar os Seguros Bronze, Prata e Ouro.
 
Técnico:
1. Construir uma API - Cadastro
   a. Crud para manipular o cadastro do cliente (4 Serviços)
2. Construir uma API - Seguros
   a. Simular qual Seguro o cliente vai contratar (1 Serviço)
   b. Realizar a contratação de fato do seguro (1 Serviço )
3. Integrar com Banco de dados
   a. DICA: Usar Postgre ou MongoDB
4. Realizar Chamada Back to Back entre as APIs Ex. no momento de Contratar o Seguro,
   consultar o cliente na API de Cadastro para ter certeza que ele existe.
   a. Mecanismo de resiliência
5. Documentação Swagger
6. Testes unitários em Junit
