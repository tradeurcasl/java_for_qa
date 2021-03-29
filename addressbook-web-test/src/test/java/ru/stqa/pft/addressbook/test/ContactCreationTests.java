package ru.stqa.pft.addressbook.test;

import java.io.File;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.DataProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() {
        List<Object[]> list = new ArrayList<Object[]>();
        File photo = new File("src/test/resources/stru.jpg");
        list.add(new Object[]{new ContactData().withFirstname("Mary").withLastname("Brown").withNickname("mary").withPhoto(photo).withTitle("Jn").withAddress("Moscow, Green st. 15-87").withHomenumber("335999").withMobile("8923294455").withEmail("dfdfn@gmail.com").withEmail2("new_second@mail.com").withEmail3("new_3@mail.com").withHomepage("ssstr.ru").withBday("6").withBmonth("February").withByear("1990").withAday("-").withGroup("Test1").withNotes("hi!")});
        list.add(new Object[]{new ContactData().withFirstname("Kate").withLastname("Green").withNickname("kate").withPhoto(photo).withTitle("Jn").withAddress("Moscow, Green st. 15-87").withHomenumber("335999").withMobile("8923294455").withEmail("dfdfn@gmail.com").withEmail2("new_second@mail.com").withEmail3("new_3@mail.com").withHomepage("ssstr.ru").withBday("6").withBmonth("February").withByear("1990").withAday("-").withGroup("Test1").withNotes("hi!")});
        list.add(new Object[]{new ContactData().withFirstname("Bob").withLastname("Black").withNickname("bob").withPhoto(photo).withTitle("Jn").withAddress("Moscow, Green st. 15-87").withHomenumber("335999").withMobile("8923294455").withEmail("dfdfn@gmail.com").withEmail2("new_second@mail.com").withEmail3("new_3@mail.com").withHomepage("ssstr.ru").withBday("6").withBmonth("February").withByear("1990").withAday("-").withGroup("Test1").withNotes("hi!")});
        return list.iterator();
    }

    @Test (dataProvider = "validContacts")
    public void testCreationNewContact(ContactData contact) throws Exception {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/pol.jpg");
        app.contact().create(contact);
        app.goTo().homePage();
        MatcherAssert.assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();

        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test(enabled = false)
    public void testBadCreationNewContact() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("Mary'").withLastname("Brown").withNickname("mar").withTitle("Jn").withAddress("Petrozavodsk").withHomenumber("335999").withMobile("8923294455").withEmail("dfdfn@gmail.com").withEmail2("new_second@mail.com").withHomepage("ssstr.ru").withBday("6").withBmonth("February").withByear("1990").withAday("-").withGroup("Test1").withNotes("hi!");
        app.contact().create(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }

    @Test
    public void testCurrentDir() throws Exception {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/pol.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}

