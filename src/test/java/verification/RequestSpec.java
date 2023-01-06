package verification;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecBuilder;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;


public class RequestSpec {

    private RequestSpec() {

    }

    public static MockMvcRequestSpecification requestSpecification() {

        return new MockMvcRequestSpecBuilder().setContentType(ContentType.JSON).build();


    }


}
