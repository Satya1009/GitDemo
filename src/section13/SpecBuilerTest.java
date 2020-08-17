package section13;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import section12.Data;
import section12.Location;

public class SpecBuilerTest {
	public static void main(String[]args) {
		
	Data d=new Data();
	d.setAccuracy(50);
	d.setAddress("29, side layout, cohen 09");
	d.setLanguage("French-IN");
	d.setName("Frontline house");
	d.setPhone_number("(+91) 983 893 3937");
	d.setWebsite("http://google.com");
	List<String> mylist=new ArrayList<String>();
	mylist.add("shoe park");
	mylist.add("shop");
	d.setTypes(mylist);
	Location l=new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	d.setLocation(l);
	
	
RequestSpecification	req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
	.setContentType(ContentType.JSON).build();
	ResponseSpecification resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	// TODO Auto-generated method stub
	//RestAssured.baseURI="https://rahulshettyacademy.com";
	RequestSpecification res=given().spec(req)
    .body(d);
  Response response= res .when().post("/maps/api/place/add/json")
    .then().spec(resspec).extract().response();
	String responseString=response.asString();
	System.out.println(responseString);
	
}

}


