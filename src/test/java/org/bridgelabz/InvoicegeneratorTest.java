package org.bridgelabz;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class InvoicegeneratorTest {

    Invoicegenerator fareCalculator = new Invoicegenerator();

     // TC -1 : 
    @Test
    public void testCalculateFare() {
        double distance1 = 5;
        double time1 = 20;
        double expectedFare1 = (5 * 10) + (20 * 1);
        Assert.assertEquals(expectedFare1, fareCalculator.calculateFare(distance1, time1));
    }

    // Test case 2:
    @Test
    public void testCalculateTotalFare() {

        // Test case 1: Multiple rides with normal fare
        Ride[] rides1 = {
                new Ride(5, 20),   
                new Ride(3, 10),
                new Ride(0.5, 2)
        };
        double expectedFare1 = 117;
       Assert.assertEquals(expectedFare1, fareCalculator.calculateTotalFare(rides1));
    }
}
