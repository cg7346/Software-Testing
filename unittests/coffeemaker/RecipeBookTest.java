package coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

import coffeemaker.exceptions.*;

import java.lang.reflect.Array;

public class RecipeBookTest extends TestCase {
    private RecipeBook book;
    private Recipe r;

    @Before
    public void setUp() throws Exception {
        book = new RecipeBook();
        r = new Recipe();
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        book = null;
        r = null;
        super.setUp();
    }

    @Test
    public void testGetRecipes() throws RecipeException {
   }

    @Test
    public void testAddRecipeTrue() {
        assertTrue(book.addRecipe(r));
    }

    @Test
    public void testAddRecipeFalse() {
        book.addRecipe(r);
        book.addRecipe(r);
        book.addRecipe(r);
        book.addRecipe(r);
        assertFalse(book.addRecipe(r));
    }

    @Test
    public void testDeleteRecipeNull() throws RecipeException {
        r.setName("milk");
        book.addRecipe(r);
        assertNull(book.deleteRecipe(1));
    }

    @Test
    public void testDeleteRecipeString() throws RecipeException {
        r.setName("milk");
        book.addRecipe(r);
        assertEquals(book.deleteRecipe(0), "milk");
    }

    @Test
    public void testEditRecipeString() {
        r.setName("milk");
        book.addRecipe(r);
        Recipe newR = new Recipe();
        newR.setName("sugar");
        assertEquals(book.editRecipe(0, newR), "sugar");

    }

    @Test
    public void testEditRecipeEmpty() {
        r.setName("milk");
        book.addRecipe(r);
        Recipe newR = new Recipe();
        newR.setName("");
        assertEquals(book.editRecipe(0, newR), "");
    }

    @Test
    public void testEditRecipeNull() {
        r.setName("milk");
        book.addRecipe(r);
        Recipe newR = new Recipe();
        newR.setName("sugar");
        assertNull(book.editRecipe(1, newR));
    }
}
