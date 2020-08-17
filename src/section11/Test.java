package section11;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.testng.Assert;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
//import pojo.Api;
//import pojo.GetCourse;

public class Test {

	public static void main(String[] args) {

		
				// TODO Auto-generated method stub
		String[] courseTitles= { "Selenium Webdriver Java","Cypress","Protractor"};
					String url="https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FvAHBQUZU6o4WJ719NrGBzSELBFVBI9XbxvOtYpmYpeV47bFVExkaxWaF_"
							+ "XR14PHtTZf7ILSEeamywJKwo_BYs9M&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_"
							+ "state=0c32992f0d47e93d273922018ade42d1072b9d1f..a35c&prompt=none#";
					String partialcode=url.split("code=")[1];
					String code=partialcode.split("&scope")[0];
					System.out.println(code);
	
					
			String accessTokenResponse=	given().urlEncodingEnabled(false)
				.queryParams("code",code)
				.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
				.queryParams("grant_type","authorization_code")
				.when().log().all()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();
			JsonPath js=new JsonPath(accessTokenResponse);
			String accessToken=js.getString("access_token");
				
				
				
				
				
				GetCourse gc=given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
				.when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
				
				System.out.println(gc.getLinkedin());
				System.out.println(gc.getInstructor());
				System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
				
				
				List<Api> apiCourses=gc.getCourses().getApi();
				for(int i=0;i<apiCourses.size();i++)
				{
					if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
							{
						System.out.println(apiCourses.get(i).getPrice());
							}
				}
				
				//Get the course names of WebAutomation
				ArrayList<String> a= new ArrayList<String>();
				
				
				List<WebAutomtion> w=gc.getCourses().getWebAutomation();
				
				for(int j=0;j<w.size();j++)
				{
					a.add(w.get(j).getCourseTitle());
				}
				
				List<String> expectedList=	Arrays.asList(courseTitles);
				
				Assert.assertTrue(a.equals(expectedList));
				
				
				
				
				
				
				//System.out.println(response);
				
				
			}

		

	}


