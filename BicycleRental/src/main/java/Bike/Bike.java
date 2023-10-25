package Bike;

//Dont forget about the ENUM thingy

public class Bike {
    //id field
    private int id;
    //km field
    private double km;
    //rented field
    private boolean rented;

    public Bike(int Id){

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
    private String getTotalDistance(){
        double total = 0;
        total += this.km;
        return "The bike " + this.id + "has travelled in total " + total + " kilometres.";
    }

}
