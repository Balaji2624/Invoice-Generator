package org.bridgelabz;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InvoicegeneratorTest {

//    TC 5 :
    @Test
    public void testGenerateInvoice() {
        RideRepository rideRepository = new RideRepository();
        Invoicegenerator fareCalculator = new Invoicegenerator();
        InvoiceService invoiceService = new InvoiceService(rideRepository, fareCalculator);

        // Adding rides for user "user1" with both Normal and Premium rides
        rideRepository.addRides("user1", List.of(
                new Ride(5, 20, RideType.NORMAL),
                new Ride(3, 10, RideType.PREMIUM),
                new Ride(0.5, 2, RideType.NORMAL)
        ));

        // Generating the invoice for "user1"
        Invoice invoice = invoiceService.generateInvoice("user1");
        Assert.assertEquals(3, invoice.getTotalRides());
        Assert.assertEquals(70 + 65 + 7, invoice.getTotalFare(), 0.001);
        Assert.assertEquals((70 + 65 + 7) / 3.0, invoice.getAverageFarePerRide(), 0.001);

        rideRepository.addRides("user2", List.of(
                new Ride(10, 30, RideType.PREMIUM),
                new Ride(1, 5, RideType.PREMIUM)
        ));
        Invoice invoice2 = invoiceService.generateInvoice("user2");
        Assert.assertEquals(2, invoice2.getTotalRides());
        Assert.assertEquals(180 + 55, invoice2.getTotalFare(), 0.001);
        Assert.assertEquals((180 + 55) / 2.0, invoice2.getAverageFarePerRide(), 0.001);
    }
}
