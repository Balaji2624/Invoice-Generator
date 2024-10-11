package org.bridgelabz;

public class Ride {
    private double distanceInKm;
    private double timeInMinutes;

    public Ride(double distanceInKm, double timeInMinutes) {
        this.distanceInKm = distanceInKm;
        this.timeInMinutes = timeInMinutes;
    }

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public double getTimeInMinutes() {
        return timeInMinutes;
    }
}
