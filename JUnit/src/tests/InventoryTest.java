package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

import coffeemaker.*;
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
    public void testGetChocolate() {
        assertEquals(inv.getChocolate(), 15);
    }

    @Test
    public void testSetChocolate() {
        inv.setChocolate(10);
        assertEquals(inv.getChocolate(), 10);
    }

    @Test
    public void testSetChocolateNeg() {
        inv.setChocolate(-10);
        assertEquals(inv.getChocolate(), 15);
    }

    @Test
    public void testAddChocolate0() {
        try {
            inv.addChocolate("0");
        } catch (InventoryException ex) {
            fail("Should parse int");
        };
        assertEquals(inv.getChocolate(), 15);
    }

    @Test
    public void testAddChocolate5() {
        try {
            inv.addChocolate("5");
        } catch (InventoryException ex) {
            fail("Should parse int");
        };
        assertEquals(inv.getChocolate(), 20);
    }

    @Test
    public void testAddChocolateInvalid() {
        try {
            inv.addChocolate("abc");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of chocolate must be a positive integer");
            return;
        };
        fail("Should not parse invalid input");
    }

    @Test
    public void testAddChocolateInvalidNeg() {
        try {
            inv.addChocolate("-10");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of chocolate must be a positive integer");
            return;
        };
        fail("Should not parse invalid input");
    }

    @Test
    public void testAddChocolate0Dec() {
        try {
            inv.addChocolate("0.0");
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
    public void testSetCoffee() {
        inv.setCoffee(10);
        assertEquals(inv.getCoffee(), 10);
    }

    @Test
    public void testSetCoffeeNeg() {
        inv.setCoffee(-10);
        assertEquals(inv.getCoffee(), 15);
    }

    @Test
    public void testAddCoffee0() {
        try {
            inv.addCoffee("0");
        } catch (InventoryException ex) {
            fail("Should parse int");
        };
        assertEquals(inv.getCoffee(), 15);
    }

    @Test
    public void testAddCoffee5() {
        try {
            inv.addCoffee("5");
        } catch (InventoryException ex) {
            fail("Should parse int");
        };
        assertEquals(inv.getCoffee(), 20);
    }

    @Test
    public void testAddCoffeeInvalid() {
        try {
            inv.addCoffee("abc");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of coffee must be a positive integer");
            return;
        };
        fail("Should not parse invalid input");
    }

    @Test
    public void testAddCoffeeInvalidNeg() {
        try {
            inv.addCoffee("-10");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of coffee must be a positive integer");
            return;
        };
        fail("Should not parse invalid input");
    }

    @Test
    public void testAddCoffee0Dec() {
        try {
            inv.addCoffee("0.0");
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
    public void testSetSugar() {
        inv.setSugar(10);
        assertEquals(inv.getSugar(), 10);
    }

    @Test
    public void testSetSugarNeg() {
        inv.setSugar(-10);
        assertEquals(inv.getSugar(), 15);
    }

    @Test
    public void testAddSugar0() {
        try {
            inv.addSugar("0");
        } catch (InventoryException ex) {
            fail("Should parse int");
        };
        assertEquals(inv.getSugar(), 15);
    }

        @Test
    public void testAddSugar5() {
        try {
            inv.addSugar("5");
        } catch (InventoryException ex) {
            fail("Should parse int");
        };
        assertEquals(inv.getSugar(), 20);
    }

    @Test
    public void testAddSugarInvalid() {
        try {
            inv.addSugar("abc");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of sugar must be a positive integer");
            return;
        };
        fail("Should not parse invalid input");
    }

    @Test
    public void testAddSugarInvalidNeg() {
        try {
            inv.addSugar("-10");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of sugar must be a positive integer");
            return;
        };
        fail("Should not parse invalid input");
    }

    @Test
    public void testAddSugar0Dec() {
        try {
            inv.addSugar("0.0");
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
    public void testSetMilk() {
        inv.setMilk(10);
        assertEquals(inv.getMilk(), 10);
    }

    @Test
    public void testSetMilkNeg() {
        inv.setMilk(-10);
        assertEquals(inv.getMilk(), 15);
    }

    @Test
    public void testAddMilk0() {
        try {
            inv.addMilk("0");
        } catch (InventoryException ex) {
            fail("Should parse int");
        };
        assertEquals(inv.getMilk(), 15);
    }

    @Test
    public void testAddMilk5() {
        try {
            inv.addMilk("5");
        } catch (InventoryException ex) {
            fail("Should parse int");
        };
        assertEquals(inv.getMilk(), 20);
    }

    @Test
    public void testAddMilk0Dec() {
        try {
            inv.addMilk("0.0");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of milk must be a positive integer");
            return;
        };
        fail("Should not parse invalid input");
    }

    @Test
    public void testAddMilkInvalid() {
        try {
            inv.addMilk("abc");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of milk must be a positive integer");
            return;
        };
        fail("Should not parse invalid input");
    }

    @Test
    public void testAddMilkInvalidNeg() {
        try {
            inv.addMilk("-10");
        } catch (InventoryException ex) {
            assertEquals(ex.getMessage(), "Units of milk must be a positive integer");
            return;
        };
        fail("Should not parse invalid input");
    }

    @Test
    public void testEnoughIngredientsYes() {
        assertTrue(inv.enoughIngredients(r));
    }

    @Test
    public void testEnoughIngredientsChocolateYes() {
        try {
            r.setAmtChocolate("15");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertTrue(inv.enoughIngredients(r));
    }

    @Test
    public void testEnoughIngredientsCoffeeYes() {
        try {
            r.setAmtCoffee("15");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertTrue(inv.enoughIngredients(r));
    }

    @Test
    public void testEnoughIngredientsSugarYes() {
        try {
            r.setAmtSugar("15");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertTrue(inv.enoughIngredients(r));
    }

    @Test
    public void testEnoughIngredientsMilkYes() {
        try {
            r.setAmtMilk("15");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertTrue(inv.enoughIngredients(r));
    }

    @Test
    public void testEnoughIngredientsChocolateNo() {
        try {
            r.setAmtChocolate("16");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertFalse(inv.enoughIngredients(r));
    }

    @Test
    public void testEnoughIngredientsCoffeeNo() {
        try {
            r.setAmtCoffee("16");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertFalse(inv.enoughIngredients(r));
    }

    @Test
    public void testEnoughIngredientsSugarNo() {
        try {
            r.setAmtSugar("16");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertFalse(inv.enoughIngredients(r));
    }

    @Test
    public void testEnoughIngredientsMilkNo() {
        try {
            r.setAmtMilk("16");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertFalse(inv.enoughIngredients(r));
    }

    @Test
    public void testUseIngredientsPass() {
        assertTrue(inv.useIngredients(r));
    }

    @Test
    public void testUseIngredientsFail() {
        try {
            r.setAmtCoffee("20");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertFalse(inv.useIngredients(r));
    }

    @Test
    public void testUseIngredientsCoffeeAmt() {
        try {
            r.setAmtCoffee("5");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        inv.useIngredients(r);
        assertEquals(inv.getCoffee(), 10);
    }

    @Test
    public void testUseIngredientsMilkAmt() {
        try {
            r.setAmtMilk("5");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        inv.useIngredients(r);
        assertEquals(inv.getMilk(), 10);
    }

    @Test
    public void testUseIngredientsSugarAmt() {
        try {
            r.setAmtSugar("5");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        inv.useIngredients(r);
        assertEquals(inv.getSugar(), 10);
    }

    @Test
    public void testUseIngredientsChocolateAmt() {
        try {
            r.setAmtChocolate("5");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        inv.useIngredients(r);
        assertEquals(inv.getChocolate(), 10);
    }

    @Test
    public void testUseIngredientsCoffeePass() {
        try {
            r.setAmtCoffee("5");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertTrue(inv.useIngredients(r));
    }

    @Test
    public void testUseIngredientsMilkPass() {
        try {
            r.setAmtMilk("5");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertTrue(inv.useIngredients(r));
    }

    @Test
    public void testUseIngredientsSugarPass() {
        try {
            r.setAmtSugar("5");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertTrue(inv.useIngredients(r));
    }

    @Test
    public void testUseIngredientsChocolatePass() {
        try {
            r.setAmtChocolate("5");
        } catch (RecipeException ex) {
            fail("Should parse int");
        };
        assertTrue(inv.useIngredients(r));
    }

    @Test
    public void testToString() {
        assertEquals(inv.toString(), "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n");
    }
}
