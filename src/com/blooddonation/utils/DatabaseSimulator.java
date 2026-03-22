package com.blooddonation.utils;

import com.blooddonation.users.Donor;
import com.blooddonation.donations.BloodDonation;
import com.blooddonation.donations.OrganDonation;

import java.util.ArrayList;
import java.util.List;
import com.blooddonation.donations.DonationRequest;


public class DatabaseSimulator {
    private static List<Donor> donors = new ArrayList<>();
    private static List<DonationRequest> donationRequests = new ArrayList<>();
    private static List<BloodDonation> bloodDonations = new ArrayList<>();  // ✅ Declare the list
    private static List<OrganDonation> organDonations = new ArrayList<>();  // ✅ Declare the list
    private static List<DonationRequest> pendingDonations = new ArrayList<>();

    static {
        // Adding sample donors
        donors.add(new Donor("John Doe", "1234567890", "A+", 30));
        donors.add(new Donor("Jane Smith", "9876543210", "B-", 25));
        donors.add(new Donor("Alice Brown", "1122334455", "O+", 35));

        // Adding sample donation requests
        donationRequests.add(new DonationRequest("Abraham","City Hospital", "A+", null, 2, new java.util.Date()));
        donationRequests.add(new DonationRequest("Divith","National Hospital", null, "Kidney", 1, new java.util.Date()));
        pendingDonations.add(new DonationRequest("Meera","General Hospital", "O+", null, 3, new java.util.Date()));
        
        
     // Adding sample blood donations
        bloodDonations.add(new BloodDonation("John Doe", "A+", new java.util.Date(), 450));
        bloodDonations.add(new BloodDonation("Jane Smith", "B-", new java.util.Date(),600));

        // Adding sample organ donations
        organDonations.add(new OrganDonation("Alice Brown", "B-", new java.util.Date(), "Kidney"));
    }

    public static List<Donor> getDonors() {
        return donors;
    }

    public static List<DonationRequest> getDonationRequests() {
        return donationRequests;
    }

    public static void addDonor(Donor donor) {
        donors.add(donor);
        System.out.println("New donor added: " + donor.getName());
    }

    public static void addDonationRequest(DonationRequest request) {
        pendingDonations.add(request);
        System.out.println("New donation request added from: " + request.getHospitalName());
    }

    public static void displayAllData() {
        System.out.println("---- Registered Donors ----");
        for (Donor donor : donors) {
            donor.displayDetails();
            System.out.println("-------------------------");
        }

        System.out.println("---- Pending Donation Requests ----");
        for (DonationRequest request : donationRequests) {
            request.displayRequestDetails();
            System.out.println("-------------------------");
        }
    }

	public static List<BloodDonation> getBloodDonations() {
		return bloodDonations;
	}

	public static List<OrganDonation> getOrganDonations() {
		return organDonations;
	}
	
	public static List<DonationRequest> getPendingDonations() {
        return pendingDonations;
    }

    public static void removeDonationRequest(DonationRequest request) {
        pendingDonations.remove(request);
    }
    
    public static void searchDonationsByDonor(String donorName) {
        boolean found = false;
        System.out.println("🔎 Searching for donations by donor: " + donorName);

        // Search blood donations
        for (BloodDonation bd : bloodDonations) {
            if (bd.getDonorName().equalsIgnoreCase(donorName)) {  // Ignore case
                bd.displayDetails();
                found = true;
            }
        }

        // Search organ donations
        for (OrganDonation od : organDonations) {
            if (od.getDonorName().equalsIgnoreCase(donorName)) {
                od.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ No donations found for donor: " + donorName);
        }
    }
    

    
}
