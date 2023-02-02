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
}
