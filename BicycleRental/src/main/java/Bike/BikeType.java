/**
 * This package contains classes that are related to bikes.
 */
package Bike;

/**
 * Enum with the different types of bikes (regular, mountain bike and electric)
 * <p>
 * This enum is also used to associate the cost to the enum type.
 * </p>
 *
 * @author Arian Atapour
 * @version 1.0
 */
public enum BikeType {
    /**
     * Enum for regular bike.
     */
    REGULAR(0.20),
    /**
     * Enum for mountain bike.
     */
    MOUNTAINBIKE(0.25),
    /**
     * Enum for electric bike.
     */
    ELECTRIC(0.50);

    //Field cost for the cost of the bike type
    private double cost;

    /**
     * Constructor used to set the cost of the bike type.
     *
     * @param Cost the cost of the bike type.
     */
    BikeType(double Cost) {
        this.cost = Cost;
    }

    /**
     * Cost of the bike type is returned.
     *
     * @return Output of type double consisting of the cost o the bike type.
     */
    public double getCost() {
        return this.cost;
    }
}
