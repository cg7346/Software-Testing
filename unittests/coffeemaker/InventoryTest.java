package coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

import coffeemaker.exceptions.*;

public class InventoryTest extends TestCase{
    private Inventory inv;

    @Before
	public void setUp() throws Exception {
        inv = new Inventory();
        super.setUp();
	}

	@After
	public void tearDown() throws Exception {
        inv = null;
        super.setUp();
	}

    @Test
    public void testgetChocolate() {
        assertEquals(inv.getChocolate(), 15);
    }

    @Test
    public void testsetChocolate() {
        inv.setChocolate(10);
        assertEquals(inv.getChocolate(), 10);
    }

    @Test
    public void testaddChocolate0() {
        try {
            inv.addChocolate("0");
        } catch (InventoryException ex) {
            fail("Should parse int");
        };
        assertEquals(inv.getChocolate(), 15);
    }

    @Test
    public void testaddChocolateInvalid() {
        try {
            inv.addChocolate("abc");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of chocolate must be a positive integer");
            return;
        };
        fail("Should not parse invalid input");
    }

    @Test
    public void testaddChocolateInvalidNeg() {
        try {
            inv.addChocolate("-10");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of chocolate must be a positive integer");
            return;
        };
        fail("Should not parse invalid input");
    }

    @Test
    public void testGetCoffee() {
        assertEquals(inv.getCoffee(), 15);
    }

    @Test
    public void testsetCoffee() {
        inv.setCoffee(10);
        assertEquals(inv.getCoffee(), 10);
    }

    @Test
    public void testaddCoffee0() {
        try {
            inv.addCoffee("0");
        } catch (InventoryException ex) {
            fail("Should parse int");
        };
        assertEquals(inv.getCoffee(), 15);
    }

    @Test
    public void testaddCoffeeInvalid() {
        try {
            inv.addCoffee("abc");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of coffee must be a positive integer");
            return;
        };
        fail("Should not parse invalid input");
    }

    @Test
    public void testaddCoffeeInvalidNeg() {
        try {
            inv.addCoffee("-10");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of coffee must be a positive integer");
            return;
        };
        fail("Should not parse invalid input");
    }
}
