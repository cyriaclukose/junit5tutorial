package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author cyriac
 */
public class ContactManager {

    private Map<String, Contact> contactmap = new ConcurrentHashMap<String, Contact>();

    public void addContact(String fname, String lname, String phone) {
        Contact contact = new Contact(fname, lname, phone);
        validateContact(contact);
        String key = generateKey(fname, lname);
        contactAlreadyPresent(key);
        contactmap.put(key,contact);

    }

    List<Contact> getContactList(){
        return new ArrayList<>(contactmap.values());

    }

    /**
     *
     * @param key
     */
    private void contactAlreadyPresent(String key) {
        if(!contactmap.isEmpty() && contactmap.containsKey(key))
        {
            throw  new RuntimeException("contact Already exist");
        }
    }

    private void validateContact(Contact contact) {

        validateFirstName(contact.getFname());
        validateLastName(contact.getLname());
        validatePhone(contact.getContactNumber());
    }

    private void validatePhone(String contactNumber) {

        if(contactNumber.isBlank())
        {
            throw new RuntimeException ("contact number cannot be null");
        }
        if(contactNumber.length()!=10){
            throw new RuntimeException("contact number is not a 10 digit number");
        }
        if(!contactNumber.matches("\\d+")){
            throw new RuntimeException ("Contact number is not a digit");
        }
        if(contactNumber.startsWith("0")){
            throw  new RuntimeException("Invalid phone number starting with 0");
        }
    }

    private void validateFirstName(String fname) {

        if(fname.isBlank()){
            throw new RuntimeException("first name cannot be null");
        }
    }

    private void validateLastName(String lname) {

        if(lname.isBlank()){
            throw new RuntimeException("last name cannot be null");
        }
    }

    private String generateKey(String fname, String lname) {

        return String.format("%s-%s", fname, lname);
    }


}
