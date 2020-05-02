package Order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class OrderTests {

    private WebDriver driver;
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://www.konga.com/");

        Thread.sleep(5000);

        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Click on Login and enter Login details
        driver.findElement(By.linkText("Login / Signup")).click();

        driver.findElement(By.id("username")).sendKeys("adewuyi.adekunle@gmail.com");

        driver.findElement(By.id("password")).sendKeys("arikemi1");

        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();

  //Wait and pause period
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


//Search for an item
        driver.findElement(By.xpath("(//input[@id='jsSearchInput'])[2]")).sendKeys("samsung a20");

        Thread.sleep(2000);


//click on the search button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(2000);


//Click item to add to cart
        try {
            WebElement addToCart =  driver.findElement(By.cssSelector("main#mainContent>section:nth-of-type(2)>section>section>section>section>ul>li:nth-of-type(3)>div>div>div:nth-of-type(2)>form>div:nth-of-type(4)>button"));
            addToCart.click();
            //b49ee_2pjyI
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            System.out.println("element becomes state");
            WebElement addToCart =  driver.findElement(By.cssSelector("main#mainContent>section:nth-of-type(2)>section>section>section>section>ul>li:nth-of-type(3)>div>div>div:nth-of-type(2)>form>div:nth-of-type(4)>button"));
            addToCart.click();
        }
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Click on My Cart Menu to view Cart Overview

        driver.findElement(By.xpath("(//span[text()='My Cart'])[2]")).click();

        Thread.sleep(5000);

//Increase item number to 4
        System.out.println("get the cart increment button");

        driver.findElement(By.cssSelector("div#js-cart-items-wrapper>div>div>div:nth-of-type(2)>div>form>div>div>button:nth-of-type(2)")).click();
        driver.findElement(By.cssSelector("div#js-cart-items-wrapper>div>div>div:nth-of-type(2)>div>form>div>div>button:nth-of-type(2)")).click();
        driver.findElement(By.cssSelector("div#js-cart-items-wrapper>div>div>div:nth-of-type(2)>div>form>div>div>button:nth-of-type(2)")).click();

        Thread.sleep(5000);

//Click on check out
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("section#app-content-wrapper>div:nth-of-type(3)>section>section>aside>div:nth-of-type(3)>div>div:nth-of-type(2)>button")).click();

        Thread.sleep(5000);


//Select the Pay Now Option
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("main#mainContent>form>div>section>div>div:nth-of-type(4)>form>ul>li>div>button")).click();

        Thread.sleep(5000);

//click on continue to payment
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("main#mainContent>form>div>section>div>div:nth-of-type(8)>div>button")).click();


        Thread.sleep(5000);

//switch to the iframe element
        driver.switchTo().frame("kpg-frame-component");

        //select card payment
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//span[@class='payment-option-info'])[2]")).click();

        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


//Enter card details

        driver.findElement(By.id("card-number")).sendKeys("4444657071239899");

        driver.findElement(By.id("expiry")).sendKeys("01/23");

        driver.findElement(By.id("cvv")).sendKeys("656");

        driver.findElement(By.id("validateCardForm")).click();

        Thread.sleep(5000);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println(driver.findElement(By.xpath("//label[@id='card-number_unhappy']")).getText());



        }


    public static void main(String args[]) throws InterruptedException {
        OrderTests test = new OrderTests();
        test.setUp();






















    }







}
