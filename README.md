Hello world with Quarkus
https://github.com/quarkusio/quarkus
https://www.baeldung.com/quarkus-io
https://simply-how.com/quarkus-vs-spring

Following the tutorial:
https://medium.com/@marcus.paulo/tutorial-criando-um-crud-utilizando-quarkus-java-rest-cdi-panache-hibernate-com-postgres-59793e0d7162
https://medium.com/@marcus.paulo/tutorial-quarkus-simplificando-o-hibernate-utilizando-panache-criando-uma-aplica%C3%A7%C3%A3o-simples-393134a58073


Create a Quarkus project:
https://code.quarkus.io/
mvn io.quarkus:quarkus-maven-plugin:1.0.1.Final:create \
     -DprojectGroupId=br.com.food \
     -DprojectArtifactId=quarkus-helloworld \
     -DclassName="br.com.car.resource.FoodResource" \
     -Dpath="/food"

Execute the project:
mvn compile quarkus:dev



Food:
Database access directly by Controller and Service
{
    "calories": 100,
    "id": 1,
    "name": "Apple"
}

Car:
Database access by repository
{
    "isAvailableSale": true,
    "brand": "Brasilia Amarela",
    "createdDateTime" : "2020-05-30T20:07:01.111",
    "modelYear" : "2010-01-01",
    "name" : "Brasilia Amarela Pelados em Santos",
    "price" : "12345"
}
