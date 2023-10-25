package Customer;

public class Customer {
    //name field
    private String name;

    //Constructor
    public Customer(String Name){
        setName(Name);
    }

    //Name
    private void setName(String Name){
        if(Name.isEmpty() || Name.isBlank()){
            throw new IllegalArgumentException("Name has to be a string !");
        }
        this.name = Name;
    }

    public String getName(){
        return this.name;
    }
}
