package pages.demoqaPracticForm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static common.Config.IMAGE_NAME;
import static common.Config.IMAGE_PATH;

public class DemoPracticFormPage extends BasePage {

    public DemoPracticFormPage(WebDriver driver) {
        super(driver);
    }

    By firstName = By.cssSelector("input#firstName");
    By lastName = By.id("lastName");
    By email = By.xpath("//input[@id='userEmail']");
    By phoneNumber = By.id("userNumber");
    By birthDay = By.cssSelector("input#dateOfBirthInput");
    By subject = By.cssSelector("input#subjectsInput");
    By submitForm = By.xpath("//button[@id='submit']");
    By inputPicture = By.id("uploadPicture");
    By currentAddress = By.xpath("//div[@id='currentAddress-wrapper']//div[2]//textarea[@id='currentAddress']");
    By selectState = By.cssSelector("div#state");
    By selectCity = By.cssSelector("div#city");
    public static Map<String, String> regData = new HashMap<String, String>();

    //First Name
    public DemoPracticFormPage enterTextAsFirstname(){
        String firstNameForInput = "Sergey";
        WebElement element = driver.findElement(firstName);
        element.click();
        {
            element.sendKeys(firstNameForInput);
            regData.put("Name", firstNameForInput);
        }
        return this;
    }

    //Second Name
    public DemoPracticFormPage enterTextAsLastName(){
        String lastNameForInput = "Miller";
        WebElement element = driver.findElement(lastName);
        element.click();
        element.sendKeys(lastNameForInput);
        regData.put("Family", lastNameForInput);
        return this;
    }

    //e-mail
    public DemoPracticFormPage enterEmail(){
        String eMail = "s.miller@list.ru";
        WebElement element = driver.findElement(email);
        element.click();
        element.sendKeys(eMail);
        regData.put("Mail", eMail);
        return this;
    }

    //Gender
    public DemoPracticFormPage choiceGender(){
        Random randGender = new Random();
        int genderChoice = randGender.nextInt(3) + 1;
        By genderRadios = By.xpath("//div[@id='genterWrapper']//div[2]//div["+genderChoice+"]//input[@name='gender']");
        WebElement element = driver.findElement(genderRadios);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        regData.put("Gender", element.getAttribute("value"));
        return this;
    }

    //phone number
    public DemoPracticFormPage enterPhone(){
        WebElement element = driver.findElement(phoneNumber);
        element.click();

        Random random = new Random();
        String digit = "";
        for (int i = 0; i < 10; i++){
            digit += random.nextInt(10);
        }
        element.sendKeys(digit);
        regData.put("Phone", digit);
        return this;
    }

    //Day of Birth
    public DemoPracticFormPage setDateOfBirth(){
        driver.findElement(birthDay).click();

        By yearOfBirth = By.xpath("//select[@class='react-datepicker__year-select']/option[@value='1990']");
        By mounthOfBirth = By.xpath("//select[@class='react-datepicker__month-select']/option[@value='6']");
        By dayOfBirth = By.xpath("//div[@class='react-datepicker__month']/div[@class='react-datepicker__week']/div[@class='react-datepicker__day react-datepicker__day--011']");

        WebElement elementYear = driver.findElement(yearOfBirth);
        String year = elementYear.getAttribute("value");
        elementYear.click();

        WebElement elementMounth = driver.findElement(mounthOfBirth);
        String mounth = elementMounth.getText();
        elementMounth.click();

        WebElement elementDay = driver.findElement(dayOfBirth);
        String day = elementDay.getText();
        elementDay.click();

        String dayOfBirthFromUser = day + " " + mounth + "," + year;
        regData.put("DayOfBirth", dayOfBirthFromUser);

        return this;
    }

    //Subjects
    public DemoPracticFormPage enterSubject(){
        String subjectsForForm = "Hello World!!!";
        WebElement element = driver.findElement(subject);
        element.click();
        element.sendKeys(subjectsForForm);
        regData.put("Subjects", subjectsForForm);
        return this;
    }

    //image file
    public DemoPracticFormPage uploadPictureToInput(){
        WebElement element = driver.findElement(inputPicture);
        element.sendKeys(IMAGE_PATH);
        regData.put("Image", IMAGE_NAME);
        return this;
    }

    //current address
    public DemoPracticFormPage currentAddress(){
        String currentAddressForForm = "USA, state: California, city: Sacramento, street: First National, 34/5";
        WebElement element = driver.findElement(currentAddress);
        element.click();
        element.sendKeys(currentAddressForForm);
        regData.put("Address", currentAddressForForm);
        return this;
    }

    //select state
    public DemoPracticFormPage selectState(){
        WebElement element = driver.findElement(selectState);
        element.click();
        By menu = By.xpath("//div[@class=' css-26l3qy-menu']//div[@class=' css-11unzgr']//div[@id='react-select-3-option-0']");
        WebElement state = driver.findElement(menu);
        String stateStr = state.getText();
        state.click();
        regData.put("State", stateStr);
        return this;
    }

    //select city
    public DemoPracticFormPage selectCity(){
        WebElement element = driver.findElement(selectCity);
        element.click();
        By menu = By.xpath("//div[@class=' css-26l3qy-menu']//div[@class=' css-11unzgr']//div[@id='react-select-4-option-1']");
        WebElement city = driver.findElement(menu);
        String cityStr = city.getText();
        city.click();
        regData.put("City", cityStr);
        return this;
    }

    //Submit button (request)
    public DemoPracticFormPage submitForm(){
        driver.findElement(submitForm).click();
        return this;
    }
}
