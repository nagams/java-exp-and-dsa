package com.dipendit.phonebook;

import java.util.*;

public class TransferContacts {
    public static void main(String[] args) {
        PhoneBook oldBook = new PhoneBook();
        oldBook.addContact("Jon", "1231231234");
        oldBook.addContact("Dan", "4564564567");
        System.out.println(oldBook);

        PhoneBook newBook = new PhoneBook();
        newBook.addContact("Jon", "0231231234");
        newBook.addContact("John", "4564564567");
        System.out.println(newBook.getContacts());

        //Transfer missing contacts from old to new
        for (Map.Entry<String, String> contact : oldBook.getContacts().entrySet()) {
            if ( !newBook.hasContact(contact.getKey()) ) {
                newBook.addContact(contact.getKey(), contact.getValue());
            }
        }
        System.out.println(newBook.getContacts());


        PhoneBookTwo oldBook2 = new PhoneBookTwo();
        oldBook2.addContact("Jon", "1231231234");
        oldBook2.addContact("Dan", "4564564567");
        oldBook2.addContact("Dan", "4464564567");
        System.out.println(oldBook2.getContacts());

        PhoneBookTwo newBook2 = new PhoneBookTwo();
        newBook2.addContact("Jon", "0231231234");
        newBook2.addContact("John", "4564564567");
        System.out.println(newBook2.getContacts());

        for (Map.Entry<String, List<String>> contact : oldBook2.getContacts().entrySet()) {
            if ( !newBook2.hasContact(contact.getKey()) ) {
                newBook2.addContacts(contact.getKey(), contact.getValue());
            }
        }
        System.out.println(newBook2.getContacts());

    }
}

class PhoneBookTwo {
    Map<String, List<String>> contacts;

    public PhoneBookTwo() {
        contacts = new HashMap<>();
    }

    public Map<String, List<String>> getContacts() {
        return contacts;
    }

    public void addContact(String name, String phone) {
        contacts.computeIfAbsent(name, v -> new ArrayList<>()).add(phone);
    }

    public void addContacts(String name, List<String> phoneNumbers) {
        contacts.computeIfAbsent(name, v -> new ArrayList<>()).addAll(phoneNumbers);
    }

    public List<String> getPhoneNumbers(String name) {
        return contacts.getOrDefault(name, Collections.emptyList());
    }

    public boolean hasContact(String name) {
        return contacts.containsKey(name);
    }
}

class PhoneBook {
    Map<String, String> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public Map<String, String> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, String> contacts) {
        this.contacts = contacts;
    }

    public void addContact(String name, String phone) {
        contacts.put(name, phone);
    }

    public boolean hasContact(String name) {
        return contacts.containsKey(name);
    }
}
