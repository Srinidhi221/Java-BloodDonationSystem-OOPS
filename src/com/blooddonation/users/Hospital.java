package com.blooddonation.users;

import com.blooddonation.interfaces.Registerable;

public class Hospital extends User implements Registerable {
    private String hospitalID;
    private String location;

    public Hospital(String name, String contact, String hospitalID, String location) {
        super(name, contact, "Hospital");
        this.hospitalID = hospitalID;
        this.location = location;
    }

    public String getHospitalID() {
        return hospitalID;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean register() {
        System.out.println("Hospital " + getName() + " registered successfully!");
        return true;
    }

    @Override
    public void displayInfo() {
        System.out.println("Hospital: " + getName() + ", ID: " + hospitalID + ", Location: " + location);
    }

	@Override
	public boolean login(String contact, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}
