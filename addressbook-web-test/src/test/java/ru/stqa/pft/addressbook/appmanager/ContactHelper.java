package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Contacts;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;



public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillAllInformation(ContactData contactData, boolean creation) {
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
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
        attach(By.name("photo"), contactData.getPhoto());

        if (creation) {
            if (contactData.getGroups().size() > 0) {
                Assert.assertTrue(contactData.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group")))
                        .selectByVisibleText(contactData.getGroups().iterator().next().getName());}}
        else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

        type(By.name("notes"), contactData.getNotes());
    }

    public void initContactCreation() {
        if (isElementPresent(By.name("submit"))){
            return;
        }
        click(By.linkText("add new"));
    }


    public void selectContact(int index) {
        wd.findElements(By.xpath("(//input[@name='selected[]'])")).get(index).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();}

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void closeAlert() {
        wd.switchTo().alert().accept();
    }

    public void editContact(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void create(ContactData contact, boolean creation ) {
        initContactCreation();
        fillAllInformation(contact, true);
        submitContactCreation();
        contactCache = null;
    }

    public void modify(ContactData contact) {
        editContactById(contact.getId());
        fillAllInformation(contact, true);
        submitContactModification();
        returnToHomePage();
    }

    public void editContactById(int id) {
        wd.findElement(By.xpath("//a[@href='edit.php?id=" + id +"']")).click();
    }

    public void delete(int index) {
        selectContact(index);
        deleteContact();
        closeAlert();
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteContact();
        closeAlert();
        contactCache = null;
        returnToHomePage();
    }

    public boolean isThereAContact()
    {
        return isElementPresent(By.xpath("(//input[@name='selected[]'])"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> rows = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return contacts;

}

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null){
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String address = cells.get(3).getText();
            String allPhones = cells.get(5).getText();
            String allEmails = cells.get(4).getText();
            String addresses = cells.get(3).getText();
            contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withAddress(address).withAllPhones(allPhones).withAllEmails(allEmails));
        }

        return new Contacts(contactCache);
    }

    public void returnToHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public ContactData infoFromEditForm(ContactData contact) {
        editContactById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(contact.getFirstname()).withLastname(contact.getLastname())
                .withHomenumber(contact.getHomenumber()).withMobile(contact.getMobile()).withAddress(contact.getAddress())
                .withHomenumber(home).withMobile(mobile).withEmail(email).withEmail2(email2).withEmail3(email3);
    }

    public void selectGroup(Contacts contactData) {
        if (contactData.iterator().next().getGroups().size() > 1) {
            Assert.assertTrue(contactData.iterator().next().getGroups().size() == 1);
            new Select(wd.findElement(By.name("group"))).selectByVisibleText(contactData.iterator().next().getGroups().iterator().next().getName());
        }
    }

    public void selectGroup(GroupData group) {
        wd.findElement(By.xpath(String.format("//select[@name='to_group']/option[@value='%s']", group.getId()))).click();
    }

    public void selectContactWithoutGroup(ContactData contact) {
        new Select(wd.findElement(By.name("group"))).selectByVisibleText("[none]");
        click(By.xpath(String.format("//input[@type='checkbox']", contact.getId())));
    }

    public void selectContact(ContactData contact) {
        click(By.xpath(String.format("//input[@type='checkbox']", contact.getId())));
    }

    public void removeContactFromGroup() {
        click(By.name("remove"));
        contactCache = null;
        returnToHomePage();
    }

    public void getGroupData(GroupData groupData) {
        click(By.xpath(String.format("//select[@name='group']/option[text() = '%s']", groupData.getName())));;
    }

    public void addContactToGroup() {
        click(By.name("add"));
        contactCache = null;
        returnToHomePage();
    }
}


