package pages.modalWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import pages.base.BasePage;
import pages.demoqaPracticForm.DemoPracticFormPage;

import java.util.HashMap;
import java.util.Map;

import static pages.modalWindow.ModalWindowData.modalWindowTitle;

public class ModalWindowPage extends BasePage {
    public ModalWindowPage(WebDriver driver) {
        super(driver);
    }

    DemoPracticFormPage dp = new DemoPracticFormPage(driver);
    Map<String, String> inputsFromUser = dp.regData;

    private final By modalForm = By.xpath("//div[@class='modal-content']//div[@class='modal-header']//div[@class='modal-title h4']");

    public ModalWindowPage checkModalWindow(){
        if (driver.findElements(modalForm).size() > 0){
            System.out.println("Модальное окно появилось");

            String titleOfWindow = driver.findElement(modalForm).getText();
            if (!titleOfWindow.equals(modalWindowTitle)){
                Assert.fail("Ожидаемый заголовок у модального окна не соответсвует ожидаемому");
            }
            else{
                System.out.println("Ожидаемый заголовок у модального окна соответсвует ожидаемому");
            }
            //Assert.assertEquals(titleOfWindow, modalWindowTitle);
        }
        else{
            System.out.println("Модального окна нет");
        }
        return this;
    }

    public ModalWindowPage getUserNameFromMW(){
        By userNameSelector = By.xpath("//div[@class='table-responsive']//table//tbody//tr[1]//td[2]");
        WebElement userName = driver.findElement(userNameSelector);
        String userNameStr = userName.getText();
        //System.out.println(isCompleate(userNameStr, inputsFromUser.get("Name") + " " + inputsFromUser.get("Family")));
        Assert.assertEquals(userNameStr, inputsFromUser.get("Name") + " " + inputsFromUser.get("Family"),
                isCompleate(userNameStr, inputsFromUser.get("Name") + " " + inputsFromUser.get("Family")));
        return this;
    }

    public ModalWindowPage getUserEmailFromMW(){
        By userEmailSelector = By.xpath("//div[@class='table-responsive']//table//tbody//tr[2]//td[2]");
        WebElement userMail = driver.findElement(userEmailSelector);
        String userMailStr = userMail.getText();
        //System.out.println(isCompleate(userMailStr, inputsFromUser.get("Mail")));
        Assert.assertEquals(userMailStr, inputsFromUser.get("Mail"),
                isCompleate(userMailStr, inputsFromUser.get("Mail")));
        return this;
    }

    public ModalWindowPage getUserGenderFromMW(){
        By userGenderSelector = By.xpath("//div[@class='table-responsive']//table//tbody//tr[3]//td[2]");
        WebElement userGender = driver.findElement(userGenderSelector);
        String userGenderlStr = userGender.getText();
        //System.out.println(isCompleate(userGenderlStr, inputsFromUser.get("Gender")));
        Assert.assertEquals(userGenderlStr, inputsFromUser.get("Gender"),
                isCompleate(userGenderlStr, inputsFromUser.get("Gender")));
        return this;
    }

    public ModalWindowPage getUserPhoneFromMW(){
        By userPhoneSelector = By.xpath("//div[@class='table-responsive']//table//tbody//tr[4]//td[2]");
        WebElement userPhone = driver.findElement(userPhoneSelector);
        String userPhoneStr = userPhone.getText();
        //System.out.println(isCompleate(userPhoneStr, inputsFromUser.get("Phone")));
        Assert.assertEquals(userPhoneStr, inputsFromUser.get("Phone"),
                isCompleate(userPhoneStr, inputsFromUser.get("Phone")));
        return this;
    }

    public ModalWindowPage getUserDoBFromMW(){
        By userDoBSelector = By.xpath("//div[@class='table-responsive']//table//tbody//tr[5]//td[2]");
        WebElement userDayOfBirth = driver.findElement(userDoBSelector);
        String userDayOfBirthStr = userDayOfBirth.getText();
        //System.out.println(isCompleate(userDayOfBirthStr, inputsFromUser.get("DayOfBirth")));
        Assert.assertEquals(userDayOfBirthStr, inputsFromUser.get("DayOfBirth"),
                isCompleate(userDayOfBirthStr, inputsFromUser.get("DayOfBirth")));
        return this;
    }

    public ModalWindowPage getUserSubjectsFromMW(){
        By userSubjectsSelector = By.xpath("//div[@class='table-responsive']//table//tbody//tr[6]//td[2]");
        WebElement userSubjects = driver.findElement(userSubjectsSelector);
        String userSubjectsStr = userSubjects.getText();
        //System.out.println(isCompleate(userSubjectsStr, inputsFromUser.get("Subjects")));
        Assert.assertEquals(userSubjectsStr, inputsFromUser.get("Subjects"),
                isCompleate(userSubjectsStr, inputsFromUser.get("Subjects")));

        return this;
    }

    public ModalWindowPage getUserPictureFromMW(){
        By userPictureSelector = By.xpath("//div[@class='table-responsive']//table//tbody//tr[8]//td[2]");
        WebElement userPicture = driver.findElement(userPictureSelector);
        String userPictureStr = userPicture.getText();
        //System.out.println(isCompleate(userPictureStr, inputsFromUser.get("Image")));
        Assert.assertEquals(userPictureStr, inputsFromUser.get("Image"),
                isCompleate(userPictureStr, inputsFromUser.get("Image")));
        return this;
    }

    public ModalWindowPage getAddressFromMW(){
        By userAddressSelector = By.xpath("//div[@class='table-responsive']//table//tbody//tr[9]//td[2]");
        WebElement userAddress = driver.findElement(userAddressSelector);
        String userAddressStr = userAddress.getText();
        //System.out.println(isCompleate(userAddressStr, inputsFromUser.get("Address")));
        Assert.assertEquals(userAddressStr, inputsFromUser.get("Address"),
                isCompleate(userAddressStr, inputsFromUser.get("Address")));
        return this;
    }

    public ModalWindowPage getStateCityFromMW(){
        By userStateSelector = By.xpath("//div[@class='table-responsive']//table//tbody//tr[10]//td[2]");
        WebElement userState = driver.findElement(userStateSelector);
        String userStateStr = userState.getText();
        //System.out.println(isCompleate(userStateStr, inputsFromUser.get("State") + " " + inputsFromUser.get("City")));
        Assert.assertEquals(userStateStr, inputsFromUser.get("State") + " " + inputsFromUser.get("City"),
                isCompleate(userStateStr, inputsFromUser.get("State") + " " + inputsFromUser.get("City")));
        return this;
    }

    protected String isCompleate(String fromModalW, String fromUserinput){
        String result = null;
        if (fromModalW.equals(fromUserinput)){
            result = "Значение указаное пользователем при заполнении формы - " + fromUserinput + " было отправлено и получено сервером - " + fromModalW;
        }
        else{
            result = "Что-то не так, значение указаное пользователем при заполнении формы - " + fromUserinput + " не пришло на сервер -" + fromModalW;
        }
        return result;
    }

    public ModalWindowPage checkDataIntoMW(){
        Map<String, String> inputsFromUser = dp.regData;

        for (String key : inputsFromUser.keySet()){
            System.out.println(key + ": " + inputsFromUser.get(key));
        }
        return this;
    }
}
