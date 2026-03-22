package com.blooddonation.interfaces;

public interface EventManageable {
    void scheduleEvent(String eventName, String date, String location);
    void cancelEvent(String eventName);
}
