package section12;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

public class Serialization {

	public static void main(String[] args) {
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
		
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response res=given().queryParam("key", "qaclick123")
        .body(d)
        .when().post("/maps/api/place/add/json")
        .then().assertThat().statusCode(200).extract().response();
		String responseString=res.asString();
		System.out.println(responseString);
		
	}

}
