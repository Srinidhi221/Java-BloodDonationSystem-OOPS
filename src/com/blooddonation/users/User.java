package com.blooddonation.users;

public abstract class User {
    private String name;
    private String contact;
    private String role;

    public User(String name, String contact, String role) {
        this.name = name;
        this.contact = contact;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getRole() {
        return role;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayInfo();
}
