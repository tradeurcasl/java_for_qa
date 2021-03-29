package ru.stqa.pft.addressbook.generators;


import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<ContactData> contacts = generateContacts(count);
        save(contacts, file);
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts){
            writer.write(String.format("%s;%s;%s\n", contact.getLastname(), contact.getFirstname(), contact.getAddress()));
        }
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData>contacts = new ArrayList<ContactData>();
        for (int i = 0; i <count; i++){
            contacts.add(new ContactData().withLastname(String.format("lastname %s", i)).withFirstname(String.format("firstname %s", i)).withAddress(String.format("address %s", i)));
        }
        return contacts;
    }
}
