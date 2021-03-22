package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testCreationNewContact() throws Exception {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillAllInformation(new ContactData("Pie", "Green", "purple", "Jn", "SPb", "335999", "890294455","h@gmail.com", "sss222tr.ru", "26", "January", "1994", "-", "Te1","hi!"), true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }
}

