/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ContactList {

    private ArrayList<Contact> contactList = new ArrayList<>();

    public ContactList() {
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    public void removeContact(Contact contact) {
        contactList.remove(contact);
    }

    public Contact getContactById(int id) {
        for (Contact contact : contactList) {
            if (contact.getContactId() == id) {
                return contact;
            }
        }
        return null;
    }
}
