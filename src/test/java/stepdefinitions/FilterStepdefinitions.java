package stepdefinitions;

import heynoshPages.FilterPage;
import heynoshPages.LoginPage;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.ReusableMethods;

public class FilterStepdefinitions extends ReusableMethods {

    LoginPage loginPage = new LoginPage();
    FilterPage filterPage=new FilterPage();
    WebElement element;


    @Then("User clicks filter button")
    public void user_clicks_filter_button() {



    }
    @Given("User clicks New on HeyNosh filter")
    public void user_clicks_new_on_hey_nosh_filter() throws InterruptedException {
        waitFor(3);
        try{
            clickJS(loginPage.location_West);
            waitForClickAbility(loginPage.location_West, 15);


        }catch (Exception e){
            System.out.println("Uygulama konum istemedi");

        }

        clickJS(filterPage.openFilter);
        waitFor(2);
        scroll(Driver.getDriver(),1);
        element =  Driver.getDriver().findElements(AppiumBy.className("android.widget.Button")).get(3);
        String showResult= element.getText().split(" ")[1];
        int result= Integer.parseInt(showResult);
        System.out.println("result = " + result);
        clickJS(filterPage.NewOnHeynosh);
        waitFor(3);

        element = Driver.getDriver().findElements(AppiumBy.className("android.widget.Button")).get(3);
        String newOnHeynoshResult= element.getText().split(" ")[1];
        int resultnewOnHeynosh= Integer.parseInt(newOnHeynoshResult);
        System.out.println("resultnewOnHeynosh = " + resultnewOnHeynosh);

        boolean filterResult=result>resultnewOnHeynosh;
        Assert.assertTrue(filterResult);


        clickJS(filterPage.NewOnHeynosh);
        waitFor(3);


    }
    @Then("User clicks fifty discounted")
    public void user_clicks_fifty_discounted() {

    }
    @Then("User clicks fourty discounted")
    public void user_clicks_fourty_discounted() {

    }
    @Then("User clicks thirty discounted")
    public void user_clicks_thirty_discounted() {

    }
    @Then("User clicks BBQ month")
    public void user_clicks_bbq_month() {

        element = Driver.getDriver().findElements(AppiumBy.className("android.widget.Button")).get(3);
        String showResult= element.getText().split(" ")[1];
        int result= Integer.parseInt(showResult);

        clickJS(filterPage.BBQ);
        waitFor(3);

        element =  Driver.getDriver().findElements(AppiumBy.className("android.widget.Button")).get(3);
        String BBQResult= element.getText().split(" ")[1];
        int resultBBQResult= Integer.parseInt(BBQResult);
        System.out.println("resultBBQResult = " + resultBBQResult);


        boolean filterResult=result>resultBBQResult;
        Assert.assertTrue(filterResult);

        clickJS(filterPage.BBQ);
        waitFor(3);

    }
    @Then("User clicks Free parking")
    public void user_clicks_free_parking() {
        element = Driver.getDriver().findElements(AppiumBy.className("android.widget.Button")).get(3);
        String showResult= element.getText().split(" ")[1];
        int result= Integer.parseInt(showResult);

        clickJS(filterPage.freeParking);
        waitFor(3);

        element = Driver.getDriver().findElements(AppiumBy.className("android.widget.Button")).get(3);
        String freeParkingResult= element.getText().split(" ")[1];
        int resultfreeParkingResult= Integer.parseInt(freeParkingResult);
        System.out.println("resultfreeParkingResult = " + resultfreeParkingResult);

        boolean filterResult=result> resultfreeParkingResult;
        Assert.assertTrue(filterResult);

        clickJS(filterPage.freeParking);
        waitFor(3);


    }


    @Given("User clicks All you can eat")
    public void userClicksAllYouCanEat() throws InterruptedException {
        scroll(Driver.getDriver(),2);


        element = Driver.getDriver().findElements(AppiumBy.className("android.widget.Button")).get(3);
        String showResult= element.getText().split(" ")[1];
        int result= Integer.parseInt(showResult);

        clickJS(filterPage.AllYouCanEat);
        waitFor(3);

        element =Driver.getDriver().findElements(AppiumBy.className("android.widget.Button")).get(3);
        String AllYouCanEatResult= element.getText().split(" ")[1];
        int resultAllYouCanEat= Integer.parseInt(AllYouCanEatResult);
        System.out.println("resultAllYouCanEat = " + resultAllYouCanEat);

        boolean filterResult=result> resultAllYouCanEat;
        Assert.assertTrue(filterResult);

        clickJS(filterPage.AllYouCanEat);
        waitFor(3);





    }

    @Given("User clicks Fastfood")
    public void userClicksFastfood() {
        element = Driver.getDriver().findElements(AppiumBy.className("android.widget.Button")).get(3);
        String showResult= element.getText().split(" ")[1];
        int result= Integer.parseInt(showResult);

        clickJS(filterPage.Fastfood);
        waitFor(3);

        element = Driver.getDriver().findElements(AppiumBy.className("android.widget.Button")).get(3);
        String FastfoodResult= element.getText().split(" ")[1];
        int resultFastfood= Integer.parseInt(FastfoodResult);
        System.out.println("resultFastfood = " + resultFastfood);

        boolean filterResult=result> resultFastfood;
        Assert.assertTrue(filterResult);

        clickJS(filterPage.Fastfood);
    }
}
