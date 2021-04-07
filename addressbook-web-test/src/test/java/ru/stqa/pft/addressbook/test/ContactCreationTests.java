package ru.stqa.pft.addressbook.test;

import java.io.*;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.DataProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.thoughtworks.xstream.XStream;
import java.util.stream.Collectors;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        File photo = new File("src/test/resources/pol.jpg");
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(ContactData.class);
            List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
            return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
            }}

    @Test (dataProvider = "validContacts")
    public void testCreationNewContact(ContactData contact) throws Exception {
        Contacts before = app.db().contacts();
        File photo = new File("src/test/resources/pol.jpg");
        app.contact().create(contact, true);
        app.goTo().homePage();
        MatcherAssert.assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.db().contacts();


        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
        verifyContactListInUI();
    }

    @Test(enabled = false)
    public void testBadCreationNewContact() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("Mary'").withLastname("Brown").withNickname("mar").withTitle("Jn").withAddress("Petrozavodsk").withHomenumber("335999").withMobile("8923294455").withEmail("dfdfn@gmail.com").withEmail2("new_second@mail.com").withHomepage("ssstr.ru").withBday("6").withBmonth("February").withByear("1990").withAday("-").withNotes("hi!");
        app.contact().create(contact, true);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }

    @Test(enabled = false)
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/pol.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}

