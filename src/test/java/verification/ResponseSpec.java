package verification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public class ResponseSpec {

    private ResponseSpec() {

    }

    public static ResponseSpecification checkStatusCodeOk() {

        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
                .build();
    }


    public static ResponseSpecification checkStatusCodeBadRequest() {

        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
                .build();
    }


    public static ResponseSpecification checkStatusCodeConflict() {

        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_CONFLICT)
                .build();
    }


    public static ResponseSpecification checkStatusCodeInternalError() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                .build();
    }


    public static ResponseSpecification checkStatusCodeNotFound() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_NOT_FOUND)
                .build();
    }

    public static ResponseSpecification checkStatusCodeCreated() {

        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_CREATED)
                .build();
    }


    public static ResponseSpecification checkStatusCodeNoContent() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_NO_CONTENT)
                .build();
    }

    public static ResponseSpecification checkStatusCodeLocked() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(HttpStatus.SC_LOCKED)
                .build();
    }
}
