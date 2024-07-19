package tests;

import base.BaseTest;
import configuration.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.GooglePage;



public class TestRunner extends BaseTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        super.setUp();
        driver = WebDriverManager.getDriver();
    }
    @org.junit.Test
    public void runTest() {
        GooglePage googlePage = new GooglePage(driver);
        googlePage.open("https://www.google.com");


        googleSearchPage("гладиолус");


        System.out.println("Текущая страница: " + getPageTitle());
    }

    @After
    public void tearDown() {
        super.tearDown();
    }
}


