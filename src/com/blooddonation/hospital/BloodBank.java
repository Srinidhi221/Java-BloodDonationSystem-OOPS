package com.blooddonation.hospital;

import java.util.HashMap;
import java.util.Map;

public class BloodBank {
    private Map<String, Integer> bloodInventory;

    public BloodBank() {
        bloodInventory = new HashMap<>();
        initializeInventory(); 
    }

    private void initializeInventory() {
        // Initial blood stock (in units)
        bloodInventory.put("A+", 10);
        bloodInventory.put("A-", 5);
        bloodInventory.put("B+", 8);
        bloodInventory.put("B-", 4);
        bloodInventory.put("O+", 12);
        bloodInventory.put("O-", 6);
        bloodInventory.put("AB+", 7);
        bloodInventory.put("AB-", 3);
    }

    public void addBlood(String bloodType, int quantity) {
        bloodInventory.put(bloodType, bloodInventory.getOrDefault(bloodType, 0) + quantity);
        System.out.println(quantity + " units of " + bloodType + " added to the blood bank.");
    }

    public boolean isBloodAvailable(String bloodType, int quantity) {
        return bloodInventory.getOrDefault(bloodType, 0) >= quantity;
    }

    public boolean dispenseBlood(String bloodType, int quantity) {
        if (isBloodAvailable(bloodType, quantity)) {
            bloodInventory.put(bloodType, bloodInventory.get(bloodType) - quantity);
            System.out.println(quantity + " units of " + bloodType + " dispensed.");
            return true;
        } else {
            System.out.println("Insufficient blood stock for " + bloodType);
            return false;
        }
    }

    public void displayBloodStock() {
        System.out.println("---- Blood Bank Inventory ----");
        for (Map.Entry<String, Integer> entry : bloodInventory.entrySet()) {
            System.out.println("Blood Type: " + entry.getKey() + " | Units: " + entry.getValue());
        }
    }
}
