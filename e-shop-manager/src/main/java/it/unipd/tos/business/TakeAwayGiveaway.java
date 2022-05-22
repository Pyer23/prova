////////////////////////////////////////////////////////////////////
// [Marco] [Dello Iacovo] [1193421]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.time.LocalTime;

import it.unipd.tos.model.User;

public interface TakeAwayGiveaway {

    boolean giveAwayOrder(User user, LocalTime orderTime);

}