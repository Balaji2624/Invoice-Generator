package org.bridgelabz;

public class Invoicegenerator {
    private static final double COST_PER_KM = 10;
    private static final double COST_PER_MINUTE = 1;
    private static final double MINIMUM_FARE = 5;

    public double calculateFare(double distanceInKm, double timeInMinutes) {
        double fare = (distanceInKm * COST_PER_KM) + (timeInMinutes * COST_PER_MINUTE);
        return Math.max(fare, MINIMUM_FARE);
    }

    private double calculateFareForRide(Ride ride) {
        double fare = (ride.getDistanceInKm() * COST_PER_KM) + (ride.getTimeInMinutes() * COST_PER_MINUTE);
        return Math.max(fare, MINIMUM_FARE);
    }
    public double calculateTotalFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFareForRide(ride);
        }
        return totalFare;
    }

    public static void main(String[] args) {
        Invoicegenerator fareCalculator = new Invoicegenerator();

        Ride[] rides = {
                new Ride(5, 20),
                new Ride(3, 10),
                new Ride(0.5, 2)
        };
        double totalFare = fareCalculator.calculateTotalFare(rides);
        System.out.println("The total fare for all rides is: Rs. " + totalFare);
    }
}
