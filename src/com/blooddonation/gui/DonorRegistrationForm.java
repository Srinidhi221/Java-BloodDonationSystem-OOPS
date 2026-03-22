package com.blooddonation.gui;

import com.blooddonation.users.Donor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonorRegistrationForm extends JFrame {
    private JTextField nameField, contactField, ageField;
    private JComboBox<String> bloodTypeBox;
    private JButton registerButton, cancelButton;

    public DonorRegistrationForm() {
        setTitle("Donor Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Labels and Fields
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Contact:"));
        contactField = new JTextField();
        add(contactField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Blood Type:"));
        String[] bloodTypes = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
        bloodTypeBox = new JComboBox<>(bloodTypes);
        add(bloodTypeBox);

        // Buttons
        registerButton = new JButton("Register");
        cancelButton = new JButton("Cancel");
        add(registerButton);
        add(cancelButton);

        // Button Action Listeners
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerDonor();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void registerDonor() {
        String name = nameField.getText();
        String contact = contactField.getText();
        String bloodType = (String) bloodTypeBox.getSelectedItem();
        int age;

        try {
            age = Integer.parseInt(ageField.getText());
            Donor donor = new Donor(name, contact, bloodType, age);
            if (donor.register()) {
            	JOptionPane.showMessageDialog(this, "Donor registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Donor not eligible to donate.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid age entered!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
