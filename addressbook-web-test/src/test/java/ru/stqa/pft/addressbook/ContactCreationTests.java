package ru.stqa.pft.addressbook;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactCreationTests {
    private WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "/Users/PTokareva/Documents/chromedriver_win32/chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/edit.php");
        login("admin", "secret");
    }
    private void login(String username, String password) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void testCreationNewContact() throws Exception {
        initContactCreation();
        fillBaseInformation(new ContactData("Polly", "-", "Carris", "Louis", "Jn", "Valamis", "Seversk"));
        fillPhones(new PhonesData("990009", "89110000000", "8889999", "881111"));
        fillOtherInformation(new SecondaryData("gmail@gmail.com", "-", "-", "-", "5", "December", "1980", "-", "-", "-", "hi!"));
        submitContactCreation();
        returnToHomePage();
    }

    private void returnToHomePage() {
        wd.findElement(By.linkText("home")).click();
    }

    private void submitContactCreation() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    private void fillOtherInformation(SecondaryData secondaryData) {
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(secondaryData.getEmail());
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(secondaryData.getEmail2());
        wd.findElement(By.name("email3")).clear();
        wd.findElement(By.name("email3")).sendKeys(secondaryData.getEmail3());
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys(secondaryData.getHomepage());
        wd.findElement(By.name("bday")).click();
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(secondaryData.getBday());
        wd.findElement(By.name("bmonth")).click();
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(secondaryData.getBmonth());
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(secondaryData.getByear());
        wd.findElement(By.name("aday")).click();
        new Select(wd.findElement(By.name("aday"))).selectByVisibleText(secondaryData.getAday());
        wd.findElement(By.name("new_group")).click();
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(secondaryData.getAddress2());
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(secondaryData.getPhone2());
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(secondaryData.getNotes());
    }

    private void fillPhones(PhonesData phonesData) {
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(phonesData.getHomenumber());
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(phonesData.getMobile());
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(phonesData.getWorknumber());
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys(phonesData.getFax());
    }

    private void fillBaseInformation(ContactData contactData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    }

    private void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}
