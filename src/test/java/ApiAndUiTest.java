import com.google.common.collect.ImmutableMap;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import static io.restassured.RestAssured.*;


public class ApiAndUiTest {

    private final static String URL = "https://reqres.in";

    @BeforeSuite
    void setAllureEnvironment() {
        allureEnvironmentWriter( ImmutableMap
                .<String, String>builder()
                    .put("Browser", "Chrome")
                    .put("Browser.Version", "107.0.5304.121")
                    .put("URL", "https://reqres.in/")
                    .build(), System.getProperty("user.dir")
                    + "/allure-results/");
    }

    @Test
    public void checkSuccessfulRegistrationTest(){
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Registration user = new Registration("eve.holt@reqres.in", "pistol");
        SuccessRegistration successRegistration = given()
                .when()
                .body(user)
                .post(URL + "/api/register")
                .then().log().all()
                .extract().as(SuccessRegistration.class);

        Assert.assertNotNull(successRegistration.getId());
        Assert.assertNotNull(successRegistration.getToken());

        Assert.assertEquals(id, successRegistration.getId());
        Assert.assertEquals(token, successRegistration.getToken());
    }

    @Test
    public void checkUnSuccessfulRegistrationTest(){
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecError400());
        String error = "Missing password";
        Registration user = new Registration("sydney@fife", "" );
        UnSuccessRegistration unSuccessRegistration = given()
                .when()
                .body(user)
                .post(URL + "/api/register")
                .then().log().all()
                .extract().as(UnSuccessRegistration.class);

        Assert.assertEquals(error, unSuccessRegistration.getError());
    }

    @Test
    public void checkSuccessfulCreateNewUser(){
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecCreated201());
        String name = "morpheus";
        String job = "leader";
        CreaateNewUser creaateNewUser = new CreaateNewUser("morpheus", "leader");
        SuccessCreateNewUser successCreateNewUser = given()
                .when()
                .body(creaateNewUser)
                .post(URL + "/api/users")
                .then().log().all()
                .extract().as(SuccessCreateNewUser.class);
        Assert.assertEquals(successCreateNewUser.getName(), name, "Check the Name field");
        Assert.assertEquals(successCreateNewUser.getJob(), job, "Check the Job field");
        Assert.assertNotNull(successCreateNewUser.getId(),"Check the Id field");
        Assert.assertNotNull(successCreateNewUser.getCreatedAt(),"Check the CreatedAt field");
    }

    @Test
    public void checkError404(){
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecError404());
        given().when().get(URL+"/api/users/23");
    }

    @Test
    public void checkUserUpdate(){
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        String name = "morpheus";
        String job = "zion resident";
        CreaateNewUser creaateNewUser = new CreaateNewUser("morpheus", "zion resident");
        SuccessUpdate successUpdate = given()
                .when()
                .body(creaateNewUser)
                .put(URL + "/api/users/2")
                .then().log().all()
                .extract().as(SuccessUpdate.class);
        Assert.assertEquals(successUpdate.getName(), name, "Check the Name field");
        Assert.assertEquals(successUpdate.getJob(), job, "Check the Job field");
        Assert.assertNotNull(successUpdate.getUpdatedAt(),"Check the CreatedAt field");
    }


}


