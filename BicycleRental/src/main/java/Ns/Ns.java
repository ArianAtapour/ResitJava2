package Ns;

import Bike.Bike;
import Bike.Regular;
import Bike.MountainBike;
import Bike.Electric;
import Bike.BikeType;
import Customer.Customer;

import java.util.HashMap;

public class Ns {
    private HashMap<Bike, Customer> bikes;

    public Ns(){
        this.bikes = new HashMap<Bike, Customer>();
    }

    //The idea is to set the value to null so then later when the user rents the bike the value is added
    public void addBike(Bike Bike){
        this.bikes.put(Bike, null);
    }

    public HashMap<Bike, Customer> getBikes(){
        return this.bikes;
    }

    public void rentBike(Customer Customer, Bike Bike){
        if(this.bikes.containsKey(Bike)){
            this.bikes.put(Bike, Customer);
            //Set rented boolean of Bike class to true
            Bike.setRented(true);
        }else{
            throw new IllegalArgumentException("Bike not found !");
        }
    }

    public String returnBike(Bike Bike){
        double total = 0;
        //Default deposit is 20
        double deposit = 20;
        String response = null;

        /*
            Check for the bike, if it exists as key, check what instance is it,
            calculate the total based on the ENUM (take the time into account as well), erase the customer
         */

        if(this.bikes.containsKey(Bike)){
            if(Bike instanceof Regular){
                total = deposit + (BikeType.REGULAR.getCost()*Bike.getKm()) + (Bike.getHours()*2);
                //Check order if it's right
                response = "Renter: " + this.bikes.get(Bike).getName() + " has to pay: " + total + " \u20AC";
                //Check if it removes and if it's not a double entry with the previous one
                //Set rented to false
                Bike.setRented(false);
                this.bikes.put(Bike, null);
            }
            if(Bike instanceof MountainBike){
                total = deposit + (BikeType.MOUNTAINBIKE.getCost()*Bike.getKm()) + (Bike.getHours()*2);
                //Check order if it's right
                response = "Renter: " + this.bikes.get(Bike).getName() + " has to pay: " + total + " \u20AC";
                //Check if it removes and if it's not a double entry with the previous one
                //Set rented to false
                Bike.setRented(false);
                this.bikes.put(Bike, null);
            }
            if(Bike instanceof Electric){
                total = deposit + (BikeType.ELECTRIC.getCost()*Bike.getKm()) + (Bike.getHours()*2);
                //Check order if it's right
                response = "Renter: " + this.bikes.get(Bike).getName() + " has to pay: " + total + " \u20AC";
                //Check if it removes and if it's not a double entry with the previous one
                //Set rented to false
                Bike.setRented(false);
                this.bikes.put(Bike, null);
            }
        }else{
            throw new IllegalArgumentException("Bike not found !");
        }

        return response;
    }

    public String getAvailableBikes(){
        int availableBikes = 0;
        for(Bike bike:this.bikes.keySet()){
            //By default it's true? Check this
            if(!bike.isRented()){
                availableBikes++;
            }
        }
        return "Available bikes: " + availableBikes;
    }
}
