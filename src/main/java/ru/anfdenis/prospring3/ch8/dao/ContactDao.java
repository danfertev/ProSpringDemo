package ru.anfdenis.prospring3.ch8.dao;

import ru.anfdenis.prospring3.ch8.domain.Contact;

import java.util.List;

/**
 * Denis Anfertev
 * 26.03.13 16:50
 */
public interface ContactDao {
    public List<Contact> findAll();

    public List<Contact> findByFirstName(String firstName);

    public void insert(Contact contact);

    public void update(Contact contact);

    public void delete(Long contactId);
}
