package br.ce.belinato.rest;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class OlaMundoTest {

	@Test
	public void testOlaMundo() {
		Response response = RestAssured.request(Method.GET, "https://restapi.wcaquino.me/ola");
		Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!")); //validando se o corpo corresponde ao texto
		Assert.assertTrue(response.statusCode() == 200); //validando se o status code é igual a 200
		Assert.assertTrue("O status code deveria ser 200", response.statusCode() == 200); //validando se o status code é igual a 200
		
		Assert.assertEquals(201, response.statusCode()); //melhor opção, já trava o que veio e o que esperava
		
		ValidatableResponse validacao = response.then(); //criando e instanciando o método que valida a resposta mais facilmente
		validacao.statusCode(200); //validação do status code 200
	}
}
