import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaLoginTest {

    private WebDriver driver;

    @BeforeTest
    public void LaunchUrl() throws InterruptedException {
        //Locate the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //Open the browser
        driver = new ChromeDriver();
        //Input the Konga Url
        driver.get("https://www.konga.com/");
        Thread.sleep(4000);
        //Test 1: Verify the Url
        String expectedUrl = "https://www.konga.com/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("Current Url is:" + expectedUrl);
        else
            System.out.println("Wrong Url");
        //Maximize the page
        driver.manage().window().maximize();
        Thread.sleep(2000);

    }

    public class testMe {
        @Test(priority = 0)
        public void GetPageTitle() throws InterruptedException {
            //Test 2 Verify page title
            // Get page title
            System.out.println("Page Title is:" + driver.getTitle());
            Thread.sleep(2000);
        }


        @Test(priority = 1)
        public void LoginWithEmail() throws InterruptedException {
            //Test 3 Verify that user can Login successfully with valid email and password
            //Click on Login/SignUp
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
            Thread.sleep(2000);
            //Input valid email address in the email field
            driver.findElement(By.id("username")).sendKeys("valid email");
            //Input valid password
            driver.findElement(By.id("password")).sendKeys("valid password");
            //Click login
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            //Test 4 Verify successful login message
            String expectedMsg = "Login Successful";
            String actualMsg = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[1]")).getText();
            if (expectedMsg.contains(actualMsg))
                System.out.println("Login is Successful");
            else
                System.out.println("Test Case Failed");
            Thread.sleep(4000);

        }

        @Test(priority = 2)
        public void LogoutFunctionality() throws InterruptedException {
            //Test 5 Verify user can logout successfully
            // Click on My Account
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a")).click();
            Thread.sleep(3000);
            //Click logout
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();


            //Test 6 Confirm successful logout message
            String expectedMsg = "You have successfully logged out";
            String actualMsg = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[1]/div/div[1]/p")).getText();
            if (expectedMsg.contains(actualMsg))
                System.out.println("Logout is Successful");
            else
                System.out.println("Test case failed");
            Thread.sleep(4000);
        }

        @Test(priority = 3)
        public void InvalidEmail() throws InterruptedException {
            //Test 7 Verify that user cannot login with an invalid email
            //Click on Login/SignUp
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
            Thread.sleep(3000);
            //Clear email field
            driver.findElement(By.id("username")).clear();
            //Clear password field
            driver.findElement(By.id("password")).clear();
            Thread.sleep(3000);
            //Input an invalid email address in the email field
            driver.findElement(By.id("username")).sendKeys("invalid email");
            //Input valid password
            driver.findElement(By.id("password")).sendKeys("valid password");
            //Click login
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
           Thread.sleep(2000);


            String expectedErrorMsg = "The username or password you have entered is incorrect. Please try again.";
            String actualMsg = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[1]/div")).getText();
            if (actualMsg.equals(expectedErrorMsg))
                System.out.println("Incorrect username or password:" + "Test Case Passed");
            else
                System.out.println("Test Case Failed");
            Thread.sleep(4000);

        }

        @Test(priority = 4)
        public void InvalidPassword() throws InterruptedException {
            //Test 8 Verify that user cannot login with an invalid password
            //Clear email field
            driver.findElement(By.id("username")).clear();
            //Clear password field
            driver.findElement(By.id("password")).clear();
            Thread.sleep(3000);
            //Input valid email address in the email field
            driver.findElement(By.id("username")).sendKeys("your email");
            //Input an invalid password
            driver.findElement(By.id("password")).sendKeys("invalid password");
            //Click login
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(2000);


            String expectedErrorMsg = "The username or password you have entered is incorrect. Please try again.";
            String actualMsg = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[1]/div")).getText();
            if (actualMsg.equals(expectedErrorMsg))
                System.out.println("Incorrect username or password:" + "Test Case Passed");
            else
                System.out.println("Test Case Failed");
            Thread.sleep(4000);

        }

        @Test(priority = 5)
        public void InvalidDetails() throws InterruptedException {
            //Test 9 Verify that user cannot login with an invalid email and an invalid password
            //Clear email field
            driver.findElement(By.id("username")).clear();
            //Clear password field
            driver.findElement(By.id("password")).clear();
            Thread.sleep(3000);
            //Input valid email address in the email field
            driver.findElement(By.id("username")).sendKeys("invalid email");
            //Input an invalid password
            driver.findElement(By.id("password")).sendKeys("invalid password");
            //Click login
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(2000);


            String expectedErrorMsg = "The username or password you have entered is incorrect. Please try again.";
            String actualMsg = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[1]/div")).getText();
            if (actualMsg.equals(expectedErrorMsg))
                System.out.println("Incorrect username or password:" + "Test Case Passed");
            else
                System.out.println("Test Case Failed");
            Thread.sleep(4000);
        }

        @Test(priority = 6)
        public void EmptyFields() throws InterruptedException {
            //Test 10 Verify that user cannot login leaving email and password fields blank
            //Clear email field
            driver.findElement(By.id("username")).clear();
            //Clear password field
            driver.findElement(By.id("password")).clear();
            Thread.sleep(3000);
            //Leave email field blank
            driver.findElement(By.id("username")).sendKeys("");
            //Leave password field blank
            driver.findElement(By.id("password")).sendKeys("");
            //Click login
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(4000);
        }

        @Test(priority = 7)
        public void LoginWithPhoneNumber() throws InterruptedException {
            //Test 11 Verify that user can alternatively Login successfully with valid phone number and password
            //Input valid email address in the email field
            driver.findElement(By.id("username")).sendKeys("your number");
            //Input valid password
            driver.findElement(By.id("password")).sendKeys("your password");
            //Click login
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();


            // Verify successful login message
            String expectedMsg = "Login Successful";
            String actualMsg = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[1]")).getText();
            if (expectedMsg.contains(actualMsg))
                System.out.println("Login is Successful");
            else
                System.out.println("Test Case Failed");
            Thread.sleep(5000);
        }

        @Test(priority = 8)
        public void ShowPassword() throws InterruptedException {
            //Test 12 Verify user can show password text
            // Click on My Account
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a")).click();
            Thread.sleep(3000);
            //Click logout
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
            Thread.sleep(2000);
            //Click on Login/SignUp
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
            Thread.sleep(3000);
            //Clear email field
            driver.findElement(By.id("username")).clear();
            //Click Show icon in the password field to view password
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[2]/a")).click();
            Thread.sleep(3000);


            //Test 13 Verify user can Hide password text
            //Click Show icon in the password field to hide password
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[2]/a")).click();
            Thread.sleep(3000);
        }

        @Test(priority = 9)
        public void ForgotPassword() throws InterruptedException {
            //Test 14 Verify forgot password link functionality
            //Click on forgot password?
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[2]/label/a")).click();
            //User should be taken to forgot password page
            Thread.sleep(2000);


            String expectedPageTitle = "Forgot Password | Konga Online Shopping";
            String actualPageTitle = driver.getTitle();
            if (actualPageTitle.contains(expectedPageTitle))
                System.out.println("Test Case Passed");
            else
                System.out.println("Test Case Failed");
            Thread.sleep(3000);
        }

        @Test(priority = 10)
        public void LoginWithFacebook() throws InterruptedException {
            //Test 15 Verify login with Facebook link functionality
            //Click on Konga logo to go back to homepage
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/a/img")).click();
            Thread.sleep(2000);
            //Click on Login/SignUp
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
            //Click on Login with Facebook Link
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/div[2]/a[1]")).click();
            //User should be taken to facebook login page
            Thread.sleep(2000);


            String expectedPageTitle = "Log in to Facebook | Facebook";
            String actualPageTitle = driver.getTitle();
            if (actualPageTitle.contains(expectedPageTitle))
                System.out.println("Test Case Passed");
            else
                System.out.println("Test Case Failed");
            Thread.sleep(3000);
        }

        @Test(priority = 11)
        public void SignupLink() throws InterruptedException {
            //Test 16 Verify the signup link functionality
            //Exit facebook login page
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[2]/a/span")).click();
            Thread.sleep(3000);
            //Click on Konga logo to go back to homepage
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/a/img")).click();
            Thread.sleep(2000);
            //Click on Login/SignUp
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
            Thread.sleep(2000);
            //Click on Don't have an account? Signup
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[3]/div/a")).click();
            Thread.sleep(2000);


            //User should be taken to Signup page
            String expectedPageTitle = "Signup | Konga Online Shopping";
            String actualPageTitle = driver.getTitle();
            if (actualPageTitle.contains(expectedPageTitle))
                System.out.println("Test Case Passed");
            else
                System.out.println("Test Case Failed");
            Thread.sleep(2000);

            //Exit signup page
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/a/img")).click();
        }

        @AfterTest
        public void Quit() {
            //quit the browser
            driver.quit();
        }
    }
}
