import io.qameta.allure.Step;
import org.testng.annotations.Test;
import util.LectorPropietats;

import static auxiliars.constants.URL_POKEMON;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssuredTest {

    LectorPropietats lectorPropietats=new LectorPropietats("TST");

    @Test
    public void validarLlistaPokemon01() {
        validarPokemon(lectorPropietats.getProperty("pokemon01"));
    }

    @Test
    public void validarLlistaPokemon02() {
        validarPokemon(lectorPropietats.getProperty("pokemon02"));
    }
    @Test
    public void validarLlistaPokemon03() {
        validarPokemon(lectorPropietats.getProperty("pokemon03"));
    }

    @Test
    public void accedimAGoogle() {
        given()
        .when()
          .get("http://www.google.com")
        .then()
          .statusCode(200);
    }

    @Step("Validar Pokemon {pokemon}")
    public void validarPokemon(String pokemon) {
        given()
                .when()
                .get(URL_POKEMON + "?limit=200")
                .then()
                .statusCode(200)
                .body(containsString(pokemon));
    }

    @Test
    public void validaPokemonRattata() {
        given()
                .when()
                .get(URL_POKEMON + "?limit=200")
                .then()
                .statusCode(200)
                .body(containsString("rattata"));
    }

    @Test
    public void validaContLess2000Pokemons() {
        given()
                .when()
                .get(URL_POKEMON + "?limit=200")
                .then()
                .statusCode(200)
                .body("count", lessThan(2000));
    }

    @Test
    public void validaContGreaterThan1000Pokemons() {
        given()
                .when()
                .get(URL_POKEMON + "?limit=200")
                .then()
                .statusCode(200)
                .body("count", greaterThan(1000));
    }

}
