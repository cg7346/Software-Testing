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
    public void testGetAmtChocolate(){
        assertEquals(r.getAmtChocolate(), 0);
    }

    @Test
    public void testSetAmtChocolate() throws RecipeException{
        r.setAmtChocolate("4");
        assertEquals(r.getAmtChocolate(), 4);
    }

    @Test
    public void testSetAmtChocolateString(){
        try{
            r.setAmtChocolate("fti");
        } catch (RecipeException e){
            assertEquals(e.getMessage(), "Units of chocolate must be a positive integer");
        }
    }

    @Test
    public void testSetAmtChocolateNegative(){
        try{
            r.setAmtChocolate("-3");
        } catch (RecipeException e){
            assertEquals(e.getMessage(), "Units of chocolate must be a positive integer");
        }
    }

    @Test
    public void testGetAmtCoffee(){
        assertEquals(r.getAmtCoffee(), 0);
    }

    @Test
    public void testSetAmtCoffee() throws RecipeException{
        r.setAmtCoffee("4");
        assertEquals(r.getAmtCoffee(), 4);
    }

    @Test
    public void testSetAmtCoffeeString(){
        try{
            r.setAmtCoffee("fti");
        } catch (RecipeException e){
            assertEquals(e.getMessage(), "Units of coffee must be a positive integer");
        }
    }

    @Test
    public void testSetAmtCoffeeNegative(){
        try{
            r.setAmtCoffee("-3");
        } catch (RecipeException e){
            assertEquals(e.getMessage(), "Units of coffee must be a positive integer");
        }
    }

    @Test
    public void testGetAmtMilk(){
        assertEquals(r.getAmtMilk(), 0);
    }

    @Test
    public void testSetAmtMilk() throws RecipeException{
        r.setAmtMilk("4");
        assertEquals(r.getAmtMilk(), 4);
    }

    @Test
    public void testSetAmtMilkString(){
        try{
            r.setAmtMilk("fti");
        } catch (RecipeException e){
            assertEquals(e.getMessage(), "Units of milk must be a positive integer");
        }
    }

    @Test
    public void testSetAmtMilkNegative(){
        try{
            r.setAmtMilk("-3");
        } catch (RecipeException e){
            assertEquals(e.getMessage(), "Units of milk must be a positive integer");
        }
    }

    @Test
    public void testGetAmtSugar(){
        assertEquals(r.getAmtSugar(), 0);
    }

    @Test
    public void testSetAmtSugar() throws RecipeException{
        r.setAmtSugar("4");
        assertEquals(r.getAmtSugar(), 4);
    }

    @Test
    public void testSetAmtSugarString(){
        try{
            r.setAmtSugar("fti");
        } catch (RecipeException e){
            assertEquals(e.getMessage(), "Units of sugar must be a positive integer");
        }
    }

    @Test
    public void testSetAmtSugarNegative(){
        try{
            r.setAmtSugar("-3");
        } catch (RecipeException e){
            assertEquals(e.getMessage(), "Units of sugar must be a positive integer");
        }
    }

    @Test
    public void testGetName(){
        assertEquals(r.getName(), "");
    }

    @Test
    public void testSetName(){
        r.setName("penjamin");
        assertEquals(r.getName(), "penjamin");
    }

    @Test
    public void testGetPrice(){
        assertEquals(r.getPrice(), 0);
    }

    @Test
    public void testSetPrice() throws RecipeException{
        r.setPrice("4");
        assertEquals(r.getPrice(), 4);
    }

    @Test
    public void testSetPriceString(){
        try{
            r.setPrice("fti");
        } catch (RecipeException e){
            assertEquals(e.getMessage(), "Price must be a positive integer");
        }
    }

    @Test
    public void testSetPriceNegative(){
        try{
            r.setPrice("-3");
        } catch (RecipeException e){
            assertEquals(e.getMessage(), "Price must be a positive integer");
        }
    }

    @Test
    public void testToString(){
        assertEquals(r.toString(), "");
    }

    @Test
    public void testHashCode() {
        String name = "penjamin";
        r.setName(name);
        int expected = 31 + name.hashCode();
        assertEquals(r.hashCode(), expected);
    }

    @Test
    public void testHashCodeNullName() {
        assertEquals(r.hashCode(), 31);
    }

    @Test
    public void testEqualsSelf() {
        assertTrue(r.equals(r));
    }

    @Test
    public void testEqualsNull() {
        assertFalse(r.equals(null));
    }

    @Test
    public void testEqualsDifferentClass() {
        assertFalse(r.equals(inv));
    }

    @Test //TODO make this cover lines 179-180 of Recipe
    public void testEqualsNotNullName() {

        Recipe other = new Recipe();
        other.setName("baker");
        assertFalse(r.equals(other));
    }

    @Test
    public void testEqualsDifferentName() {
        r.setName("penjamin");
        Recipe other = new Recipe();
        other.setName("baker");
        assertFalse(r.equals(other));
    }

    @Test
    public void testEquals() {
        r.setName("penjamin");
        Recipe other = new Recipe();
        other.setName("penjamin");
        assertTrue(r.equals(other));
    }
}
