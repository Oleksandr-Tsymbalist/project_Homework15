package JsonPath;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class JsonPathTest {

    @Test
    public void getUserInfo() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        JsonPath jsonPath = given().
                when().
                get("/users").
                then().
                assertThat().
                statusCode(200).
                extract().
                jsonPath();

        // Виведення всіх email
        List<String> emails = jsonPath.getList("email");
        for (String email : emails) {
            System.out.println(email);
        }
        System.out.println("----------");

        // Виведення всіх zipcode
        List<String> zipCodes = jsonPath.getList("address.zipcode");
        for (String zipCode : zipCodes) {
            System.out.println(zipCode);
        }
            System.out.println("----------");

        // Виведення на екран тих zipcodes, які без тире
        List<String> zipcodesWithoutDash = jsonPath.getList("findAll {it.address.zipcode.contains('-') == false}.address.zipcode");
        for (String zipCode : zipcodesWithoutDash) {
            System.out.println(zipCode);
        }
        System.out.println("----------");

        // Для кожного name виведення значення lat та lng
        List<String> names = jsonPath.getList("name");
        for (String name : names) {
            double lat = jsonPath.getDouble("find{it.name == '" + name + "'}.address.geo.lat");
            double lng = jsonPath.getDouble("find{it.name == '" + name + "'}.address.geo.lng");
            System.out.println(name + " is situated at: lat = " + lat + " and lng = " + lng);
        }
        System.out.println("----------");

        // Виводимо username лише для тих користувачів, у яких значення lat та lng відʼємні
        List<String> userNames = jsonPath.getList("findAll {Double.parseDouble(it.address.geo.lat) < 0 && Double.parseDouble(it.address.geo.lng) < 0}.username");
        for (String userName : userNames) {
            System.out.println(userName);
        }
        System.out.println("----------");

        // Виведення username лише для тих в кого значення website закінчується на .info
        List<String> userWebsite = jsonPath.getList("findAll { it.website.endsWith('.info') }.username");
        for (String userName : userWebsite) {
            System.out.println(userName + " - " + jsonPath.getString("find { it.username == '" + userName + "' }.website"));
        }
        System.out.println("----------");

        // Виведення name в якого значення lng найбільше
        String nameWithHighestLng = jsonPath.get("max {it.address.geo.lng}.name");
        System.out.println(nameWithHighestLng);
        System.out.println("----------");

        // Виведення name в якого найдовша catchPhrase
        String nameWithLongestCatchPhrase = jsonPath.get("max {it.company.catchPhrase.length()}.name");
        System.out.println(nameWithLongestCatchPhrase);

    }
}