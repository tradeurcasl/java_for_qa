package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;



public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void submitContactCreation() { click(By.name("submit"));
    }

    public void fillAllInformation(ContactData contactData, boolean creation) {
        type(By.name("email"), contactData.getEmail());
        type(By.name("homepage"), contactData.getHomepage());

        select(By.name("bday"), contactData.getBday());
        select(By.name("bmonth"), contactData.getBmonth());

        type(By.name("byear"), contactData.getByear());
        select(By.name("aday"), contactData.getAday());

        click(By.name("new_group"));
        type(By.name("notes"), contactData.getNotes());
        type(By.name("home"), contactData.getHomenumber());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("address"), contactData.getAddress());
        if (creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

        type(By.name("notes"), contactData.getNotes());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }


    public void selectContact(int index) {
        wd.findElements(By.xpath("(//input[@name='selected[]'])")).get(index).click();
//        click(By.xpath("(//input[@name='selected[]'])"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void closeAlert() {
        wd.switchTo().alert().accept();
    }

    public void editContact(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
//        click(By.xpath("//img[@alt='Edit']"));
}

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillAllInformation(contact, true);
        submitContactCreation();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("(//input[@name='selected[]'])"));
    }
    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> rows = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String firstname = cells.get(1).getText();
            String lastname = cells.get(2).getText();
            ContactData contact = new ContactData(firstname, lastname,null, null,null,null,null,null,null,null,null,null,null,null,null);
            contacts.add(contact);
        }
        return contacts;

}}

