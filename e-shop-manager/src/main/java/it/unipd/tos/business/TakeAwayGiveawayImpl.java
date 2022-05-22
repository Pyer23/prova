////////////////////////////////////////////////////////////////////
// [Marco] [Dello Iacovo] [1193421]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unipd.tos.model.User;

public class TakeAwayGiveawayImpl implements TakeAwayGiveaway {

    List<User> selectedUsers;
    Random r;
    
    public TakeAwayGiveawayImpl() {
        selectedUsers = new ArrayList<User>();
        r = new Random();
    }
    
    public boolean isOrderEligible(User user, LocalTime orderTime){
        if(user.getDateOfBirth() != null && Period.between(user.getDateOfBirth(), LocalDate.now()).getYears() < 18) {
            if(selectedUsers.size() < 10 && !selectedUsers.contains(user)){
                if(orderTime.getHour() == 18 || orderTime.getHour() == 19) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean giveAwayOrder(User user, LocalTime orderTime) {
        if(user == null) {
            throw new IllegalArgumentException("user è null");
        }
        if(orderTime == null) {
            throw new IllegalArgumentException("orderTime è null");
        }
        if(isOrderEligible(user, orderTime)) {
            if (r.nextInt(100) < 30) {
                selectedUsers.add(user);
                return true;
            }
        }
        return false;
    }
}