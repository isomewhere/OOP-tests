package tests;

import base.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;
import pages.GooglePage;

public class TestRunner extends BaseTest {

    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
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


