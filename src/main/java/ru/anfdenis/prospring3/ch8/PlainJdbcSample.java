package ru.anfdenis.prospring3.ch8;

import ru.anfdenis.prospring3.ch8.dao.ContactDao;
import ru.anfdenis.prospring3.ch8.dao.plain.PlainContactDao;
import ru.anfdenis.prospring3.ch8.domain.Contact;

import java.util.List;

/**
 * Denis Anfertev
 * 26.03.13 17:49
 */
public class PlainJdbcSample {
    private static ContactDao contactDao = new PlainContactDao();

    public static void main(String[] args) {
        System.out.println("Listing initial contact data:");
        listAllContacts();
    }

    private static void listAllContacts() {
        List<Contact> contacts = contactDao.findAll();
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
