package org.bridgelabz;

public class Invoicegenerator {
    private static final double COST_PER_KM = 10;
    private static final double COST_PER_MINUTE = 1;
    private static final double MINIMUM_FARE = 5;

    public double calculateFare(double distanceInKm, double timeInMinutes) {
        double fare = (distanceInKm * COST_PER_KM) + (timeInMinutes * COST_PER_MINUTE);
        return Math.max(fare, MINIMUM_FARE);
    }

    public static void main(String[] args) {
        Invoicegenerator fareCalculator = new Invoicegenerator();

        double distance = 5;
        double time = 20;
        double fare = fareCalculator.calculateFare(distance, time);

        System.out.println("The total fare is: Rs. " + fare);
    }
}
