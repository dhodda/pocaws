import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.internal.print.ResponsePrinter;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static io.restassured.RestAssured.given;

public class RestAssured {

    public static void main(String[] args) {
       RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.URLENC)
                .build();
        /**
         * Build Service
         */
       requestSpecification
               .baseUri("http://localhost:8080/topics/javaee")
               .header("Content-Type","application/json")
               .log().everything(true);
        /**
         *  Execute get Method
         */
        Response response = given().spec(requestSpecification).request("GET");
        /**
         *  DeSerialize the Response
         */
        GetResponseObject  myResponse = response.then().extract().body().as(GetResponseObject.class, ObjectMapperType.GSON);
        /**
         * Do assertions.
         */
        System.out.println(response.getStatusCode());
        System.out.println(myResponse.id);
        System.out.println(myResponse.name);
        System.out.println(myResponse.description);
    }
}
