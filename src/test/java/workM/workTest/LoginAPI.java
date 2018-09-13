package workM.workTest;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginAPI {

	public Properties prop;
	
	@Test(dataProvider = "getData")
	public void login(String firstName, String lastName, String username, String password, String email,
			String phoneNumber, String TCNumber) throws IOException {

		 prop= new Properties();
		 FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//data.properties");
		 prop.load(fis);
		
		RestAssured.baseURI = prop.getProperty("url");
		System.out.print("\n\n");
		System.out.print("===========TEST============");
		System.out.print("\n\n");

		System.out.println(TCNumber);
		String body = "	 { \r\n" + "  \"firstName\": \"" + firstName + "\",\r\n" + "  \"lastName\":  \"" + lastName
				+ "\",\r\n" + "  \"username\": \"" + username + "\",\r\n" + "  \"password\": \"" + password + "\",\r\n"
				+ "  \"email\": \"" + email + "\",\r\n" + "  \"phoneNumber\":\"" + phoneNumber + "\"\r\n" + "}\r\n"
				+ "";
		System.out.println(body);

		Response res = given().header("Content-Type", "application/json").body(body).when().post().then().extract()
				.response();
		JsonPath js = ReusableMethods.rawToJson(res);
		String success = js.getString("success");
		System.out.println(TCNumber);

		System.out.println("      Received: Success:" + success);
		
		if (success.equals("false")) {
			List<String> err = js.get("errors");
			Iterator<String> it = err.iterator();
			while (it.hasNext()) {
				String strerr = it.next();
				System.out.println("Errors: " + strerr);
			}
		}

		if (TCNumber.contains("true")) {
			Assert.assertEquals(success, "true", "FAILED:   " + TCNumber);
			System.out.println("      PASSSED:   " + TCNumber.substring(0, 5));
		}
		if (TCNumber.contains("false")) {
			Assert.assertEquals(success, "false", "FAILED:   " + TCNumber);
			System.out.println("      PASSSED:   " + TCNumber.substring(0, 5));
		}

		

		System.out.print("\n\n\n");
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[13][7];
		Faker faker = new Faker();

		// TC#1
		// positive test case
		// Alpha characters + spaces + apostrophe
		data[0][0] = faker.name().firstName() + "  " + "'" + faker.numerify("#");
		data[0][1] = faker.name().lastName() + "  " + "'" + faker.numerify("#");
		// always returns username > 2 chars;
		data[0][2] = faker.name().username();
		// generates password with minimum 7, maximum 19, atleast 1 number, includes
		// special chars and upper case.
		// data[0][3] = faker.internet().password(7, 19, true, true);
		data[0][3] = "^%G$a1*";
		// gets a email address - which always has a @
		data[0][4] = faker.internet().emailAddress();
		// gets the random numbers in the below format.
		data[0][5] = faker.numerify("###-###-####");
		data[0][6] = "TC#1: Expected: Success:true && This is valid/positive test scenario";

		// TC#2 // "First name contains invalid characters."
		data[1][0] = faker.internet().password(15, 30, true, true);
		data[1][1] = faker.name().lastName() + "  " + "'" + faker.numerify("#");
		data[1][2] = faker.name().username();
		data[1][3] = faker.internet().password(7, 19, true, true);
		data[1][4] = faker.internet().emailAddress();
		data[1][5] = faker.numerify("###-###-####");
		data[1][6] = "TC#2: Expected: Success:false && Errors: First Name contains Invalid Characters";

		// TC#3 // "Last name contains invalid characters."
		data[2][0] = faker.name().firstName();
		data[2][1] = faker.internet().password(15, 30, true, true);
		data[2][2] = faker.name().username();
		data[2][3] = faker.internet().password(7, 19, true, true);
		data[2][4] = faker.internet().emailAddress();
		data[2][5] = faker.numerify("###-###-####");
		data[2][6] = "TC#3: Expected- Success:false && Errors: Last Name contains Invalid Characters";

		// TC#4 // "Username must be at least 2 characters in length."
		data[3][0] = faker.name().title() + faker.name().firstName();
		data[3][1] = faker.name().lastName() + faker.name().suffix();
		data[3][2] = faker.bothify("?");
		data[3][3] = faker.internet().password(7, 19, true, true);
		data[3][4] = faker.internet().emailAddress();
		data[3][5] = faker.numerify("###-###-####");
		data[3][6] = "TC#4: Expected- Success:false && Errors: Username must be at least 2 characters in length";

		// TC#5 //"Password does not meet all requirements."// its not greater than
		// 6characters
		data[4][0] = faker.name().fullName() + faker.name().suffix();
		data[4][1] = faker.name().lastName();
		data[4][2] = faker.name().username();
		data[4][3] = faker.internet().password(1, 6, true, true);
		data[4][4] = faker.internet().emailAddress();
		data[4][5] = faker.numerify("###-###-####");
		data[4][6] = "TC#5: Expected- Success:false && Errors: Password is not greater than 6 chars";

		// TC#6 //"Password does not meet all requirements.", //its greater than
		// 20characters
		data[5][0] = faker.name().firstName() + "'";
		data[5][1] = faker.name().lastName() + "'";
		data[5][2] = faker.name().username();
		data[5][3] = faker.internet().password(21, 30, true, true);
		data[5][4] = faker.internet().emailAddress();
		data[5][5] = faker.numerify("###-###-####");
		data[5][6] = "TC#6: Expected- Success:false && Errors: Password is greater than 20 chars";

		// TC#7 //"Password does not meet all requirements.", //it doesn't contain any
		// Upper case Letter
		data[6][0] = faker.name().firstName();
		data[6][1] = faker.name().lastName();
		data[6][2] = faker.name().username();
		data[6][3] = faker.internet().password(7, 19, false, true);
		data[6][4] = faker.internet().emailAddress();
		data[6][5] = faker.numerify("###-###-####");
		data[6][6] = "TC#7: Expected- Success:false && Errors: Password doesn't contain any upper case letter";

		// TC#8 //"Password does not meet all requirements.", // it doesn't contain any
		// lower case letter
		data[7][0] = faker.name().firstName();
		data[7][1] = faker.name().lastName();
		data[7][2] = faker.name().username();
		data[7][3] = faker.internet().password(7, 19, false, true).toUpperCase();
		data[7][4] = faker.internet().emailAddress();
		data[7][5] = faker.numerify("###-###-####");
		data[7][6] = "TC#8: Expected- Success:false && Errors: Password doesn't contain any lower case letter";

		// TC#8 //"Password does not meet all requirements.", //it doesn't contain any
		// number// replaced all numbers with R
		System.out.println("Password doesn't contain any numbers.");
		data[8][0] = faker.name().firstName();
		data[8][1] = faker.name().lastName();
		data[8][2] = faker.name().username();
		data[8][3] = faker.internet().password(7, 19, true, true).replaceAll("[*0-9]", "R");
		data[8][4] = faker.internet().emailAddress();
		data[8][5] = faker.numerify("###-###-####");
		data[8][6] = "TC#9: Expected- Success:false && Errors: Password doesn't contain any numbers";

		// TC#9 //"Password does not meet all requirements.", //it doesn't contain any
		// special character
		data[9][0] = faker.name().firstName();
		data[9][1] = faker.name().lastName();
		data[9][2] = faker.name().username();
		data[9][3] = faker.internet().password(7, 19, true, false);
		data[9][4] = faker.internet().emailAddress();
		data[9][5] = faker.numerify("###-###-####");
		data[9][6] = "TC#10: Expected- Success:false && Errors: Password doesn't contain any special characters";

		// TC#10 //"A valid email must be provided." //it doesn't contain @
		data[10][0] = faker.name().firstName();
		data[10][1] = faker.name().lastName();
		data[10][2] = faker.name().username();
		data[10][3] = faker.internet().password(7, 19, true, false);
		data[10][4] = faker.internet().emailAddress().replace("@", "#");
		data[10][5] = faker.numerify("###-###-####");
		data[10][6] = "TC#11: Expected- Success:false && Errors: A valid email must be provided";

		// TC#11 //"A valid phone must be provided."
		data[11][0] = faker.name().firstName();
		data[11][1] = faker.name().lastName();
		data[11][2] = faker.name().username();
		data[11][3] = faker.internet().password(7, 19, true, false);
		data[11][4] = faker.internet().emailAddress();
		data[11][5] = faker.numerify("1-###-###-####");
		data[11][6] = "TC#12: Expected- Success:false && Errors: A valid phone must be provided";

		// TC#12 //"All Invalid
		data[12][0] = faker.internet().password(10, 20, true, true);
		data[12][1] = faker.internet().password(10, 20, true, true);
		data[12][2] = faker.bothify("?");
		data[12][3] = faker.internet().password(7, 25, false, false);
		data[12][4] = faker.internet().emailAddress().replace("@", "#");
		data[12][5] = faker.numerify("(###)-###-####");
		data[12][6] = "TC#13: Expected- Success:false && Errors: All errors to be displayed";

		return data;

	}

}
