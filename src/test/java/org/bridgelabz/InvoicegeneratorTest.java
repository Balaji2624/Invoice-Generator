package org.bridgelabz;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class InvoicegeneratorTest {
    Invoicegenerator fareCalculator = new Invoicegenerator();


    @Test
    public void testCalculateFare() {
        Invoicegenerator fareCalculator = new Invoicegenerator();

        // Test case 1:
        double distance1 = 5;
        double time1 = 20;
        double expectedFare1 = (5 * 10) + (20 * 1);
        Assert.assertEquals(expectedFare1, fareCalculator.calculateFare(distance1, time1));
    }
}
