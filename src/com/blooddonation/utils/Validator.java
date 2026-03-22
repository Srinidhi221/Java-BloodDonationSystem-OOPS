package com.blooddonation.utils;

public class Validator {
    
    public static boolean isValidName(String name) {
        return name != null && name.matches("[A-Za-z ]{2,}");
    }

    public static boolean isValidContact(String contact) {
        return contact != null && contact.matches("\\d{10}");
    }

    public static boolean isValidAge(int age) {
        return age >= 18 && age <= 65;
    }

    public static boolean isValidBloodType(String bloodType) {
        return bloodType != null && bloodType.matches("A[+-]|B[+-]|O[+-]|AB[+-]");
    }

    public static boolean isValidOrganType(String organ) {
        return organ != null && (organ.equalsIgnoreCase("Heart") || 
                organ.equalsIgnoreCase("Liver") || 
                organ.equalsIgnoreCase("Kidney") || 
                organ.equalsIgnoreCase("Lungs"));
    }
}
