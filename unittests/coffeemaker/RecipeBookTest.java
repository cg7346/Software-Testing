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
    public void testGetRecipes() {
        assertEquals(book.getRecipes().length, 4);
    }

    @Test
    public void testGetRecipesWrong() {
        Recipe[] recipes = new Recipe[5];
        assertNotEquals(book.getRecipes().length, recipes.length);
    }

    @Test
    public void testAddRecipeTrue() {
        assertTrue(book.addRecipe(r));
    }

    @Test
    public void testAddRecipeNew() {
        Recipe recipeNew = new Recipe();
        recipeNew.setName("milk");
        book.addRecipe(recipeNew);
        assertTrue(book.addRecipe(r));
    }

    @Test
    public void testAddRecipeSame() {
        r.setName("milk");
        Recipe milk = new Recipe();
        milk.setName("milk");
        book.addRecipe(milk);
        assertFalse(book.addRecipe(r));
    }

    @Test
    public void testAddRecipeFalseNoSpace() {
        Recipe r1 = new Recipe();
        r1.setName("sugar");
        Recipe r2 = new Recipe();
        r2.setName("milk");
        Recipe r3 = new Recipe();
        r3.setName("chocolate");
        Recipe r4 = new Recipe();
        r4.setName("coffee");
        book.addRecipe(r1);
        book.addRecipe(r2);
        book.addRecipe(r3);
        book.addRecipe(r4);
        assertFalse(book.addRecipe(r));
    }

    @Test
    public void testDeleteRecipeNull() throws RecipeException {
        book.addRecipe(r);
        assertNull(book.deleteRecipe(1));
    }

    @Test
    public void testDeleteRecipeEmpty() throws RecipeException {
        book.addRecipe(r);
        assertEquals(book.deleteRecipe(0), "");
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
