package Bike;

public enum BikeType {
    //The cost is attached to the enum https://www.baeldung.com/java-enum-values
    REGULAR(0.20), //this is passed as the cost in the constructor
    MOUNTAINBIKE(0.25),
    ELECTRIC(0.50);

    private double cost;

    BikeType(double Cost){
        this.cost = Cost;
    }

    public double getCost(){
        return this.cost;
    }
}
