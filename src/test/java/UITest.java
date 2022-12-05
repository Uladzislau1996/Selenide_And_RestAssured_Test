import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class UITest {

    /*@BeforeMethod
    public void setUp(){
        Configuration.browser = "Chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.driverManagerEnabled = false;
        Configuration.headless = true;
    }*/

    @AfterMethod
    public void tearDown(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

    @Test
    public void checkAllElementsArePresent(){
        Selenide.open("https://reqres.in/");
        MainPage mainPage = new MainPage();
        mainPage.checkElementIsPresent();
    }

    @Test
    public void checkUrlRequest(){
        Selenide.open("https://reqres.in/");
        MainPage mainPage = new MainPage();
        mainPage.clickGetListUser();
        Assert.assertEquals(mainPage.getUrlRequest(), "/api/users?page=2", "Not correct URL for Get ListUser request");
        mainPage.clickGetSingleUser();
        Assert.assertEquals(mainPage.getUrlRequest(), "/api/users/2", "Not correct URL for Get SingleUser request");
        mainPage.clickGetSingleUserNotFound();
        Assert.assertEquals(mainPage.getUrlRequest(), "/api/users/23", "Not correct URL for Get SingleUserNotFound request");
        mainPage.clickGetListResource();
        Assert.assertEquals(mainPage.getUrlRequest(), "/api/unknown", "Not correct URL for Get ListResource request");
        mainPage.clickGetSingleResource();
        Assert.assertEquals(mainPage.getUrlRequest(), "/api/unknown/2", "Not correct URL for Get SingleResource request");
        mainPage.clickGetSingleResourceNotFound();
        Assert.assertEquals(mainPage.getUrlRequest(), "/api/unknown/23", "Not correct URL for Get SingleResourceNotFound User request");
        mainPage.clickPostCreate();
        Assert.assertEquals(mainPage.getUrlRequest(), "/api/users", "Not correct URL for Post Create request");
        mainPage.clickPutUpdate();
        Assert.assertEquals(mainPage.getUrlRequest(), "/api/users/2", "Not correct URL for Put Update request");
        mainPage.clickPatchUpdate();
        Assert.assertEquals(mainPage.getUrlRequest(), "/api/users/2", "Not correct URL for Patch Update request");
        mainPage.clickDelete();
        Assert.assertEquals(mainPage.getUrlRequest(), "/api/users/2", "Not correct URL for Delete request");
        mainPage.clickPostRegisterSuccessful();
        Assert.assertEquals(mainPage.getUrlRequest(), "/api/register", "Not correct URL for Post RegisterSuccessful request");
        mainPage.clickPostRegisterUnsuccessful();
        Assert.assertEquals(mainPage.getUrlRequest(), "/api/register", "Not correct URL for Post RegisterUnsuccessful request");
        mainPage.clickPostLoginSuccessful();
        Assert.assertEquals(mainPage.getUrlRequest(), "/api/login", "Not correct URL for Post LoginSuccessful request");
        mainPage.clickPostLoginUnsuccessful();
        Assert.assertEquals(mainPage.getUrlRequest(), "/api/login", "Not correct URL for Post LoginUnsuccessful request");
        mainPage.clickGetDelayedResponse();
        Assert.assertEquals(mainPage.getUrlRequest(), "/api/users?delay=3", "Not correct URL for Get DelayedResponse request");
    }

}
