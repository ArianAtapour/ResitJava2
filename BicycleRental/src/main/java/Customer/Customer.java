/**
 * Customer package contains all classes related to customer.
 */
package Customer;

/**
 * Customer class
 * <p>
 * This class is used to set and get the customer's name.
 * </p>
 *
 * @author Arian Atapour
 * @version 1.0
 */
public class Customer {
    /**
     * Customer name field.
     */
    private String name;

    /**
     * Constructor which requires a String.
     *
     * @param Name name of the customer. Cannot be empty or blank.
     * @throws IllegalArgumentException if the name is empty or blank.
     */
    public Customer(String Name) {
        setName(Name);
    }

    /**
     * Setter for the customer name.
     *
     * @param Name name of the customer. Cannot be empty or blank.
     * @throws IllegalArgumentException if the name is empty or blank.
     */
    private void setName(String Name) {
        if (Name.isEmpty() || Name.isBlank()) {
            throw new IllegalArgumentException("Name has to be a string !");
        }
        this.name = Name;
    }

    /**
     * Getter for the customer name.
     *
     * @return the name of this customer.
     */
    public String getName() {
        return this.name;
    }
}
