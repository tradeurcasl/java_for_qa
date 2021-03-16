package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().editContact();
        app.getContactHelper().fillAllInformation(new ContactData("111!", "www","83838","737277273", "_", "-","83838","737277273", "_", "-","83838","737277273", "_", "-", "83838","737277273", "_", "-", "83838","737277273", "_", "-"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();

    }
}