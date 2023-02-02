package coffeemaker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coffeemaker.exceptions.RecipeException;
import junit.framework.TestCase;

public class RecipeTest extends TestCase {
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
