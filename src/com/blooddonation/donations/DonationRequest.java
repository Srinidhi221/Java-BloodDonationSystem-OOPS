


package com.blooddonation.donations;

import java.util.Date;

public class DonationRequest {
    private String hospitalName;
    private String requestedBloodType;
    private String requestedOrgan;
    private int quantity; // Units of blood or single organ
    private Date requestDate;
    private boolean isFulfilled;
	private String donorName;

    // Constructor to initialize hospital donation request details
    public DonationRequest(String donorName, String hospitalName, String requestedBloodType, String requestedOrgan, int quantity, Date requestDate) {
        this.hospitalName = hospitalName;
        this.requestedBloodType = requestedBloodType;
        this.requestedOrgan = requestedOrgan;
        this.quantity = quantity;
        this.requestDate = requestDate;
        this.isFulfilled = false; // Initially, the request is not fulfilled
        this.donorName=donorName;
    }

    // Getter methods
    public String getHospitalName() {
        return hospitalName;
    }

    public String getRequestedBloodType() {
        return requestedBloodType;
    }

    public String getRequestedOrgan() {
        return requestedOrgan;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public boolean isFulfilled() {
        return isFulfilled;
    }

    // Method to mark the request as fulfilled
    public void fulfillRequest() {
        if (!isFulfilled) {
            isFulfilled = true;
            System.out.println("Donation request fulfilled for " + hospitalName);
        } else {
            System.out.println("Request is already fulfilled.");
        }
    }

    // Display donation request details
    public void displayRequestDetails() {
        System.out.println("Hospital: " + hospitalName);
        if (requestedBloodType != null) {
            System.out.println("Requested Blood Type: " + requestedBloodType);
        }
        if (requestedOrgan != null) {
            System.out.println("Requested Organ: " + requestedOrgan);
        }
        System.out.println("Quantity: " + quantity);
        System.out.println("Request Date: " + requestDate);
        System.out.println("Status: " + (isFulfilled ? "Fulfilled" : "Pending"));
    }

    // This method can be used to change the status of the request (fulfilled or pending)
    public void setStatus(boolean isFulfilled) {
        this.isFulfilled = isFulfilled;
    }

	public String getDonorName() {
		// TODO Auto-generated method stub
		return donorName;
	}
}

