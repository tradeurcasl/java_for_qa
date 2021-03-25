package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import java.util.List;
import java.util.Comparator;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Liza", "Cozzy", "nozzy", "Jns", "Peterburg", "335999", "8923294455","gmail@gmail.com", "ssstr.ru", "26", "January", "1994", "-", "Test1","hi!"));
        }
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().returnToHomePage();
        app.getContactHelper().editContact(before.size()-1);
        ContactData contact = new ContactData(before.get(before.size()-1).getId(),"111!", "www","83838","737277273", "_", "-","83838","737277273", "_", "-","83838","737277273", "_", "-", "kkk");
        app.getContactHelper().fillAllInformation(contact, false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size()-1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }
}