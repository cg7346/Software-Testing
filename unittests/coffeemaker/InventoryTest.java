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

    @Test
    public void testGetSugar() {
        assertEquals(inv.getSugar(), 15);
    }

    @Test
    public void testsetSugar() {
        inv.setSugar(10);
        assertEquals(inv.getSugar(), 10);
    }

    @Test
    public void testaddSugar0() {
        try {
            inv.addSugar("0");
        } catch (InventoryException ex) {
            fail("Should parse int");
        };
        assertEquals(inv.getSugar(), 15);
    }

    @Test
    public void testaddSugarInvalid() {
        try {
            inv.addSugar("abc");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of sugar must be a positive integer");
            return;
        };
        fail("Should not parse invalid input");
    }

    @Test
    public void testaddSugarInvalidNeg() {
        try {
            inv.addSugar("-10");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of sugar must be a positive integer");
            return;
        };
        fail("Should not parse invalid input");
    }

    @Test
    public void testGetMilk() {
        assertEquals(inv.getMilk(), 15);
    }

    @Test
    public void testsetMilk() {
        inv.setMilk(10);
        assertEquals(inv.getMilk(), 10);
    }

    @Test
    public void testaddMilk0() {
        try {
            inv.addMilk("0");
        } catch (InventoryException ex) {
            fail("Should parse int");
        };
        assertEquals(inv.getMilk(), 15);
    }

    @Test
    public void testaddMilkInvalid() {
        try {
            inv.addMilk("abc");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of milk must be a positive integer");
            return;
        };
        fail("Should not parse invalid input");
    }

    @Test
    public void testaddMilkInvalidNeg() {
        try {
            inv.addMilk("-10");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of milk must be a positive integer");
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

    @Test
    public void testenoughIngredientsCoffeeNo() {
        try {
            r.setAmtCoffee("16");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertFalse(inv.enoughIngredients(r));
    }

    @Test
    public void testenoughIngredientsSugarNo() {
        try {
            r.setAmtSugar("16");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertFalse(inv.enoughIngredients(r));
    }

    @Test
    public void testenoughIngredientsMilkNo() {
        try {
            r.setAmtMilk("16");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertFalse(inv.enoughIngredients(r));
    }

    @Test
    public void testuseIngredientsPass() {
        assertTrue(inv.useIngredients(r));
    }

    @Test
    public void testuseIngredientsFail() {
        try {
            r.setAmtCoffee("20");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertFalse(inv.useIngredients(r));
    }

    @Test
    public void testuseIngredientsCoffeeAmt() {
        try {
            r.setAmtCoffee("5");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        inv.useIngredients(r);
        assertEquals(inv.getCoffee(), 10);
    }

    @Test
    public void testuseIngredientsMilkAmt() {
        try {
            r.setAmtMilk("5");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        inv.useIngredients(r);
        assertEquals(inv.getMilk(), 10);
    }

    @Test
    public void testuseIngredientsSugarAmt() {
        try {
            r.setAmtSugar("5");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        inv.useIngredients(r);
        assertEquals(inv.getSugar(), 10);
    }

    @Test
    public void testuseIngredientsChocolateAmt() {
        try {
            r.setAmtChocolate("5");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        inv.useIngredients(r);
        assertEquals(inv.getChocolate(), 10);
    }

    @Test
    public void testtoString() {
        assertEquals(inv.toString(), "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n");
    }
}
