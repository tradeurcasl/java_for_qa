package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletingTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstname("Mary").withLastname("Brown").withNickname("mar").withTitle("Jn").withAddress("Petrozavodsk").withHomenumber("335999").withMobile("8923294455").withEmail("dfdfn@gmail.com")
                    .withEmail2("nfg@hf.ci").withEmail3("nfg@hf.ci").withHomepage("ssstr.ru").withBday("6").withBmonth("February").withByear("1990").withAday("-").withNotes("hi!"), true);
        }
    }

    @Test
    public void testContactDeleting() {
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.goTo().homePage();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.db().contacts();

        assertThat(after, equalTo(before.without(deletedContact)));
        verifyContactListInUI();

    }
}