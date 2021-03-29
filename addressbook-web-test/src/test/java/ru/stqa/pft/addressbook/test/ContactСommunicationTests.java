package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactСommunicationTests extends TestBase{

    @Test
    public void testContactPhones(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    @Test
    public void testContactEmails(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }

    @Test
    public void testContactAddress(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }


    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomenumber(), contact.getMobile()).stream().filter((s) -> (s) != null).filter((s) -> !(s).equals(""))
                .map(ContactСommunicationTests::cleaned).collect(Collectors.joining("\n"));

    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(),contact.getEmail3()).stream().filter((s) -> (s) != null).filter((s) -> !(s).equals(""))
                .map(ContactСommunicationTests::cleaned).collect(Collectors.joining("\n"));

    }

    public static String cleaned (String phones){
        return phones.replaceAll("\\s","").replaceAll("[-()]]","");
    }
}