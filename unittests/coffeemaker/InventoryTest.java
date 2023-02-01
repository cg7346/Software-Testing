package coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

import coffeemaker.exceptions.*;

public class InventoryTest extends TestCase{
    private Inventory inv;
    private Recipe r;

    @Before
	public void setUp() throws Exception {
        inv = new Inventory();
        r = new Recipe();
        super.setUp();
	}

	@After
	public void tearDown() throws Exception {
        inv = null;
        r = null;
        super.setUp();
	}

    @Test
    public void testgetChocolate() {
        assertEquals(inv.getChocolate(), 15);
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
    public void testenoughIngredientsYes() {
        try {
            r.setAmtChocolate("15");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertTrue(inv.enoughIngredients(r));
    }

    @Test
    public void testenoughIngredientsChocolateNo() {
        try {
            r.setAmtChocolate("16");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertFalse(inv.enoughIngredients(r));
    }


}
