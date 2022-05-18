# Cadastro de Clientes

### Endpoints
- [ ]  Endpoint para criar clientes (esse endpoint deve retornar um 422 caso o cpf seja inválido)
- [ ]  Endpoint para buscar cliente por CPF
- [ ]  Endpoint para listar todos os clientes (usando paginação)

#### Regras para validação do CPF
- O CPF pode ser passado em dois formatos: 
  - 999.999.999-00 (com máscara)
  - 99999999900 (somente números)

### Para executar localmente

- MySQL
  - porta: 3306
  - username: root
  - password: admin
  
- MySQL com docker: docker run --name cliente -p 3306:3306 -e MYSQL_ROOT_PASSWORD=admin -d mysql:latest

