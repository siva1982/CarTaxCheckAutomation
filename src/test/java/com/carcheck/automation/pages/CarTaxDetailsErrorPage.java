package com.carcheck.automation.pages;

import com.carcheck.automation.util.ElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarTaxDetailsErrorPage extends Page {

    private ElementHelper elementHelper;

    @FindBy(xpath = "///*[@id='m']/div[2]/div/div/div/div/form/p")
    private WebElement invalidRegistrationErrorMessage;

    public CarTaxDetailsErrorPage(WebDriver driver) {
        super(driver);
        elementHelper = new ElementHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isErrorDisplayed() {
        elementHelper.waitUntilVisibilityOf(invalidRegistrationErrorMessage);
        return invalidRegistrationErrorMessage.isDisplayed();
    }

}
