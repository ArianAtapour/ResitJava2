/**
 * Bike abstract class. Extended from this class are the classes Regular, MountainBike, Electric.
 * <p>
 *      This class is used
 * </p>
 *
 * @author Arian Atapour
 * @version 1.0
 */
package Bike;

import java.time.Duration;
import java.time.LocalTime;

public abstract class Bike {
    /** Id field used for the identification of the bike (number). */
    private int id;
    /** Total kilometres field. */
    private double km;
    private double totalKm;
    //rented field
    private boolean rented;
    //Time
    private LocalTime startTime;
    private LocalTime endTime;

    public Bike(int Id){
        setId(Id);
    }

    //ID
    private void setId(int Id){
        if(Id < 0){
            throw new IllegalArgumentException("Value cannot be smaller than 0 !");
        }
        this.id = Id;
    }

    public int getId(){
        return this.id;
    }

    //Kilometres
    public void setKm(double Km){
        if(Km < 0.0){
            throw new IllegalArgumentException("Value cannot be smaller than 0 !");
        }
        this.km += Km;
        this.totalKm += Km;
    }

    //Check time
    public void setStartTime(int hour, int minute){
        if(hour < 0 || minute < 0){
            throw new IllegalArgumentException("Hour or minutes cannot be lower than 0 !");
        }
        this.startTime = LocalTime.of(hour,minute);
    }

    public void setEndTime(int hour, int minute){
        if(hour < 0 || minute < 0){
            throw new IllegalArgumentException("Hour or minutes cannot be lower than 0 !");
        }
        this.endTime = LocalTime.of(hour,minute);
    }

    //For each hour 2 euros
    public long getHours(){
       Duration DurationHours = Duration.between(startTime, endTime);
       long hours = DurationHours.toHours();
       return hours;
    }


    public double getKm(){
        return this.km;
    }

    public void resetKm(){
        this.km = 0.0;
    }

    //Rental status
    public void setRented(boolean Rented){
        this.rented = Rented;
    }

    public boolean isRented(){
        return this.rented;
    }

    //Total distance
    public String getTotalDistance(){
        //double total = 0;
        //total += this.km;
        return "The bike " + this.id + " has travelled in total " + this.totalKm + " kilometres.";
    }

}
