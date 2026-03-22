package com.blooddonation.gui;

import com.blooddonation.users.Admin;
import com.blooddonation.donations.BloodDonation;
import com.blooddonation.donations.DonationRequest;
import com.blooddonation.donations.OrganDonation;
import com.blooddonation.utils.DatabaseSimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminPanel extends JFrame {
    private JComboBox<String> donationRequestsDropdown;
    private JButton approveButton, rejectButton, closeButton;
    private Admin admin;

    public AdminPanel(Admin admin) {
    	displayDonations();
        this.admin = admin;

        setTitle("Admin Panel");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        // Label and Dropdown
        add(new JLabel("Select a Donation Request:"));

        donationRequestsDropdown = new JComboBox<>();
        loadDonationRequests(); // Load requests into dropdown
        add(donationRequestsDropdown);

        // Buttons
        approveButton = new JButton("Approve Donation");
        rejectButton = new JButton("Reject Donation");
        closeButton = new JButton("Close");

        add(approveButton);
        add(rejectButton);
        add(closeButton);

        // Button Actions
        approveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleApproval();
            }
        });

        rejectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleRejection();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });

        setVisible(true);
    }

    // Load pending donation requests into dropdown
//    private void loadDonationRequests() {
//        List<DonationRequest> pendingRequests = DatabaseSimulator.getPendingDonations();
//        for (DonationRequest request : pendingRequests) {
//            donationRequestsDropdown.addItem(request.getHospitalName() + " - " +
//                    (request.getRequestedBloodType() != null ? "Blood: " + request.getRequestedBloodType() :
//                            "Organ: " + request.getRequestedOrgan()));
//        }
//    }
    
    
    private void loadDonationRequests() {
        List<DonationRequest> pendingRequests = DatabaseSimulator.getPendingDonations();
        
        System.out.println("Checking pending donation requests... Total: " + pendingRequests.size()); // Debugging output
        
        if (pendingRequests.isEmpty()) {
            donationRequestsDropdown.addItem("No pending requests");
        } else {
            for (DonationRequest request : pendingRequests) {
                System.out.println("Loading request: " + request.getHospitalName()); // Debugging output
                donationRequestsDropdown.addItem(request.getHospitalName() + " - " +
                        (request.getRequestedBloodType() != null ? "Blood: " + request.getRequestedBloodType() :
                                "Organ: " + request.getRequestedOrgan()));
            }
        }
    }


    // Approve selected donation request
    private void handleApproval() {
        int selectedIndex = donationRequestsDropdown.getSelectedIndex();
        if (selectedIndex != -1) {
            DonationRequest request = DatabaseSimulator.getPendingDonations().get(selectedIndex);
            request.setStatus(true); // Mark as fulfilled
            admin.approveDonation(request.getHospitalName());
            JOptionPane.showMessageDialog(this, "Donation Approved for: " + request.getHospitalName());
            DatabaseSimulator.removeDonationRequest(request); // Remove from pending
            refreshDropdown();
        } else {
            JOptionPane.showMessageDialog(this, "No request selected.");
        }
    }

    // Reject selected donation request
    private void handleRejection() {
        int selectedIndex = donationRequestsDropdown.getSelectedIndex();
        if (selectedIndex != -1) {
            DonationRequest request = DatabaseSimulator.getPendingDonations().get(selectedIndex);
            admin.rejectDonation(request.getHospitalName());
            JOptionPane.showMessageDialog(this, "Donation Rejected for: " + request.getHospitalName());
            DatabaseSimulator.removeDonationRequest(request); // Remove from pending
            refreshDropdown();
        } else {
            JOptionPane.showMessageDialog(this, "No request selected.");
        }
    }

    // Refresh the dropdown list after an approval/rejection
    private void refreshDropdown() {
        donationRequestsDropdown.removeAllItems();
        loadDonationRequests();
    }
    
    
    private void displayDonations() {
        System.out.println("---- Blood Donations ----");
        for (BloodDonation donation : DatabaseSimulator.getBloodDonations()) {
            System.out.println("Donor: " + donation.getDonorName() + " | Blood Type: " + donation.getBloodType());
        }

        System.out.println("---- Organ Donations ----");
        for (OrganDonation donation : DatabaseSimulator.getOrganDonations()) {
            System.out.println("Donor: " + donation.getDonorName() + " | Organ: " + donation.getOrganType());
        }
    }

}
