### Api-Manufacture

Esta API utiliza a versão 17 do Java, e está implementada para utilização de banco de dados de testes, H2.

Para executar a API:
```docker
$ docker pull eliasneri/crud-backend-java17:latest

$ docker run -p 9598:9598 eliasneri/crud-backend-java17:latest
```
Após baixar o container e executar, os serviços estarão disponíveis na porta 9598, caso deseje mudar a porta, lembre-se de alterar no localhost.

### Swagger: 
http://localhost:9598/manufacture/swagger-ui/index.html

### Acessando o Bando de Dados H2
http://localhost:9598/manufacture/h2-console

Credenciais de acesso:
Driver Class= org.h2.Driver <br />
JDBC URL= jdbc:h2:mem:testdb <br />
User Name= sa <br />
Password=

### Coleção de Requisições (postman)
```json
{
  "info": {
    "_postman_id": "a5def83d-9fca-4cea-a28c-e6673d9c554d",
    "name": "NEC -Manufacturer",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
    "_exporter_id": "12415548"
  },
  "item": [
    {
      "name": "FindAll",
      "request": {
        "method": "GET",
        "header": [],
        "url": {
          "raw": "localhost:9598/manufacture/find/all",
          "host": [
            "localhost"
          ],
          "port": "9598",
          "path": [
            "manufacture",
            "find",
            "all"
          ]
        }
      },
      "response": []
    },
    {
      "name": "FindByID",
      "request": {
        "method": "GET",
        "header": [],
        "url": {
          "raw": "localhost:9598/manufacture/find/1",
          "host": [
            "localhost"
          ],
          "port": "9598",
          "path": [
            "manufacture",
            "find",
            "1"
          ]
        }
      },
      "response": []
    },
    {
      "name": "Create",
      "request": {
        "method": "POST",
        "header": [],
        "body": {
          "mode": "raw",
          "raw": "{\r\n  \"manufacturerName\": \"Empresa One LTDA.\",\r\n  \"manufacturerCNPJ\": \"12345678000190\",\r\n  \"manufacturerFantasyName\": \"One Empresa de tudo um pouco\",\r\n  \"manufacturerSocialName\": \"One\",\r\n  \"manufacturerActive\": \"true\",\r\n  \"manufacturerSite\": \"www.one.com\",\r\n  \"manufacturerCountry\": \"brasil\",\r\n  \"manufacturerCity\": \"Americana\",\r\n  \"manufactureNeighbourhood\": \"centro\"\r\n}",
          "options": {
            "raw": {
              "language": "json"
            }
          }
        },
        "url": {
          "raw": "localhost:9598/manufacture/create",
          "host": [
            "localhost"
          ],
          "port": "9598",
          "path": [
            "manufacture",
            "create"
          ]
        }
      },
      "response": []
    },
    {
      "name": "Update",
      "request": {
        "method": "PUT",
        "header": [],
        "body": {
          "mode": "raw",
          "raw": "{\r\n  \"manufacturerName\": \"Empresa OneToOne LTDA .\",\r\n  \"manufacturerCNPJ\": \"12345678000190\",\r\n  \"manufacturerFantasyName\": \"One Empresa de tudo um pouco\",\r\n  \"manufacturerSocialName\": \"One\",\r\n  \"manufacturerActive\": \"true\",\r\n  \"manufacturerSite\": \"www.one.com\",\r\n  \"manufacturerCountry\": \"brasil\",\r\n  \"manufacturerCity\": \"Americana\",\r\n  \"manufactureNeighbourhood\": \"centro\"\r\n}",
          "options": {
            "raw": {
              "language": "json"
            }
          }
        },
        "url": {
          "raw": "localhost:9598/manufacture/update/1",
          "host": [
            "localhost"
          ],
          "port": "9598",
          "path": [
            "manufacture",
            "update",
            "1"
          ]
        }
      },
      "response": []
    },
    {
      "name": "Delete",
      "request": {
        "method": "DELETE",
        "header": [],
        "url": {
          "raw": "localhost:9598/manufacture/delete/1",
          "host": [
            "localhost"
          ],
          "port": "9598",
          "path": [
            "manufacture",
            "delete",
            "1"
          ]
        }
      },
      "response": []
    }
  ]
}
```
#### Dica: salve este conteúdo em um arquivo .json e importe como coleção no Postman.
Enjoy!

Elias Neri - 02/2024