package org.bridgelabz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {
    private Map<String, List<Ride>> userRidesMap;

    public RideRepository() {
        userRidesMap = new HashMap<>();
    }

    public void addRides(String userId, List<Ride> rides) {
        userRidesMap.put(userId, rides);
    }

    public List<Ride> getRides(String userId) {
        return userRidesMap.getOrDefault(userId, List.of());
    }
}

