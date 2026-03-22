package com.blooddonation.users;

import com.blooddonation.interfaces.AdministrativeActions;

public class Admin extends User implements AdministrativeActions {
    private String adminID;

    public Admin(String name, String contact, String adminID) {
        super(name, contact, "Admin");
        this.adminID = adminID;
    }

    public String getAdminID() {
        return adminID;
    }

    @Override
    public void approveDonation(String donorName) {
        System.out.println("Admin " + getName() + " approved the donation from " + donorName);
    }

    @Override
    public void rejectDonation(String donorName) {
        System.out.println("Admin " + getName() + " rejected the donation from " + donorName);
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin: " + getName() + ", Admin ID: " + adminID);
    }
}
