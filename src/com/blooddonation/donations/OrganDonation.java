package com.blooddonation.donations;

import java.util.Date;

public class OrganDonation extends Donation {
    private String organType;
    private String donorName;

    public OrganDonation(String donorName, String bloodType, Date donationDate, String organType) {
        super(donorName, bloodType, donationDate);
        this.organType = organType;
    }

    public String getOrganType() {
        return organType;
    }
    
    public String getDonorName() {
        return donorName;
    }
    
    public String getBloodType() {
        return bloodType;
    }


    @Override
    public void processDonation() {
        System.out.println("Processing organ donation...");
        System.out.println("Donor: " + donorName + ", Blood Type: " + bloodType + ", Organ: " + organType);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Organ Type: " + organType);
    }
}
