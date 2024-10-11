package org.bridgelabz;

public class Invoice {
    private int totalRides;
    private double totalFare;
    private double averageFarePerRide;

    public Invoice(int totalRides, double totalFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFarePerRide = totalFare / totalRides;
    }

    public int getTotalRides() {
        return totalRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getAverageFarePerRide() {
        return averageFarePerRide;
    }

    @Override
    public String toString() {
        return "Invoice: \n" +
                "Total Rides: " + totalRides + "\n" +
                "Total Fare: Rs. " + totalFare + "\n" +
                "Average Fare per Ride: Rs. " + averageFarePerRide;
    }
}

