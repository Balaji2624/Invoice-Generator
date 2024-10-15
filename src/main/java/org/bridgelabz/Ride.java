package org.bridgelabz;

public class Ride {
    private double distanceInKm;
    private double timeInMinutes;
    private RideType rideType;

    public Ride(double distanceInKm, double timeInMinutes, RideType rideType) {
        this.distanceInKm = distanceInKm;
        this.timeInMinutes = timeInMinutes;
        this.rideType = rideType;
    }

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public double getTimeInMinutes() {
        return timeInMinutes;
    }

    public RideType getRideType() {
        return rideType;
    }
}

