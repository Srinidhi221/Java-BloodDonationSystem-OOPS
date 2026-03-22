package com.blooddonation.interfaces;

public interface Registerable {
    boolean register();  // Method to handle user registration
    boolean login(String contact, String password);  // Method to handle user login
}
