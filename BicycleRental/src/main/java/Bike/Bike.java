/**
 * Package that has classes associated to bikes.
 */
package Bike;

import java.time.Duration;
import java.time.LocalTime;

/**
 * Represents a generic bike which can be used for rental purposes.
 * This abstract class provides basic attributes such as distance traveled,
 * rental status, and the total distance the bike has covered.
 * <p>
 * This class is used for identification of the bike, kilometres, hours, and total kilometres tracked.
 * </p>
 *
 * @author Arian Atapour
 * @version 1.0
 */

public abstract class Bike {
    /**
     * Field id use for identification of the bike.
     */
    private int id;
    /**
     * Field kilometres for the bike.
     */
    private double km;
    /**
     * Field totalKm to store the total kilometres for the bike.
     */
    private double totalKm;
    /**
     * Field rented used to tracked the availability of the bike.
     */
    private boolean rented;
    /**
     * Field startTime to track the start time of the bike.
     */
    private LocalTime startTime;
    /**
     * Field endTime to track the end time of the bike.
     */
    private LocalTime endTime;

    /**
     * Constructor used for setting the identification of the bike of type integer.
     *
     * @param Id
     */
    public Bike(int Id) {
        setId(Id);
    }

    /**
     * Setter for the ID of the bike of type integer.
     *
     * @param Id Number identifier for the bike.
     * @throws IllegalArgumentException If ID is negative throw exception.
     */
    private void setId(int Id) {
        if (Id < 0) {
            throw new IllegalArgumentException("Value cannot be smaller than 0 !");
        }
        this.id = Id;
    }


    /**
     * Gets the ID of the bike.
     *
     * @return Gets the ID of the bike.
     */
    public int getId() {
        return this.id;
    }


    /**
     * Recorded distance during the rental of the bike.
     *
     * @param Km The distance(covered in kilometres).
     * @throws IllegalArgumentException Exception is thrown when the kilometres are negative.
     */
    public void setKm(double Km) {
        if (Km < 0.0) {
            throw new IllegalArgumentException("Value cannot be smaller than 0 !");
        }
        this.km += Km;
        this.totalKm += Km;
    }

    /**
     * Get the distance made by the renter.
     *
     * @return Distance made in kilometers.
     */
    public double getKm() {
        return this.km;
    }

    /**
     * Reset the km to 0.0 (when the renter returns the bike in the Ns class).
     */
    public void resetKm() {
        this.km = 0.0;
    }

    /**
     * Start time recorded during the rental.
     *
     * @param hour   Hour of the start time.
     * @param minute Minute of the start time.
     * @throws IllegalArgumentException If the hours or minutes are negative, exception is thrown.
     */
    public void setStartTime(int hour, int minute) {
        if (hour < 0 || minute < 0) {
            throw new IllegalArgumentException("Hour or minutes cannot be lower than 0 !");
        }
        this.startTime = LocalTime.of(hour, minute);
    }

    /**
     * End time recorded during the rental.
     *
     * @param hour   Hour of the end time.
     * @param minute Minute of the end time.
     * @throws IllegalArgumentException If the hours or minutes are negative, exception is thrown.
     */
    public void setEndTime(int hour, int minute) {
        if (hour < 0 || minute < 0) {
            throw new IllegalArgumentException("Hour or minutes cannot be lower than 0 !");
        }
        this.endTime = LocalTime.of(hour, minute);
    }

    /**
     * Calculates the hours between the start time and end time.
     *
     * @return The total of type long.
     */
    public long getHours() {
        Duration DurationHours = Duration.between(startTime, endTime);
        long hours = DurationHours.toHours();
        return hours;
    }

    /**
     * Reset the time, after the bike has been returned.
     */
    public void resetTime() {
        this.startTime = LocalTime.of(0,0);
        this.endTime = LocalTime.of(0,0);
    }

    /**
     * Setter for the rental status of the bike.
     *
     * @param Rented Rental status to be set.
     */
    public void setRented(boolean Rented) {
        this.rented = Rented;
    }

    /**
     * Check if the bike is rented.
     *
     * @return True if bike is rented, false if not.
     */
    public boolean isRented() {
        return this.rented;
    }

    /**
     * Total distance that the bike has made.
     *
     * @return Output of type string with the total distance the bike has made.
     */
    public String getTotalDistance() {
        return "The bike " + this.id + " has travelled in total " + this.totalKm + " kilometres.";
    }

}
