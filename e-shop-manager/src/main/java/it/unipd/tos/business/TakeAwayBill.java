////////////////////////////////////////////////////////////////////
// [Marco] [Dello Iacovo] [1193421]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.time.LocalTime;
import java.util.List;
import it.unipd.tos.model.User;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.business.exception.TakeAwayBillException;

public interface TakeAwayBill {

    double getOrderPrice(List<MenuItem> itemsOrdered, User user, LocalTime orderTime) throws TakeAwayBillException;

}
