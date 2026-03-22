package com.blooddonation.events;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<BloodCamp> bloodCamps;

    public EventManager() {
        this.bloodCamps = new ArrayList<>();
    }

    public void addEvent(String eventName, String date, String location) {
        BloodCamp newCamp = new BloodCamp(eventName, date, location);
        newCamp.scheduleEvent(eventName, date, location);
        bloodCamps.add(newCamp);
    }

    public void cancelEvent(String eventName) {
        boolean found = false;
        for (BloodCamp camp : bloodCamps) {
            if (camp != null && camp.equals(eventName)) {
                camp.cancelEvent(eventName);
                bloodCamps.remove(camp);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No scheduled event found with the name '" + eventName + "'.");
        }
    }

    public void displayAllEvents() {
        if (bloodCamps.isEmpty()) {
            System.out.println("No blood donation camps scheduled.");
        } else {
            System.out.println("----- Scheduled Blood Donation Camps -----");
            for (BloodCamp camp : bloodCamps) {
                camp.displayEventDetails();
                System.out.println("--------------------------");
            }
        }
    }
}
