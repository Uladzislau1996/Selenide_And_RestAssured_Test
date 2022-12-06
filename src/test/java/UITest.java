import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class UITest {

    @BeforeMethod
    public void setUp(){
        Configuration.browser = "Chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.driverManagerEnabled = true;
        //Configuration.headless = true;
        Selenide.open("https://reqres.in/");
    }

    @AfterMethod
    public void tearDown(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

    @Test
    public void checkAllElementsArePresent(){
        MainPage mainPage = new MainPage();
        mainPage.checkElementIsPresent();
    }

    @Test
    public void checkUrlRequest(){
        MainPage mainPage = new MainPage();
        mainPage.clickGetListUser();
        mainPage.getUrlRequest("/api/users?page=2");
        mainPage.clickGetSingleUser();
        mainPage.getUrlRequest("/api/users/2");
        mainPage.clickGetSingleUserNotFound();
        mainPage.getUrlRequest("/api/users/23");
        mainPage.clickGetListResource();
        mainPage.getUrlRequest("/api/unknown");
        mainPage.clickGetSingleResource();
        mainPage.getUrlRequest("/api/unknown/2");
        mainPage.clickGetSingleResourceNotFound();
        mainPage.getUrlRequest("/api/unknown/23");
        mainPage.clickPostCreate();
        mainPage.getUrlRequest("/api/users");
        mainPage.clickPutUpdate();
        mainPage.getUrlRequest("/api/users/2");
        mainPage.clickPatchUpdate();
        mainPage.getUrlRequest("/api/users/2");
        mainPage.clickDelete();
        mainPage.getUrlRequest("/api/users/2");
        mainPage.clickPostRegisterSuccessful();
        mainPage.getUrlRequest("/api/register");
        mainPage.clickPostRegisterUnsuccessful();
        mainPage.getUrlRequest("/api/register");
        mainPage.clickPostLoginSuccessful();
        mainPage.getUrlRequest("/api/login");
        mainPage.clickPostLoginUnsuccessful();
        mainPage.getUrlRequest("/api/login");
        mainPage.clickGetDelayedResponse();
        mainPage.getUrlRequest("/api/users?delay=3");}

    @Test
    public void checkResponseCode(){
        MainPage mainPage = new MainPage();
        mainPage.clickGetListUser();
        mainPage.checkResponseCode("200");
        mainPage.clickGetSingleUser();
        mainPage.checkResponseCode("200");
        mainPage.clickGetSingleUserNotFound();
        mainPage.checkResponseCode("404");
        mainPage.clickGetListResource();
        mainPage.checkResponseCode("200");
        mainPage.clickGetSingleResource();
        mainPage.checkResponseCode("200");
        mainPage.clickGetSingleResourceNotFound();
        mainPage.checkResponseCode("404");
        mainPage.clickPostCreate();
        mainPage.checkResponseCode("201");
        mainPage.clickPutUpdate();
        mainPage.checkResponseCode("200");
        mainPage.clickPatchUpdate();
        mainPage.checkResponseCode("200");
        mainPage.clickDelete();
        mainPage.checkResponseCode("204");
        mainPage.clickPostRegisterSuccessful();
        mainPage.checkResponseCode("200");
        mainPage.clickPostRegisterUnsuccessful();
        mainPage.checkResponseCode("400");
        mainPage.clickPostLoginSuccessful();
        mainPage.checkResponseCode("200");
        mainPage.clickPostLoginUnsuccessful();
        mainPage.checkResponseCode("400");
        mainPage.clickGetDelayedResponse();
        mainPage.checkResponseCode("400");
    }

}
