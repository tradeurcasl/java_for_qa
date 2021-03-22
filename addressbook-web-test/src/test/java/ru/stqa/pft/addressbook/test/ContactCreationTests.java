package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testCreationNewContact() throws Exception {
        app.getContactHelper().createContact(new ContactData("Liza", "Cozzy", "nozzy", "Jns", "Peterburg", "335999", "8923294455","gmail@gmail.com", "ssstr.ru", "26", "January", "1994", "-", "Test1","hi!"));
        app.getContactHelper().returnToHomePage();
    }
}

