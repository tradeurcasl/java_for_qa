package ru.stqa.pft.addressbook.test;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

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
    public void testContactAddToGroup(){
        ContactData contactData = app.db().contactNotInGroup();
        app.contact().selectContactNotGroup(contactData);
        Groups groups = app.db().groups();
        GroupData group = groups.iterator().next();
        app.contact().selectGroup(group);
        app.contact().addContactToGroup();
        ContactData contactAfter = app.db().contactById(contactData.getId());
        AssertJUnit.assertTrue(contactAfter.getGroups().contains(group));
    }

    @Test
    public void testContactRemoveFromGroup() {
        ContactData contactData = app.db().contactInGroup();
        GroupData groupData = contactData.getGroups().iterator().next();
        app.contact().getGroupData(groupData);
        app.contact().selectContactNotInGroup(contactData);
        app.contact().removeContactFromGroup();
        app.goTo().homePage();
        ContactData contactAfter = app.db().contactById(contactData.getId());
        AssertJUnit.assertTrue(contactAfter.getGroups().contains(groupData));
    }
}