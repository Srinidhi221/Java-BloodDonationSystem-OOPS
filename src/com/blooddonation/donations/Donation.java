package com.blooddonation.donations;

import java.util.Date;

public abstract class Donation {
    protected String donorName;
    protected String bloodType;
    protected Date donationDate;

    public Donation(String donorName, String bloodType, Date donationDate) {
        this.donorName = donorName;
        this.bloodType = bloodType;
        this.donationDate = donationDate;
    }

    public String getDonorName() {
        return donorName;
    }

    public String getBloodType() {
        return bloodType;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    // Abstract method to be implemented by subclasses
    public abstract void processDonation();

    public void displayDetails() {
        System.out.println("Donor: " + donorName + ", Blood Type: " + bloodType + ", Date: " + donationDate);
    }
}
