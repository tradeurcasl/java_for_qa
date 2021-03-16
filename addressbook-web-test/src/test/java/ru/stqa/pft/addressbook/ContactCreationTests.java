package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testCreationNewContact() throws Exception {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillAllInformation(new ContactData("Polly", "-", "Carris", "Louis", "Jn", "Valamis", "Seversk", "990009", "89110000000", "8889999", "881111", "gmail@gmail.com", "-", "-", "-", "5", "December", "1980", "-", "-", "-", "hi!"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }
}