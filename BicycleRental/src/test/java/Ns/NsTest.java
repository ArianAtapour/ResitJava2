package Ns;

import Bike.Electric;
import Bike.MountainBike;
import Bike.Regular;
import Customer.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NsTest {
    private final Ns ns = new Ns();
    private final Regular bRegular = new Regular(1);
    private final MountainBike bMountainBike = new MountainBike(2);
    private final Electric bElectric = new Electric(3);
    private final Customer customer = new Customer("John Doe");

    //Value must be null before renting
    @Test
    public void addBike() {
        ns.addBike(bRegular);
        assertNull(ns.getBikes().get(bRegular), "Value of regular bike in HashMap is not null !");
    }

    @Test
    public void rentBike() {
        ns.addBike(bRegular);
        ns.rentBike(customer, bRegular);
        assertEquals(customer, ns.getBikes().get(bRegular));
        assertTrue(bRegular.isRented(), "Status of not rent bike is not switched to true !");
    }

    @Test
    public void rentBNotInHashmap() {
        assertThrows(IllegalArgumentException.class, () -> ns.rentBike(customer, bRegular), "IllegalArgumentException not thrown for the fact that the regular bike is not in the HashMap !");
    }

    @Test
    public void returnBRegular() {
        ns.addBike(bRegular);
        ns.rentBike(customer, bRegular);
        bRegular.setStartTime(10, 0);
        bRegular.setEndTime(12, 0);
        bRegular.setKm(10);
        String result = ns.returnBike(bRegular);
        assertTrue(result.contains("Renter: John Doe has to pay:") && result.contains("26"), "Output string for regular bike does not display correctly !");
        assertFalse(bRegular.isRented(), "Status of rented regular bike is not switched to false !");
    }

    @Test
    public void returnBMountainBike() {
        ns.addBike(bMountainBike);
        ns.rentBike(customer, bMountainBike);
        bMountainBike.setStartTime(10, 0);
        bMountainBike.setEndTime(12, 0);
        bMountainBike.setKm(10);
        String result = ns.returnBike(bMountainBike);
        assertTrue(result.contains("Renter: John Doe has to pay:") && result.contains("26.5"), "Output string for mountain bike does not display correctly !");
        assertFalse(bMountainBike.isRented(), "Status of rented mountain bike is not switched to false !");
    }

    @Test
    public void returnBElectric() {
        ns.addBike(bElectric);
        ns.rentBike(customer, bElectric);
        bElectric.setStartTime(10, 0);
        bElectric.setEndTime(12, 0);
        bElectric.setKm(10);
        String result = ns.returnBike(bElectric);
        assertTrue(result.contains("Renter: John Doe has to pay:") && result.contains("29"), "Output string for electric bike does not display correctly !");
        assertFalse(bElectric.isRented(), "Status of rented mountain bike is not switched to false !");
    }


    @Test
    public void returnBNotInHashmap() {
        assertThrows(IllegalArgumentException.class, () -> ns.returnBike(bRegular), "Exception not thrown when bike does not exist in the Hashmap !");
    }

    @Test
    public void getInitialAvailableB() {
        String result = ns.getAvailableBikes();
        assertTrue(result.contains("Available bikes: 0"), "The initial bike number in the HashMap is not 0 !");
    }

    @Test
    public void getAvailableBAfterAdd() {
        ns.addBike(bRegular);
        ns.addBike(bMountainBike);
        ns.addBike(bElectric);
        String result = ns.getAvailableBikes();
        assertTrue(result.contains("Available bikes: 3"), "The number of available bikes is not 3 !");
    }

    @Test
    public void getAvailableBAfterRenting() {
        ns.addBike(bRegular);
        ns.addBike(bMountainBike);
        ns.addBike(bElectric);
        ns.rentBike(customer, bRegular);
        String result = ns.getAvailableBikes();
        assertTrue(result.contains("Available bikes: 2"), "The number of available bikes after renting 1 is not 2 !");
    }
}
