package com.blooddonation.events;

import com.blooddonation.interfaces.EventManageable;

public class BloodCamp implements EventManageable {
    private String eventName;
    private String date;
    private String location;
    private boolean isScheduled;

    public BloodCamp(String eventName, String date, String location) {
        this.eventName = eventName;
        this.date = date;
        this.location = location;
        this.isScheduled = false;
    }

    @Override
    public void scheduleEvent(String eventName, String date, String location) {
        this.eventName = eventName;
        this.date = date;
        this.location = location;
        this.isScheduled = true;
        System.out.println("Blood donation camp '" + eventName + "' scheduled on " + date + " at " + location);
    }

    @Override
    public void cancelEvent(String eventName) {
        if (this.isScheduled && this.eventName.equals(eventName)) {
            this.isScheduled = false;
            System.out.println("Blood donation camp '" + eventName + "' has been canceled.");
        } else {
            System.out.println("No scheduled event found with the name '" + eventName + "'.");
        }
    }

    public void displayEventDetails() {
        if (isScheduled) {
            System.out.println("Upcoming Blood Camp: " + eventName);
            System.out.println("Date: " + date);
            System.out.println("Location: " + location);
        } else {
            System.out.println("No active blood camp events.");
        }
    }
}
