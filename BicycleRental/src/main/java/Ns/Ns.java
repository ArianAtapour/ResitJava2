/**
 * Package Ns that contains all the related classes to the Ns bike rental system.
 */
package Ns;

import Bike.Bike;
import Bike.Regular;
import Bike.MountainBike;
import Bike.Electric;
import Bike.BikeType;
import Customer.Customer;

import java.util.HashMap;

/**
 * Bike rental class, (in this case Ns since the NS Group wants it for themselves).
 * <p>
 *      Firstly bikes are added to the hashmap. No renter attahced to them. Afterwards we add the renter by the rent
 *      method in which we add both the bike and renter (it's a hashmap so no duplicate keys, the same one is updated with the renter as the
 *      value). When the customer is done he has to retun the bike through the return method where he will be notified of the price of the ride.
 * </p>
 *
 * @author Arian Atapour
 * @version 1.0
 */
public class Ns {
    /**
     * HashMap for bikes. It takes as key the Bike object and as value the customer object.
     */
    private HashMap<Bike, Customer> bikes;

    /**
     * Constructor used to initialise the bikes HashMap
     */
    public Ns() {
        this.bikes = new HashMap<Bike, Customer>();
    }

    /**
     * Add a bike into the NS rental.
     *
     * @param Bike
     */
    public void addBike(Bike Bike) {
        this.bikes.put(Bike, null);
    }

    /**
     * Get the bikes with the renters (or without renters depending on the case)
     *
     * @return A map of bikes to customers.
     */
    public HashMap<Bike, Customer> getBikes() {
        return this.bikes;
    }

    /**
     * Customer can rent a bike.
     *
     * @param Customer Customer who wants to rent the bike.
     * @param Bike Bike which is to be rented.
     * @throws IllegalArgumentException If the bike that the customer wishes to rent is not found then throw the exception..
     */
    public void rentBike(Customer Customer, Bike Bike) {
        if (this.bikes.containsKey(Bike)) {
            this.bikes.put(Bike, Customer);
            //Set rented boolean of Bike class to true
            Bike.setRented(true);
        } else {
            throw new IllegalArgumentException("Bike not found !");
        }
    }

    /**
     * Customer returns the bike.
     * Calculate the total amount based on the deposit, type of bike, distance traveled and hours used.
     * After the payment the bike has no renter and it's available to be rented again.
     *
     * @param Bike The bike to be returned
     * @return A string output that informs the customer of the price he has to pay.
     * @throws IllegalArgumentException Throw exception if the bike is not found in the system.
     */
    public String returnBike(Bike Bike) {
        double total = 0;
        double deposit = 20;
        String response = null;

        if (this.bikes.containsKey(Bike)) {
            if (Bike instanceof Regular) {
                total = deposit + (BikeType.REGULAR.getCost() * Bike.getKm()) + (Bike.getHours() * 2);
                response = "Renter: " + this.bikes.get(Bike).getName() + " has to pay: " + total + " \u20AC";
                Bike.setRented(false);
                this.bikes.put(Bike, null);
                Bike.resetKm();
                Bike.resetTime();
            }
            if (Bike instanceof MountainBike) {
                total = deposit + (BikeType.MOUNTAINBIKE.getCost() * Bike.getKm()) + (Bike.getHours() * 2);
                response = "Renter: " + this.bikes.get(Bike).getName() + " has to pay: " + total + " \u20AC";
                Bike.setRented(false);
                this.bikes.put(Bike, null);
                Bike.resetKm();
                Bike.resetTime();
            }
            if (Bike instanceof Electric) {
                total = deposit + (BikeType.ELECTRIC.getCost() * Bike.getKm()) + (Bike.getHours() * 2);
                response = "Renter: " + this.bikes.get(Bike).getName() + " has to pay: " + total + " \u20AC";
                Bike.setRented(false);
                this.bikes.put(Bike, null);
                Bike.resetKm();
                Bike.resetTime();
            }
        } else {
            throw new IllegalArgumentException("Bike not found !");
        }

        return response;
    }

    /**
     * Get the number of bikes available for rental.
     *
     * @return Outputs a string which displays the available number of bikes.
     */
    public String getAvailableBikes() {
        int availableBikes = 0;
        for (Bike bike : this.bikes.keySet()) {
            if (!bike.isRented()) {
                availableBikes++;
            }
        }
        return "Available bikes: " + availableBikes;
    }
}
