package BikeTest;

import Bike.BikeType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BikeTypeTest {
    @Test
    public void regularEnumCost() {
        assertEquals(0.20, BikeType.REGULAR.getCost(), "Expected value was 0.20 for REGULAR enum !");
    }

    @Test
    public void mountainBikeEnumCost() {
        assertEquals(0.25, BikeType.MOUNTAINBIKE.getCost(), "Expected value was 0.25 for MOUNTAINBIKE enum !");
    }

    @Test
    public void electricBikeCost() {
        assertEquals(0.50, BikeType.ELECTRIC.getCost(), "Expected value was 0.50 for ELECTRIC enum !");
    }
}
