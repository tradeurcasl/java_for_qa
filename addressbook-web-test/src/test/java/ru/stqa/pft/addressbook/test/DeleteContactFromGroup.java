package ru.stqa.pft.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static org.testng.Assert.assertTrue;


public class DeleteContactFromGroup extends TestBase {

    @BeforeMethod
    public void ensurePreconditionsSorted() {
        app.goTo().homePage();
        
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withFirstname("pol").withLastname("tok"), true);
            app.goTo().homePage();
        }

        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test 0"));
            app.goTo().homePage();
        }

        if (app.db().contactWithGroups().size() == 0) {
            ContactData before = app.db().contactWithoutGroup();
            Groups groups = app.db().groups();
            GroupData group = groups.iterator().next();
            app.goTo().homePage();
            app.contact().selectContactWithoutGroup(before);
            app.contact().selectGroup(group);
            app.contact().addContactToGroup();
        }
    }

    @Test
    public void testDeleteContactFromTheGroup() {
        ContactData before = app.db().contactWithGroup();
        GroupData group = before.getGroups().iterator().next();
        app.goTo().homePage();
        app.contact().getGroupData(group);
        app.contact().selectContact(before);
        app.contact().removeContactFromGroup();
        ContactData after = app.db().contactById(before.getId());
        assertTrue(after.getGroups().contains(group));
        verifyContactListInUI();
    }
}