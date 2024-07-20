package tests;

import base.BaseTest;
import configuration.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;



class TestRunner extends BaseTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
        WebDriver driver = WebDriverManager.getDriver();
    }

    @Test
    void runTest() {
        BaseTest baseTest = new BaseTest();
        baseTest.open("https://www.google.com/");


        googleSearchPage("гладиолус");


        System.out.println("Текущая страница: " + getPageTitle());
    }

}


