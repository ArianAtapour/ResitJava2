package Bike;

//Dont forget about the ENUM thingy

import java.time.Duration;
import java.time.LocalTime;

public abstract class Bike {
    //id field
    private int id;
    //km field
    private double km;
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
    private void setKm(double Km){
        if(Km < 0.0){
            throw new IllegalArgumentException("Value cannot be smaller than 0 !");
        }
        this.km = Km;
    }

    //Check time
    private void setStartTime(int hour, int minute){
        if(hour < 0 || minute < 0){
            throw new IllegalArgumentException("Hour or minutes cannot be lower than 0 !");
        }
        this.startTime = LocalTime.of(hour,minute);
    }

    private void setEndTime(int hour, int minute){
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

    //Rental status
    public void setRented(boolean Rented){
        this.rented = Rented;
    }

    public boolean isRented(){
        return this.rented;
    }

    //Total distance
    public String getTotalDistance(){
        double total = 0;
        total += this.km;
        return "The bike " + this.id + "has travelled in total " + total + " kilometres.";
    }

}
