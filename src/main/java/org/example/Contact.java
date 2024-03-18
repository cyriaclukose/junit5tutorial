package org.example;

public class Contact {

    private String fname;
    private String lname;
    private String contactNumber;

    public Contact() {
    }

    public Contact(String fname, String lname, String contactNumber) {
        this.fname = fname;
        this.lname = lname;
        this.contactNumber = contactNumber;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
