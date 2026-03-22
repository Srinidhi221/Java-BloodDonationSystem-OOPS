package com.blooddonation.users;

public class Donor extends User {
    private String bloodType;
    private int age;
    private boolean isEligible;

    public Donor(String name, String contact, String bloodType, int age) {
        super(name, contact, "Donor");
        this.bloodType = bloodType;
        this.age = age;
        this.isEligible = checkEligibility();
    }

    private boolean checkEligibility() {
        return age >= 18 && age <= 65; // Basic eligibility rule
    }

    public void displayDetails() {
        System.out.println("Donor Name: " + getName());
        System.out.println("Contact: " + getContact());
        System.out.println("Blood Type: " + bloodType);
        System.out.println("Age: " + age);
        System.out.println("Eligibility: " + (isEligible ? "Eligible to Donate" : "Not Eligible to Donate"));
    }

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		 System.out.println("Donor Name: " + getName());
	        System.out.println("Contact: " + getContact());
	        System.out.println("Blood Type: " + bloodType);
	        System.out.println("Age: " + age);
	        System.out.println("Eligibility: " + (isEligible ? "Eligible to Donate" : "Not Eligible to Donate"));
	}

	public boolean register() {
	    // Ensure age is within a valid donation range (e.g., 18-65)
	    if (age < 18 || age > 65) {
	        System.out.println("Registration failed: Age not eligible for donation.");
	        return false;  // Reject underage or senior donors
	    }

	    // Ensure name and contact are not empty
	    if (getName().trim().isEmpty() || getContact().trim().isEmpty()) {
	        System.out.println("Registration failed: Name or contact cannot be empty.");
	        return false;
	    }

	    // Ensure valid blood type
	    String[] validBloodTypes = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
	    boolean isValidBloodType = false;
	    for (String type : validBloodTypes) {
	        if (type.equalsIgnoreCase(bloodType)) {
	            isValidBloodType = true;
	            break;
	        }
	    }
	    if (!isValidBloodType) {
	        System.out.println("Registration failed: Invalid blood type.");
	        return false;
	    }

	    // If all conditions pass, simulate successful registration
	    System.out.println("Donor registered successfully!");
	    return true;
	}

}
