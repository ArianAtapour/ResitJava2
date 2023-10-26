package Customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    private final Customer customer = new Customer("John Doe");

    //Check if it gets the name
    @Test
    void checkName(){
        assertEquals("John Doe", customer.getName(), "Expected string was John Doe");
    }
}
