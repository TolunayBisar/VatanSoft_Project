package com.varansoft.apitest.randomdogapitest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : tolunaybisar
 * @created : 15.12.2024,13:29
 * @Email :tolunay.bisar@gmail.com
 **/
public class TestApi {






        @BeforeClass
        public void setUp() {

            RestAssured.baseURI = "https://random.dog";




        }

        @Test(description = "as a  user should be able to send 100 pcs request to api  ", priority = 1)
        public void getCategoryById() {

            int Greater=0;
            int Lower=0;
            for (int i =0; i<100;i++){
                Response response = RestAssured.given().when().get("/woof.json");
                //response.getBody().prettyPrint();
                //response.jsonPath().prettyPrint();
                //System.out.println(response.jsonPath().getInt("fileSizeBytes"));
                int Num;

                Num =  response.jsonPath().getInt("fileSizeBytes");
                if (Num >1050000){

                    Greater=Greater+1;
                }
                else {

                    Lower=Lower+1;

                }


                assert response.getStatusCode() == 200 : "Expected status code 200,but got :" + response.getStatusCode();}
            System.out.println("Greater than 1050000 fileSizeBytes : " +Greater);
            System.out.println("Lower is 1050000 fileSizeBytes : " +Lower);

        }
    }


