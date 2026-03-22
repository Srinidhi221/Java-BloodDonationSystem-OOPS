package com.blooddonation.donations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DonationManager {
    private List<Donation> donations;
    private List<DonationRequest> donationRequests;

    public DonationManager() {
        this.donations = new ArrayList<>();
        this.donationRequests = new ArrayList<>();
    }

    public void addDonation(Donation donation) {
        donations.add(donation);
        System.out.println("Donation added: " + donation.getDonorName());
    }

    public void addDonationRequest(DonationRequest request) {
        donationRequests.add(request);
        System.out.println("Donation request added from: " + request.getHospitalName());
    }

    public void fulfillDonationRequest() {
        for (DonationRequest request : donationRequests) {
            if (!request.isFulfilled()) {
                for (Donation donation : donations) {
                    if (request.getRequestedBloodType() != null &&
                            request.getRequestedBloodType().equalsIgnoreCase(donation.getBloodType())) {
                        request.fulfillRequest();
                        donations.remove(donation);
                        System.out.println("Blood donation request fulfilled for " + request.getHospitalName());
                        return;
                    } else if (request.getRequestedOrgan() != null && donation instanceof OrganDonation) {
                        OrganDonation organDonation = (OrganDonation) donation;
                        if (request.getRequestedOrgan().equalsIgnoreCase(organDonation.getOrganType())) {
                            request.fulfillRequest();
                            donations.remove(donation);
                            System.out.println("Organ donation request fulfilled for " + request.getHospitalName());
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("No matching donations available at the moment.");
    }

    public void displayAllDonations() {
        System.out.println("---- List of Donations ----");
        for (Donation donation : donations) {
            donation.displayDetails();
            System.out.println("-------------------------");
        }
    }

    public void displayAllRequests() {
        System.out.println("---- List of Donation Requests ----");
        for (DonationRequest request : donationRequests) {
            request.displayRequestDetails();
            System.out.println("-------------------------");
        }
    }
}
