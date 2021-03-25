package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import java.util.List;
import java.util.Comparator;
import org.testng.annotations.BeforeMethod;


public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.contact().list().size() ==0) {
            app.contact().create(new ContactData("Liza", "Cozzy", "nozzy", "Jns", "Peterburg", "335999", "8923294455","gmail@gmail.com", "ssstr.ru", "26", "January", "1994", "-", "Test1","hi!"));
        }
    }

    @Test
    public void testContactModification() {
        app.goTo().homePage();
        List<ContactData> before = app.contact().list();
        int index = before.size()-1;
        ContactData contact = new ContactData(before.get(index).getId(),"Liza", "Cozzy", "nozzy", "Jns", "Peterburg", "335999", "8923294455","gmail@gmail.com", "ssstr.ru", "26", "January", "1994", "-", "Test1","hi!");
        app.contact().modify(index, contact);

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        app.contact().modify(index, contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after, before);

        before.remove(index);

}
}