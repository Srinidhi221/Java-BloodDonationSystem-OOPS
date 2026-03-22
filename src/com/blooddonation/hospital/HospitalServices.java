package com.blooddonation.hospital;

import com.blooddonation.donations.DonationRequest;

public interface HospitalServices {
    void requestBlood(String bloodType, int quantity);
    void requestOrgan(String organType);
    void fulfillRequest(DonationRequest request);
}
