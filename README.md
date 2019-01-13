# b2w-swchallange
Desafio Técnico B2W (Api Starwars).

# Instalação

No swchallenge/src/main/resources/application.properties configurar a conexão no MongoDB


*spring.data.mongodb.host=localhost
*spring.data.mongodb.port=27017
*spring.data.mongodb.authentication-database=admin
*#spring.data.mongodb.username=
*#spring.data.mongodb.password=
*spring.data.mongodb.database=swchallange



# API


##Listar Planetas (GET)
localhost:8080/planets/

##Buscar por id (GET)
localhost:8080/planets/{id}

##Buscar por nome (GET)
localhost:8080/planets/name/{name}

##Criar Planeta (POST)
localhost:8080/planets/
 
##Alterar Planeta (PUT)
localhost:8080/planets/

##Deletar Planeta (DELETE)
localhost:8080/planets/{id}

