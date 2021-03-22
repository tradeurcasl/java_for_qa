package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;

public class ContactDeletingTests extends TestBase {

    @Test
    public void testContactDeleting() {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().closeAlert();
        app.getContactHelper().returnToHomePage();

    }
}