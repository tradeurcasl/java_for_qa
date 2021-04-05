package ru.stqa.pft.addressbook.test;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactGroupTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            app.contact().initContactCreation();
            app.contact().create(new ContactData()
                    .withFirstname("TestName")
                    .withLastname("Lastname")
                    .withEmail("test@ya.ru")
                    .withHomenumber("89873")
                    .withAddress("Lenina st 12"));
            app.goTo().homePage();
        }
        if (app.db().groups().size() == 0) {
            app.group().create(new GroupData()
                    .withName("test11")
                    .withFooter("testgroup"));
        }
        Contacts contacts = app.db().contacts();
        if(contacts.stream().iterator().next().getGroups().size() == 0) {
            app.contact().selectContactById(contacts.iterator().next().getId());
            app.contact().selectGroup(contacts);
            app.contact().addContactToGroup();
            app.goTo().homePage();
        }
    }

    @Test
    public void testContactAddToGroup() throws Exception{
        Contacts before = app.db().contacts();
        app.goTo().homePage();
        app.contact().selectContactById(before.iterator().next().getId());
        app.contact().addContactToGroup();
        Contacts after = app.db().contacts();
        assertThat(before.iterator().next(), equalTo(after.iterator().next()));
        verifyContactListInUI();
    }

    @Test
    public void testContactRemoveFromGroup() throws Exception{
        Contacts before = app.db().contacts();
        app.goTo().homePage();
        app.contact().selectGroup(before);
        app.contact().removeContactFromGroup();
        Contacts after = app.db().contacts();
        assertThat(before.iterator().next(), equalTo(after.iterator().next()));
        verifyContactListInUI();
    }
}