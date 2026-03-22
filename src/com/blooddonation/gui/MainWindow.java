

package com.blooddonation.gui;

import com.blooddonation.users.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JButton donorButton, hospitalButton, adminButton, exitButton;

    public MainWindow() {
        setTitle("Blood Donation System");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        // Initialize buttons
        donorButton = new JButton("Donor Registration");
        hospitalButton = new JButton("Hospital Dashboard");
        adminButton = new JButton("Admin Panel");
        exitButton = new JButton("Exit");

        // Add buttons to the frame
        add(donorButton);
        add(hospitalButton);
        add(adminButton);
        add(exitButton);

        // Action Listeners
        donorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DonorRegistrationForm();
            }
        });

        hospitalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HospitalDashboard();
            }
        });

        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Creating an Admin instance and passing it to the AdminPanel
                Admin admin = new Admin("Super Admin", "9675880780", "ge45A9");
                new AdminPanel(admin);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit application
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}

