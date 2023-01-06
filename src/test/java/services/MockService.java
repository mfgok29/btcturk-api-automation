package services;

import btcturk.controller.MockController;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.springframework.test.web.servlet.MockMvc;


import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class MockService {

    MockMvc mockMvc = standaloneSetup(new MockController()).build();
    public MockMvcResponse getOrders(MockMvcRequestSpecification requestSpec, ResponseSpecification responseSpec) {


        return given()
                .mockMvc(mockMvc)
                .spec(requestSpec)
                .when()
                .get("v1/api/orders/")
                .then()
                .assertThat()
                .log().ifValidationFails()
                .spec(responseSpec)
                .extract().response();
    }

    public MockMvcResponse getOrderById(MockMvcRequestSpecification requestSpec, Integer id, ResponseSpecification responseSpec) {


        return given()
                .mockMvc(mockMvc)
                .spec(requestSpec)
                .queryParam("id",id)
                .when()
                .get("v1/api/orders/by-id")
                .then()
                .assertThat()
                .log().ifValidationFails()
                .spec(responseSpec)
                .extract().response();
    }


}
