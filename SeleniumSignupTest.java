import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumSignupTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //Open the Chrome Browser
        driver = new ChromeDriver();
        //Input the Selenium blog url https://selenium-blog.herokuapp.com/
        driver.get("https://selenium-blog.herokuapp.com/");
        // test 1 Verify the Url
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            System.out.println("Correct Url");
        else
            System.out.println("Wrong URL");
        //make it wait
        Thread.sleep(3000);
        //Maximize the page
        driver.manage().window().maximize();
        //Click on the signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(3000);

    }

    public class TestMe {
        @Test(priority = 0)
        public void SignupDetails() throws InterruptedException {
            //test 2 - Verify user signups successfully with valid details
            //Input username in the username field
            driver.findElement(By.id("user_username")).sendKeys("malanh09");
            //Input an email in the email field
            driver.findElement(By.id("user_email")).sendKeys("ayaeyenew3u@YOPmail.com");
            //Input a password of choice
            driver.findElement(By.id("user_password")).sendKeys("sams675");
            //Click on the signup button
            driver.findElement(By.id("submit")).click();
            //Wait for success message
            Thread.sleep(3000);

        }

        @Test(priority = 1)
        public void Articles() throws InterruptedException {
            //test 3 Verify that user click on the articles icon and can view list of all articles
            //Click on Articles to view all articles
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
            String expectedUrl = "https://selenium-blog.herokuapp.com/articles";
            String actualUrl = driver.getCurrentUrl();
            if (actualUrl.contains(expectedUrl))
                System.out.println("Successful");
            else
                System.out.println("Wrong Url");
            Thread.sleep(5000);

        }

        @Test(priority = 2)
        public void LearnXPath() throws InterruptedException {
            //test 4 Verify that user can click on Learn XPath
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
            String expectedPageTitle = "Learn XPath";
            String actualPageTitle = driver.getTitle();
            if (actualPageTitle.contains(expectedPageTitle))
                System.out.println("Successful");
            else
                System.out.println("Wrong Page Title");
            Thread.sleep(2000);

        }

        @Test(priority = 3)
        public void Logout() throws InterruptedException {
            //test 5 Verify user logouts successfully
            // Click on logout
            driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a")).click();
            Thread.sleep(3000);

        }

        @Test(priority = 4)
        public void CannotSignup() throws InterruptedException {
            //test 6 Verify user cannot signup with password field blank
            //Click on the signup button to open the signup page
            driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
            Thread.sleep(3000);
            //Input username in the username field
            driver.findElement(By.id("user_username")).sendKeys("malakumo3");
            //Input an email in the email field
            driver.findElement(By.id("user_email")).sendKeys("ayaeyenew2@YOPmail.com");
            //Leave Password field blank
            driver.findElement(By.id("user_password")).sendKeys("");
            //Click on the signup button
            driver.findElement(By.id("submit")).click();
            //Signup show be unsuccessful
            Thread.sleep(2000);
        }

        @Test (priority = 5)
        public void NegativeTest () throws InterruptedException {
            //test 7 Verify that user cannot signup with email field blank
            //Clear username field
            driver.findElement(By.id("user_username")).clear();
            //Input username in the username field
            driver.findElement(By.id("user_username")).sendKeys("malakumo56");
            //Clear email field
            driver.findElement(By.id("user_email")).clear();
            // Leave email field blank
            driver.findElement(By.id("user_email")).sendKeys("");
            //Input a password text
            driver.findElement(By.id("user_password")).sendKeys("fullyuo9");
            //Click on the signup button
            driver.findElement(By.id("submit")).click();
            //Signup show be unsuccessful
            Thread.sleep(2000);

        }
        @AfterTest
        public void Quit () {
            //Quit the browser
            driver.quit();
        }


    }
}
