package org.bridgelabz;

import java.util.List;

public class Invoicegenerator {
    // Constants for Normal Rides
    private static final double NORMAL_COST_PER_KM = 10;
    private static final double NORMAL_COST_PER_MINUTE = 1;
    private static final double NORMAL_MINIMUM_FARE = 5;

    // Constants for Premium Rides
    private static final double PREMIUM_COST_PER_KM = 15;
    private static final double PREMIUM_COST_PER_MINUTE = 2;
    private static final double PREMIUM_MINIMUM_FARE = 20;

    // Method to calculate fare based on ride type
    public double calculateFareForRide(Ride ride) {
        double fare;
        if (ride.getRideType() == RideType.NORMAL) {
            fare = (ride.getDistanceInKm() * NORMAL_COST_PER_KM) + (ride.getTimeInMinutes() * NORMAL_COST_PER_MINUTE);
            return Math.max(fare, NORMAL_MINIMUM_FARE);
        } else {
            fare = (ride.getDistanceInKm() * PREMIUM_COST_PER_KM) + (ride.getTimeInMinutes() * PREMIUM_COST_PER_MINUTE);
            return Math.max(fare, PREMIUM_MINIMUM_FARE);
        }
    }

    // Method to calculate total fare for multiple rides
    public double calculateTotalFare(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFareForRide(ride);
        }
        return totalFare;
    }

    public static void main(String[] args) {
        // Create instances of repository and fare calculator
        RideRepository rideRepository = new RideRepository();
        Invoicegenerator invoicegenerator = new Invoicegenerator();

        // Create an instance of the InvoiceService
        InvoiceService invoiceService = new InvoiceService(rideRepository, invoicegenerator);

        // Adding some rides for user "user1" with both Normal and Premium rides
        rideRepository.addRides("user1", List.of(
                new Ride(5, 20, RideType.NORMAL),    // 5 km, 20 minutes (Normal Ride)
                new Ride(3, 10, RideType.PREMIUM),   // 3 km, 10 minutes (Premium Ride)
                new Ride(0.5, 2, RideType.NORMAL)    // 0.5 km, 2 minutes (Normal Ride, Minimum fare Rs. 5)
        ));

        // Adding some rides for another user "user2" with only Premium rides
        rideRepository.addRides("user2", List.of(
                new Ride(10, 30, RideType.PREMIUM),   // 10 km, 30 minutes (Premium Ride)
                new Ride(1, 5, RideType.PREMIUM)      // 1 km, 5 minutes (Premium Ride, Minimum fare Rs. 20)
        ));

        // Generate and print the invoice for user "user1"
        Invoice invoiceUser1 = invoiceService.generateInvoice("user1");
        System.out.println("Invoice for user1:");
        System.out.println(invoiceUser1);

        // Generate and print the invoice for user "user2"
        Invoice invoiceUser2 = invoiceService.generateInvoice("user2");
        System.out.println("\nInvoice for user2:");
        System.out.println(invoiceUser2);

    }
}
