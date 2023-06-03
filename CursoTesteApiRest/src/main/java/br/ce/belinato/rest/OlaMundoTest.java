package br.ce.belinato.rest;

import static io.restassured.RestAssured.*;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class OlaMundoTest {

	@Test
	public void testOlaMundo() {
		Response response = request(Method.GET, "https://restapi.wcaquino.me/ola");//Request na api, método get
		Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!")); //validando se o corpo corresponde ao texto
		Assert.assertTrue(response.statusCode() == 200); //validando se o status code é igual a 200
		Assert.assertTrue("O status code deveria ser 200", response.statusCode() == 200); //validando se o status code é igual a 200
		
		Assert.assertEquals(200, response.statusCode()); //melhor opção, já trava o que veio e o que esperava
		
		ValidatableResponse validacao = response.then(); //criando e instanciando o método que valida a resposta mais facilmente
		validacao.statusCode(200); //valida status code 200
	}
	
	@Test
	public void devoConhecerOutrasFormasRestAssured() {
		Response response = request(Method.GET, "https://restapi.wcaquino.me/ola"); //Request na api, método get
		ValidatableResponse validacao = response.then(); //criando e instanciando o método que valida a resposta mais facilmente
		validacao.statusCode(200); //valida status code 200
		
		get("https://restapi.wcaquino.me/ola").then().statusCode(200);
		
		// introduzindo o dado quando então ao teste
		given().when().get("https://restapi.wcaquino.me/ola").then().statusCode(200);
	}
	
	@Test
	public void primeiroTesteGivenWhenThenImplementado() {
		Response response = request(Method.GET, "https://restapi.wcaquino.me/ola"); //Request na api, método get
		ValidatableResponse validacao = response.then(); //criando e instanciando o método que valida a resposta mais facilmente
		
		given()
			//Pré condições
		.when()
			.get("https://restapi.wcaquino.me/ola")
		.then()
			.statusCode(200);
	}
	
	
}
