////////////////////////////////////////////////////////////////////
// [Marco] [Dello Iacovo] [1193421]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
    
    User user;

    @Before
    public void initialize() {
        user = new User("Marco", "Dello Iacovo", LocalDate.of(1999, 1, 1), "marco.delloiacovo99@gmail.com", "3201234567");
    }
    
    @Test
    public void testGetName() {
        assertEquals("Marco", user.getName());
    }

    @Test
    public void testGetSurname() {
        assertEquals("Dello Iacovo", user.getSurname());
    }

    @Test
    public void testGetEmail() {
        assertEquals("marco.delloiacovo99@gmail.com", user.getEmail());
    }

    @Test
    public void testGetDateOfBirth() {
        assertEquals(LocalDate.of(1999, 1, 1), user.getDateOfBirth());
    }
    
    @Test
    public void testIllegalDateOfBirth() {
        try {
            new User("Marco", "Dello Iacovo", LocalDate.now().plusDays(10), "marco.delloiacovo99@gmail.com", "3201234567");
        }catch (IllegalArgumentException e) {
            assertEquals("La data di nascita deve essere precedente alla data odierna", e.getMessage());
        }
}
    
    @Test
    public void testNullDateOfBirth() {
        try {
            new User("Marco", "Dello Iacovo", null, "marco.delloiacovo99@gmail.com", "3201234567");
        }catch(IllegalArgumentException e) {
            assertEquals("La data di nascita è null", e.getMessage());
        }
        
    }

}
