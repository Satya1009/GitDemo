package section10;

import static io.restassured.RestAssured.given;

//import io.restassured.parsing.Parser;

import io.restassured.path.json.JsonPath;

//import io.restassured.response.Response;

//import io.restassured.response.ResponseBody;

public class TestOath{
	
public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

String url ="https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FvAHBQUZU6o4WJ719NrGBzSELBFVBI9XbxvOtYpmYpeV47bFVExkaxWaF_"
		+ "XR14PHtTZf7ILSEeamywJKwo_BYs9M&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_"
		+ "state=0c32992f0d47e93d273922018ade42d1072b9d1f..a35c&prompt=none#";
//Testing git


String partialcode=url.split("code=")[1];

String code=partialcode.split("&scope")[0];

System.out.println(code);

String response =given() .urlEncodingEnabled(false)

                       .queryParams("code",code)

                        .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

                        .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

                        .queryParams("grant_type", "authorization_code")

                        .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")

                        .when().log().all()

                        .post("https://www.googleapis.com/oauth2/v4/token").asString();

        System.out.println(response);

JsonPath jsonPath = new JsonPath(response);

    String accessToken = jsonPath.getString("access_token");

    System.out.println(accessToken);

String r2=given().queryParams("access_token", accessToken).when().log().all()

           .get("https://rahulshettyacademy.com/getCourse.php").asString();

     System.out.println(r2);



}



}



	
