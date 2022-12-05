import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement logo = $(".logo>a");
    private SelenideElement tagLine1 = $(".wrap>.tagline:nth-child(1)");
    private SelenideElement bubbleSell1 = $(".key-sells>div:nth-child(1)");
    private SelenideElement bubbleSell2 = $(".key-sells>div:nth-child(2)");
    private SelenideElement bubbleSell3 = $(".key-sells>div:nth-child(3)");
    private SelenideElement tagLine2 = $(".wrap>h2:nth-child(3)");
    private SelenideElement getTagLine3 = $(".container>.home-content>div>h2:first-child");
    private SelenideElement supportReqresButton = $(".t-center>button");
    private SelenideElement requestTitle = $(".request-title");
    private SelenideElement requestUrl = $(".try-link>.url");
    private SelenideElement responseTitle = $(".response-title");
    private SelenideElement response = $(".response>pre");
    private SelenideElement getListUser = $(".endpoints>ul>li:nth-child(1)");
    private SelenideElement getSingleUser = $(".endpoints>ul>li:nth-child(2)");
    private SelenideElement getSingleUserNotFound = $(".endpoints>ul>li:nth-child(3)");
    private SelenideElement getListResource = $(".endpoints>ul>li:nth-child(4)");
    private SelenideElement getSingleResource = $(".endpoints>ul>li:nth-child(5)");
    private SelenideElement getSingleResourceNotFound = $(".endpoints>ul>li:nth-child(6)");
    private SelenideElement postCreate = $(".endpoints>ul>li:nth-child(7)");
    private SelenideElement putUpdate = $(".endpoints>ul>li:nth-child(8)");
    private SelenideElement patchUpdate = $(".endpoints>ul>li:nth-child(9)");
    private SelenideElement delete = $(".endpoints>ul>li:nth-child(10)");
    private SelenideElement postRegisterSuccessful = $(".endpoints>ul>li:nth-child(11)");
    private SelenideElement postRegisterUnSuccessful  = $(".endpoints>ul>li:nth-child(12)");
    private SelenideElement postLoginSuccessful = $(".endpoints>ul>li:nth-child(13)");
    private SelenideElement postLoginUnSuccessful = $(".endpoints>ul>li:nth-child(14)");
    private SelenideElement getDelayedResponse = $(".endpoints>ul>li:nth-child(15)");

    public void checkElementIsPresent(){
        logo.shouldBe(Condition.visible);
        tagLine1.shouldBe(Condition.visible);
        bubbleSell1.shouldBe(Condition.visible);
        bubbleSell2.shouldBe(Condition.visible);
        bubbleSell3.shouldBe(Condition.visible);
        getTagLine3.shouldBe(Condition.visible);
        supportReqresButton.shouldBe(Condition.visible);
        requestTitle.shouldBe(Condition.visible);
        responseTitle.shouldBe(Condition.visible);
        response.shouldBe(Condition.visible);
        getListUser.shouldBe(Condition.visible);
        getSingleUser.shouldBe(Condition.visible);
        getListResource.shouldBe(Condition.visible);
        getSingleUserNotFound.shouldBe(Condition.visible);
        getSingleResource.shouldBe(Condition.visible);
        getSingleResourceNotFound.shouldBe(Condition.visible);
        postCreate.shouldBe(Condition.visible);
        putUpdate.shouldBe(Condition.visible);
        patchUpdate.shouldBe(Condition.visible);
        delete.shouldBe(Condition.visible);
        postRegisterSuccessful.shouldBe(Condition.visible);
        postRegisterUnSuccessful.shouldBe(Condition.visible);
        postLoginSuccessful.shouldBe(Condition.visible);
        postLoginUnSuccessful.shouldBe(Condition.visible);
        getDelayedResponse.shouldBe(Condition.visible);
        tagLine2.shouldBe(Condition.visible);
    }

    public void clickGetListUser(){
        getListUser.click();
    }
    public void clickGetSingleUser(){
        getSingleUser.click();
    }
    public void clickGetSingleUserNotFound(){
        getSingleUserNotFound.click();
    }
    public void clickGetListResource(){
        getListResource.click();
    }
    public void clickGetSingleResource(){
        getSingleResource.click();
    }
    public void clickGetSingleResourceNotFound(){
        getSingleResourceNotFound.click();
    }
    public void clickPostCreate(){
        postCreate.click();
    }
    public void clickPutUpdate(){
        putUpdate.click();
    }
    public void clickPatchUpdate(){
        patchUpdate.click();
    }
    public void clickDelete(){
        delete.click();
    }
    public void clickPostRegisterSuccessful(){
        postRegisterSuccessful.click();
    }
    public void clickPostRegisterUnsuccessful(){
        postRegisterUnSuccessful.click();
    }
    public void clickPostLoginSuccessful(){
        postLoginSuccessful.click();
    }
    public void clickPostLoginUnsuccessful(){
        postLoginUnSuccessful.click();
    }
    public void clickGetDelayedResponse(){
        getDelayedResponse.click();
    }

    public String getUrlRequest(){
        return requestUrl.getText();
    }


}
