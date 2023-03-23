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
        assertEquals(book.getRecipes().length, 4);
   }

    @Test
    public void testAddRecipeTrue() {
        assertTrue(book.addRecipe(r));
    }

    @Test
    public void testAddRecipeDupe() {
        book.addRecipe(r);
        assertFalse(book.addRecipe(r));
    }

    @Test
    public void testAddRecipeFalse() {
        book.addRecipe(r);
        r.setName("Recipe 1");
        book.addRecipe(r);
        r.setName("Recipe 2");
        book.addRecipe(r);
        r.setName("Recipe 3");
        book.addRecipe(r);
        r.setName("Recipe 4");
        assertFalse(book.addRecipe(r));
    }

    @Test
    public void testAddRecipeValue() {
        book.addRecipe(r);
        assertEquals(book.getRecipes()[0], r);
    }

    @Test
    public void testDeleteRecipeNull() throws RecipeException {
        assertNull(book.deleteRecipe(1));
    }

    @Test
    public void testDeleteRecipeString() throws RecipeException {
        r.setName("milk");
        book.addRecipe(r);
        assertEquals(book.deleteRecipe(0), "milk");
    }

    @Test
    public void testDeleteRecipeDeleted() throws RecipeException {
        r.setName("milk");
        book.addRecipe(r);
        book.deleteRecipe(0);
        assertEquals(book.getRecipes()[0], new Recipe());
    }

    @Test
    public void testDeleteRecipeOutOfRange() throws RecipeException {
        book.addRecipe(r);
        assertNull(book.deleteRecipe(10));
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

    @Test
    public void testEditRecipeEdited() {
        r.setName("milk");
        book.addRecipe(r);
        Recipe newR = new Recipe();
        newR.setName("not milk");
        book.editRecipe(0, newR);
        assertEquals(book.getRecipes()[0], newR);
    }

    @Test
    public void testEditRecipeNotEdited() {
        Recipe newR = new Recipe();
        newR.setName("sugar");
        book.editRecipe(0, newR);
        assertNull(book.getRecipes()[0]);
    }
}
