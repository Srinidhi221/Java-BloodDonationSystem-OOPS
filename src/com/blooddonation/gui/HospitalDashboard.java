package com.blooddonation.gui;

import com.blooddonation.users.Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HospitalDashboard extends JFrame {
    private JTextField hospitalNameField, contactField, hospitalIDField, locationField;
    private JButton requestBloodButton, cancelButton;

    public HospitalDashboard() {
        setTitle("Hospital Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Labels and Fields
        add(new JLabel("Hospital Name:"));
        hospitalNameField = new JTextField();
        add(hospitalNameField);

        add(new JLabel("Contact:"));
        contactField = new JTextField();
        add(contactField);

        add(new JLabel("Hospital ID:"));
        hospitalIDField = new JTextField();
        add(hospitalIDField);

        add(new JLabel("Location:"));
        locationField = new JTextField();
        add(locationField);

        // Buttons
        requestBloodButton = new JButton("Request Blood");
        cancelButton = new JButton("Cancel");
        add(requestBloodButton);
        add(cancelButton);

        // Button Action Listeners
        requestBloodButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                requestBlood();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void requestBlood() {
        String name = hospitalNameField.getText();
        String contact = contactField.getText();
        String hospitalID = hospitalIDField.getText();
        String location = locationField.getText();

        if (name.isEmpty() || contact.isEmpty() || hospitalID.isEmpty() || location.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Hospital hospital = new Hospital(name, contact, hospitalID, location);
        hospital.register();
        JOptionPane.showMessageDialog(this, "Blood request submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}
