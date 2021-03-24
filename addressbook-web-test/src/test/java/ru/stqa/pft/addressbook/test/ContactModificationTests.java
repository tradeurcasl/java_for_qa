package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;


public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Liza", "Cozzy", "nozzy", "Jns", "Peterburg", "335999", "8923294455","gmail@gmail.com", "ssstr.ru", "26", "January", "1994", "-", "Test1","hi!"));
        }
        app.getNavigationHelper().returnToHomePage();
        app.getContactHelper().editContact();
        app.getContactHelper().fillAllInformation(new ContactData("111!", "www","83838","737277273", "_", "-","83838","737277273", "_", "-","83838","737277273", "_", "-", "kkk"), true);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToHomePage();
        int after = app.getContactHelper().getContactCount();
        if (before == 0) {
            Assert.assertEquals(after, before + 1);
        } else {
            Assert.assertEquals(after, before );
        }

    }
}