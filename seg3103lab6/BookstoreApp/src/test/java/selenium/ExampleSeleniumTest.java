package selenium;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

class ExampleSeleniumTest {

  static Process server;
  private WebDriver driver;

  @BeforeAll
  public static void setUpBeforeClass() throws Exception {
    ProcessBuilder pb = new ProcessBuilder("java", "-jar", "bookstore5.jar");
    server = pb.start();
  }

  @BeforeEach
  void setUp() {
    // Pick your browser
    // driver = new FirefoxDriver();
    // driver = new SafariDriver();
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/");
    // wait to make sure Selenium is done loading the page
    WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
  }

  @AfterEach
  public void tearDown() {
    driver.close();
  }

  @AfterAll
  public static void tearDownAfterClass() throws Exception {
    server.destroy();
  }

  @Test
  void test1() {
    WebElement element = driver.findElement(By.id("title"));
    String expected = "YAMAZONE BookStore";
    String actual = element.getText();
    assertEquals(expected, actual);
  }

  @Test
  public void test2() {
    WebElement welcome = driver.findElement(By.cssSelector("p"));
    String expected = "Welcome";
    String actual = welcome.getText();
    assertEquals(expected, getWords(actual)[0]);
    WebElement langSelector = driver.findElement(By.id("locales"));
    langSelector.click();
    WebElement frSelector = driver.findElement(By.cssSelector("option:nth-child(3)"));
    frSelector.click();
    welcome = driver.findElement(By.cssSelector("p"));
    expected = "Bienvenu";
    actual = welcome.getText();
    assertEquals(expected, getWords(actual)[0]);
  }

  @Test
  public void test3() {
    // Testing search functionality
    WebElement searchButton = driver.findElement(By.id("searchBtn"));
    searchButton.click();
    String expected = "Core Servlets and JavaServer Pages 2nd Edition (Volume 1)	";
    WebElement elem = driver.findElement(By.id("title-hall001"));
    String actual = elem.getText();
    assertEquals(expected, actual);
  }

  @Test
  public void test4() {
    // Testing successfully adding a book
    driver.get("http://localhost:8080/admin");
    WebDriverWait wait = new WebDriverWait(driver, 60);
    driver.findElement(By.id("loginId")).sendKeys("admin");
    driver.findElement(By.id("loginPassword")).sendKeys("password");
    driver.findElement(By.id("loginBtn")).click();
    WebDriverWait wait = new WebDriverWait(driver, 60);
    driver.findElement(By.id("addBook-category")).sendKeys("sports");
    driver.findElement(By.id("addBook-title")).sendKeys("Fifa World Cup");
    driver.findElement(By.id("addBook-id")).sendKeys("142536");
    driver.findElement(By.id("addBook-authors")).sendKeys("Cristiano Ronaldo");
    driver.findElement(By.id("longDescription")).sendKeys("My journey in the 2018 world cup in Russia.");
    driver.findElement(By.id("cost")).sendKeys("20");
    driver.find_element_by_xpath("//*[@id="addBook-form"]/button").click();
    String expectedFeedback = "Successfully added book";
    String actualFeedback = driver.findElement(By.id("cost")).getText();
    assertEquals(expectedFeedback, actualFeedback);

  private String[] getWords(String s) {
    return s.split("\\s+");
  }
}