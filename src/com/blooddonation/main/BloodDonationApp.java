//package com.blooddonation.main;
//
//import com.blooddonation.gui.MainWindow;
//
//public class BloodDonationApp {
//    public static void main(String[] args) {
//        new MainWindow();
//    }
//}


package com.blooddonation.main;

import com.blooddonation.users.Admin;
import com.blooddonation.users.Donor;
import com.blooddonation.donations.BloodDonation;
import com.blooddonation.donations.DonationRequest;
import com.blooddonation.donations.OrganDonation;
import com.blooddonation.gui.MainWindow;
import com.blooddonation.utils.DatabaseSimulator;

import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class BloodDonationApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Admin admin = new Admin("SuperAdmin", "9999999999", "A001");

    public static void main(String[] args) {
    	 new MainWindow();
        while (true) {
            System.out.println("\n=== Blood Donation System ===");
            System.out.println("1. Register Donor");
            System.out.println("2. View Donors");
            System.out.println("3. Create Donation Request");
            System.out.println("4. View Pending Requests");
            System.out.println("5. Approve/Reject Donation");
            System.out.println("6. View Blood Donations");
            System.out.println("7. View Organ Donations");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    registerDonor();
                    break;
                case 2:
                    viewDonors();
                    break;
                case 3:
                    createDonationRequest();
                    break;
                case 4:
                    viewPendingRequests();
                    break;
                case 5:
                    handleDonationApproval();
                    break;
                case 6:
                    viewBloodDonations();
                    break;
                case 7:
                    viewOrganDonations();
                    break;
                case 8:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // 1️⃣ Register a new donor
    private static void registerDonor() {
        System.out.print("Enter Donor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Blood Type: ");
        String bloodType = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Donor donor = new Donor(name, contact, bloodType, age);
        DatabaseSimulator.addDonor(donor);
        System.out.println("Donor registered successfully!");
    }

    // 2️View all registered donors
    private static void viewDonors() {
        List<Donor> donors = DatabaseSimulator.getDonors();
        if (donors.isEmpty()) {
            System.out.println("No donors found!");
        } else {
            System.out.println("\n=== Registered Donors ===");
            for (Donor donor : donors) {
                donor.displayDetails();
            }
        }
    }

    // 3️⃣ Create a new donation request
    private static void createDonationRequest() {
    	 System.out.print("Enter Donor Name: ");
         String donorName = scanner.nextLine();
        System.out.print("Enter Hospital Name: ");
        String hospitalName = scanner.nextLine();
        System.out.print("Enter Requested Blood Type (or type 'none' for organ request): ");
        String bloodType = scanner.nextLine();
        System.out.print("Enter Requested Organ (or type 'none' for blood request): ");
        String organ = scanner.nextLine();
        System.out.print("Enter Quantity (Units of blood or 1 for organ): ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (bloodType.equalsIgnoreCase("none")) bloodType = null;
        if (organ.equalsIgnoreCase("none")) organ = null;

        DonationRequest request = new DonationRequest(donorName,hospitalName, bloodType, organ, quantity, new Date());
        DatabaseSimulator.addDonationRequest(request);
        System.out.println("Donation request added successfully!");
    }

    // 4️⃣ View all pending donation requests
    private static void viewPendingRequests() {
        List<DonationRequest> requests = DatabaseSimulator.getDonationRequests();
        if (requests.isEmpty()) {
            System.out.println("No pending donation requests!");
        } else {
            System.out.println("\n=== Pending Donation Requests ===");
            for (DonationRequest request : requests) {
                request.displayRequestDetails();
            }
        }
    }

    // 5️⃣ Approve or Reject a donation request
    private static void handleDonationApproval() {
        System.out.print("Enter Donor Name to approve/reject request: ");
        String donorName = scanner.nextLine();
        List<DonationRequest> requests = DatabaseSimulator.getDonationRequests();

        for (DonationRequest request : requests) {
            if (request.getDonorName().equalsIgnoreCase(donorName)) {
                System.out.print("Approve (A) or Reject (R)? ");
                String decision = scanner.nextLine();

                if (decision.equalsIgnoreCase("A")) {
                    admin.approveDonation(donorName);
                    DatabaseSimulator.removeDonationRequest(request);

                    if (request.getRequestedBloodType() != null) {
                        DatabaseSimulator.getBloodDonations().add(new BloodDonation(donorName, request.getRequestedBloodType(), new Date(), 200));
                    } else if (request.getRequestedOrgan() != null) {
                        DatabaseSimulator.getOrganDonations().add(new OrganDonation(donorName, request.getRequestedOrgan(), new Date(),"Interior"));
                    }

                    System.out.println("Donation Approved!");
                } else if (decision.equalsIgnoreCase("R")) {
                    admin.rejectDonation(donorName);
                    System.out.println("Donation Rejected.");
                } else {
                    System.out.println("Invalid choice.");
                }
                return;
            }
        }
        System.out.println("No matching donation request found.");
    }

    // 6️⃣ View all blood donations
    private static void viewBloodDonations() {
        List<BloodDonation> donations = DatabaseSimulator.getBloodDonations();
        if (donations.isEmpty()) {
            System.out.println("No blood donations recorded!");
        } else {
            System.out.println("\n=== Blood Donations ===");
            for (BloodDonation donation : donations) {
                System.out.println("Donor: " + donation.getDonorName() + " | Blood Type: " + donation.getBloodType() + " | Date: " + donation.getDonationDate());
            }
        }
    }

    // 7️⃣ View all organ donations
    private static void viewOrganDonations() {
        List<OrganDonation> donations = DatabaseSimulator.getOrganDonations();
        if (donations.isEmpty()) {
            System.out.println("No organ donations recorded!");
        } else {
            System.out.println("\n=== Organ Donations ===");
            for (OrganDonation donation : donations) {
                System.out.println("Donor: " + donation.getDonorName() + " | Organ: " + donation.getOrganType() + " | Date: " + donation.getDonationDate());
            }
        }
    }
}
