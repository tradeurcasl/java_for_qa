package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactDeletingTests extends TestBase {

    @Test
    public void testContactDeleting() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Liza", "Cozzy", "nozzy", "Jns", "Peterburg", "335999", "8923294455","gmail@gmail.com", "ssstr.ru", "26", "January", "1994", "-", "Test1","hi!"));
        }
        app.getNavigationHelper().returnToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().closeAlert();
        app.getContactHelper().returnToHomePage();

    }
}