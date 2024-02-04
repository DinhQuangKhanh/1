/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Contact;
import model.ContactList;
import view.Menu;

/**
 *
 * @author ADMIN
 */
public class Programming extends Menu {

    private Validation valid = new Validation();
    private ContactList cList = new ContactList();

    public Programming(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addContact(cList);
                break;
            case 2:
                displayAllContact(cList);
                break;
            case 3:
                deleteContact(cList);
                break;
            case 4:
                System.exit(0);
        }
    }

    public void addContact(ContactList clist) {
        int contactId = 0;
        System.out.println("-------- Add a Contact --------");
        contactId += 1;
        System.out.print("Enter full name: ");
        String fullName = valid.checkInputString();

        String[] nameParts = fullName.split("\\s+", 2);
        String firstName = nameParts[0];
        String lastName = (nameParts.length > 1) ? nameParts[1] : "";

        System.out.print("Enter group: ");
        String group = valid.checkInputString();
        System.out.print("Enter address: ");
        String address = valid.checkInputString();
        System.out.print("Enter phone: ");
        String phone = valid.checkInputPhone();

        clist.addContact(new Contact(contactId, fullName, firstName, lastName, group, address, phone));
        System.err.println("Add successful.");
    }

    public void displayAllContact(ContactList clist) {
        System.out.println("--------------------------------- Display all Contact ----------------------------");
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        for (Contact contact : clist.getContactList()) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getContactId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }

    public void deleteContact(ContactList clist) {
        System.out.println("------- Delete a Contact -------");
        System.out.print("Enter id: ");
        int idDelete = valid.checkInputInt();
        Contact contactDelete = clist.getContactById(idDelete);
        if (contactDelete == null) {
            System.err.println("Not found contact.");
            return;
        } else {
            clist.removeContact(contactDelete);
        }
        System.err.println("Delete successful.");
    }
}
