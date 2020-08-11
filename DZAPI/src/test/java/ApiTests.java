import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    @Test()
    public void testAvatarComparison(){
        List<String> avatarList = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().all()
                .extract().path("data.avatar");
        Set<String> avatarSet = new HashSet<String>(avatarList);
        Assert.assertEquals(avatarSet.size(), avatarList.size());
    }

    @Test()
    public void testRegistration(){
        Map<String,String> data = new HashMap<>();
        data.put("email", "tobias.funke@reqres.in");
        data.put("password", "office");
        Response response = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();
        JsonPath jsonResponse = response.jsonPath();
        Assert.assertNotNull(jsonResponse.get("id"));
        Assert.assertNotNull(jsonResponse.get("token"));
    }

    @Test()
    public void testRegistrationNoPass(){
        Map<String,String> data = new HashMap<>();
        data.put("email", "tobias.funke@reqres.in");
        Response response = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().all()
                .statusCode(400)
                .extract()
                .response();
        JsonPath jsonResponse = response.jsonPath();
        Assert.assertEquals(jsonResponse.get("error").toString(), "Missing password");
    }

    @Test()
    public void testListOrder(){
        List<String> yearList = given()
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .log().all()
                .extract().path("data.year");
        List<Integer> yearInt = new ArrayList<Integer>();
        for (int i = 0; i < yearList.size(); i++){
            String temp = String.valueOf(yearList.get(i));
            int we = Integer.parseInt(temp);
            yearInt.add(we);
        }
        for (int i = 0; i < yearInt.size()-1; i++){
            if (yearInt.get(i)>yearInt.get(i+1)){
                Assert.assertTrue(false);
            }
        }
        Assert.assertTrue(true);
    }
    
}
