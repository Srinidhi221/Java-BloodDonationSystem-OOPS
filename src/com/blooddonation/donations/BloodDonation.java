package com.blooddonation.donations;

import java.util.Date;

public class BloodDonation extends Donation {
    private int volume; // in milliliters
    private String donorName;

    public BloodDonation(String donorName, String bloodType, Date donationDate, int volume) {
        super(donorName, bloodType, donationDate);
        this.volume = volume;
    }


	public int getVolume() {
        return volume;
    }
	

    public String getDonorName() {
        return donorName;
    }

    public String getBloodType() {
        return bloodType;
    }

    @Override
    public void processDonation() {
        System.out.println("Processing blood donation...");
        System.out.println("Donor: " + donorName + ", Blood Type: " + bloodType + ", Volume: " + volume + "ml");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Volume: " + volume + "ml");
    }
}
