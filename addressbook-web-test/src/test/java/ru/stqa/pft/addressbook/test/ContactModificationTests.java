package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().editContact();
        app.getContactHelper().fillAllInformation(new ContactData("111!", "www","83838","737277273", "_", "-","83838","737277273", "_", "-","83838","737277273", "_", "-", "kkk"), true);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();

    }
}