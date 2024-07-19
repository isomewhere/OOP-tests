package base;

import configuration.WebDriverManager;


    public class BaseTest {
        protected WebDriverManager webDriverManager;

        public BaseTest() {
            webDriverManager = new WebDriverManager();
        }

        public void setUp() {
            webDriverManager.startBrowser();
        }

        public void tearDown() {
            webDriverManager.closeBrowser();
        }
    }

