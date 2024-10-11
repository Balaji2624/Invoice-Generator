package org.bridgelabz;

import java.util.List;

public class InvoiceService {
    private RideRepository rideRepository;
    private Invoicegenerator fareCalculator;

    public InvoiceService(RideRepository rideRepository, Invoicegenerator fareCalculator) {
        this.rideRepository = rideRepository;
        this.fareCalculator = fareCalculator;
    }

    // Method to get the invoice for a given user ID
    public Invoice generateInvoice(String userId) {
        List<Ride> rides = rideRepository.getRides(userId);
        double totalFare = fareCalculator.calculateTotalFare(rides);
        return new Invoice(rides.size(), totalFare);
    }
}

