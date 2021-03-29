package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testCreationNewContact() throws Exception {
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("Marina").withLastname("Galevih").withNickname("mar").withTitle("Jn").withAddress("Seversk").withHomenumber("335999").withMobile("8923299455").withEmail("dfdfn@gmail.com").withHomepage("ssstr.ru").withBday("6").withBmonth("February").withByear("1990").withAday("-").withGroup("Test1").withNotes("hi!");
        app.contact().create(contact);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(after, before);
    }
}

