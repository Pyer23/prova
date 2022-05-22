package it.unipd.tos.business;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import it.unipd.tos.model.User;

public class TakeAwayGiveawayTest {

    User user;
    TakeAwayGiveawayImpl giveaway;
    
    @Before
    public void initialize() {
        user = new User("Marco", "Dello Iacovo", LocalDate.of(2010, 1, 1), "marco.delloiacovo99@gmail.com", "3201234567");
        giveaway = new TakeAwayGiveawayImpl(); 
    }
    
    @Test
    public void testEligibleOrder() {
        assertEquals(true, giveaway.isOrderEligible(user, LocalTime.of(18, 30)));
    }
    
    @Test
    public void testUserOver18Eligibility() {
        user = new User("Marco", "Dello Iacovo", LocalDate.of(1999, 1, 1), "marco.delloiacovo99@gmail.com", "3201234567");
        assertEquals(false, giveaway.isOrderEligible(user, LocalTime.of(18, 30)));
    }
    
    @Test
    public void testWrongTimeframeEligibility() {
        assertEquals(false, giveaway.isOrderEligible(user, LocalTime.of(15, 30)));
    }
    
    @Test
    public void testUserAlreadySelectedEligibility() {
        giveaway.selectedUsers.add(user);
        assertEquals(false, giveaway.isOrderEligible(user, LocalTime.of(18, 30)));
    }
    
    @Test
    public void testMoreThan10UsersSelectedEligibility() {
        for(int i=1; i<10; i++) {
            user = new User("Marco", "Dello Iacovo", LocalDate.of(1999, 1, i), "marco.delloiacovo99@gmail.com", "3201234567");
            giveaway.selectedUsers.add(user);
        }
        user = new User("Marco", "Dello Iacovo", LocalDate.of(1999, 1, 30), "marco.delloiacovo99@gmail.com", "3201234567");
        assertEquals(false, giveaway.isOrderEligible(user, LocalTime.of(18, 30)));
    }
    
    @Test
    public void testNullUser() {
        user = null;
        try {
            giveaway.giveAwayOrder(null, LocalTime.of(18, 30));
        }catch(IllegalArgumentException e) {
            assertEquals("user è null", e.getMessage());
        }
    }
    
    @Test
    public void testNullOrderTime() {
        try {
            giveaway.giveAwayOrder(user, null);
        }catch(IllegalArgumentException e) {
            assertEquals("orderTime è null", e.getMessage());
        }
    }
}
