////////////////////////////////////////////////////////////////////
// [Marco] [Dello Iacovo] [1193421]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MenuItemTest {

    MenuItem item;
    
    @Before
    public void initialize() {
        item = new MenuItem(MenuItem.item.Budino, "Pinguino", 5.10);
    }
    
    @Test
    public void testGetItemType() {
        assertEquals(MenuItem.item.Budino, item.getItemType());
    }

    @Test
    public void testGetName() {
        assertEquals("Pinguino", item.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(5.10, item.getPrice(), 1e-8);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativePrice() {
        new MenuItem(MenuItem.item.Budino, "Pinguino", -5.10);
    }

}
