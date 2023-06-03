package br.ce.belinato.rest;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class OlaMundo {	


		public static void main(String[] args) {
			Response response = RestAssured.request(Method.GET, "https://restapi.wcaquino.me/ola");
			System.out.println(response.getBody().asString()); //Obtivemos o conteúdo (corpo) da resposta
			System.out.println(response.statusCode()); //Imprime o código do status
			
			
			//Primeiro teste
			
			System.out.println(response.getBody().asString().equals("Ola Mundo!")); //validando se o corpo corresponde ao texto
			System.out.println(response.statusCode() == 200); //validando se o status code é igual a 200
			
			ValidatableResponse validacao = response.then(); //criando e instanciando o método que valida a resposta mais facilmente
			validacao.statusCode(200); //validação do status code 200
			
			System.out.println("Testando commitar via eclipse");
			
		}
	}

	

