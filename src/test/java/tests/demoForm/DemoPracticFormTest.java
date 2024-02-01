package tests.demoForm;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class DemoPracticFormTest extends BaseTest {

    @Test
    public void checkIsRedirectToModalWindow(){
        basePage.open("https://demoqa.com/automation-practice-form");

        demoForm
                .enterTextAsFirstname()
                .enterTextAsLastName()
                .enterEmail()
                .choiceGender()
                .enterPhone()
                .setDateOfBirth()
                .enterSubject()
                .uploadPictureToInput()
                .currentAddress()
                .selectState()
                .selectCity()
                .submitForm();
    }

    @Test
    public void checkModalWindow(){
        modalPage
                .checkModalWindow();
    }

    @Test
    public void checkUserName(){
        modalPage
                .getUserNameFromMW();
    }

    @Test
    public void checkUserEmail(){
        modalPage
                .getUserEmailFromMW();
    }

    @Test
    public void checkUserGender(){
        modalPage
                .getUserGenderFromMW();
    }

    @Test
    public void checkUserPhone(){
        modalPage
                .getUserPhoneFromMW();
    }

    @Test
    public void checkUserDob(){
        modalPage
                .getUserDoBFromMW();
    }

    @Test()
    public void checkUserSubjects(){
        modalPage
                .getUserSubjectsFromMW();
    }

    @Test
    public void checkPicture(){
        modalPage
                .getUserPictureFromMW();
    }

    @Test
    public void checkUserAddress(){
        modalPage
                .getAddressFromMW();
    }

    @Test
    public void checkUserStateCity(){
        modalPage
                .getStateCityFromMW();
    }
}
