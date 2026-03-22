package com.blooddonation.hospital;

import com.blooddonation.donations.DonationRequest;
import java.util.ArrayList;
import java.util.List;

public class HospitalManager implements HospitalServices {
    private List<DonationRequest> requests;
    private BloodBank bloodBank;

    public HospitalManager(BloodBank bloodBank) {
        this.bloodBank = bloodBank;
        this.requests = new ArrayList<>();
    }

    @Override
    public void requestBlood(String bloodType, int quantity) {
        if (bloodBank.isBloodAvailable(bloodType, quantity)) {
            bloodBank.dispenseBlood(bloodType, quantity);
            System.out.println("Blood request fulfilled immediately for " + bloodType);
        } else {
            DonationRequest request = new DonationRequest("Riyaz", "Apollo",bloodType, null,quantity, new java.util.Date());
            requests.add(request);
            System.out.println("Blood request added to the pending list.");
        }
    }

    @Override
    public void requestOrgan(String organType) {
        DonationRequest request = new DonationRequest("Soumya","Hospital",null, organType, 1, new java.util.Date());
        requests.add(request);
        System.out.println("Organ request added to the pending list for " + organType);
    }

    @Override
    public void fulfillRequest(DonationRequest request) {
        if (requests.contains(request)) {
            request.fulfillRequest();
            requests.remove(request);
            System.out.println("Hospital donation request fulfilled.");
        } else {
            System.out.println("Request not found.");
        }
    }

    public void displayPendingRequests() {
        System.out.println("---- Pending Hospital Requests ----");
        for (DonationRequest request : requests) {
            request.displayRequestDetails();
            System.out.println("-------------------------");
        }
    }
}
