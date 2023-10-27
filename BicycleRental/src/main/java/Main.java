//Assingment 6 Java 2 module book
/*
    6. Bicycle rental
    The NS Group wants new software to track the rental of their bicycles. The
    software should track how many bicycles are still available for rental. There are
    three types of bikes: a regular one, mountain bike and electrical bike. A
    customer can hire a bicycle for a certain amount of time. The end time will be
    registered when the customer returns the bike. In every bicycle is a GPStracker. The tracker tracks the distance the customer has travelled with the
    bicycle. When the customers starts renting he has to pay deposit from €20,-.
    The customer has to pay money per kilometre. This is:
    > €0,20 for a regular bike;
    > €0,25 for a mountain bike;
    > €0,50 for a electrical bike.
    Per hour the customer has to pay €2,-. When the customer returns the bike,
    the customer has to pay. For maintenance purposes the company wants to
    know the total distance the bike has been used.
 */

import Bike.Electric;
import Bike.Regular;
import Customer.Customer;
import Ns.Ns;

public class Main {
    public static void main(String[] args) {
        Ns ns = new Ns();
        Customer cust = new Customer("Arian Atapour");
        Customer cust2 = new Customer("Mac mac");
        Regular bR = new Regular(1);
        Electric bE = new Electric(3);
        ns.addBike(bR);
        ns.addBike(bE);
        ns.rentBike(cust, bE);
        System.out.println("Before Renting:" + ns.getBikes() + " available " + ns.getAvailableBikes());
        bE.setKm(10.5);
        bE.setStartTime(10,0);
        bE.setEndTime(11,0);
        System.out.println(ns.returnBike(bE));
        System.out.println("RETURNING: " + ns.getBikes() + " available " + ns.getAvailableBikes());
        System.out.println("CHANGING RENTER: " + bE.getTotalDistance());
        ns.rentBike(cust2, bE);
        bE.setKm(2);
        bE.setStartTime(10,0);
        bE.setEndTime(11,0);
        System.out.println(ns.returnBike(bE));
        System.out.println("NEW DISTANCE ELECT: " + bE.getTotalDistance());
    }
}