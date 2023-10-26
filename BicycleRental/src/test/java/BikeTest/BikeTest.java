package BikeTest;
import Bike.Regular;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {
    //Selecting regular bike for testing
    private final Regular bike = new Regular(1);

    @Test
    public void negativeId() {
        assertThrows(IllegalArgumentException.class, () -> new Regular(-2), "IllegalArgumentException was not thrown for negative value !");
    }

    @Test
    public void checkId() {
        assertEquals(1, bike.getId(), "The expected id is not equal to 1 !");
    }

    @Test
    public void negativeKm() {
        assertThrows(IllegalArgumentException.class, () -> bike.setKm(-2.5), "IllegalArgumentException was not thrown for negative value !");
    }

    @Test
    public void getKm() {
        bike.setKm(8.5);
        assertEquals(8.5, bike.getKm(), "Expected kilometres were 8.5 !");
    }

    @Test
    public void negativeStartHour() {
        assertThrows(IllegalArgumentException.class, () -> bike.setStartTime(-8, 30), "IllegalArgumentException was not thrown for negative value !");
    }

    @Test
    public void negativeEndMinute() {
        assertThrows(IllegalArgumentException.class, () -> bike.setEndTime(9, -50), "IllegalArgumentException was not thrown for negative value !");
    }

    @Test
    public void durationHours() {
        bike.setStartTime(12, 0);
        bike.setEndTime(14, 0);
        assertEquals(2, bike.getHours(), "Expected was 2 !");
    }

    @Test
    public void testSetAndGetRented() {
        bike.setRented(true);
        assertTrue(bike.isRented(), "Expected was true !");
    }

    @Test
    public void totalDistance() {
        bike.setKm(20.5);
        assertEquals(20.5, bike.getTotalDistance(), "Total distance is not equal to 20.5 !");
    }
}
