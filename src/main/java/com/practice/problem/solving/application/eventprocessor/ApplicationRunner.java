package com.practice.problem.solving.application.eventprocessor;

public class ApplicationRunner {

    public static void main(String[] args) {
        EventFinder eventFinder = new EventFinder(5);

        // Simulating event stream
        String[] events = {"A", "B", "C", "A", "B", "A", "A", "B", "C", "D"};
        for (String event : events) {
            eventFinder.addEvent(event);
        }

        // Find the most popular event
        String mostPopularEvent = eventFinder.findMostPopularEvent();
        System.out.println("Most popular event: " + mostPopularEvent);
    }
}
