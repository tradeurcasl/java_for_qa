package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ContactPhoneTests extends TestBase{

    @Test
    public void testContactPhones(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }


    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomenumber(), contact.getMobile()).stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleaned).collect(Collectors.joining("\n"));}

        public static String cleaned (String phones){
        return Arrays.asList(contact.getHomenumber(), contact.getMobile()).stream().filter((s) -> (s) != null).filter((s) -> !(s).equals(""));
    }
}