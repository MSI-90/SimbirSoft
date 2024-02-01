package tests.base;

import common.CommonAction;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import pages.base.BasePage;
import pages.demoqaPracticForm.DemoPracticFormPage;
import pages.modalWindow.ModalWindowPage;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected DemoPracticFormPage demoForm = new DemoPracticFormPage(driver);
    protected ModalWindowPage modalPage = new ModalWindowPage(driver);

    @AfterSuite(alwaysRun = true)
    public void quite (){
        driver.quit();
    }
}
