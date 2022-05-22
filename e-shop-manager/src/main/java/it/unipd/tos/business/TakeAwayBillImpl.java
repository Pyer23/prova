////////////////////////////////////////////////////////////////////
// [Marco] [Dello Iacovo] [1193421]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.time.LocalTime;
import java.util.List;

import it.unipd.tos.model.User;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.business.exception.TakeAwayBillException;

public class TakeAwayBillImpl implements TakeAwayBill {
    
    TakeAwayGiveawayImpl giveaway;
    
    public TakeAwayBillImpl() {
        giveaway = new TakeAwayGiveawayImpl();
    }

    public double getOrderPrice(List<MenuItem> itemsOrdered, User user, LocalTime orderTime) 
            throws TakeAwayBillException{
        double total = 0.0D;
        double budiniGelatiTotal = 0.0D;
        int countGelati = 0;
        double cheapestGelato = Double.MAX_VALUE;

        if(itemsOrdered == null) {
            throw new TakeAwayBillException("La lista itemsOrdered è uguale a null");
        }
        if(itemsOrdered.contains(null)) {
            throw new TakeAwayBillException("La lista itemsOrdered contiene un item uguale a null");
        }
        if(user == null) {
            throw new TakeAwayBillException("utente è uguale a null");
        }
        if(itemsOrdered.size() > 30) {
            throw new TakeAwayBillException("Ci sono più di 30 items nella lista itemsOrdered");
        }
        
        for(MenuItem item: itemsOrdered) {
            if(item.getItemType() == MenuItem.item.Gelato) {
                budiniGelatiTotal = budiniGelatiTotal + item.getPrice();
                countGelati = countGelati + 1;
                if(item.getPrice() < cheapestGelato) {
                    cheapestGelato = item.getPrice();
                }
            }
            if(item.getItemType() == MenuItem.item.Budino) {
                budiniGelatiTotal = budiniGelatiTotal + item.getPrice();
            }
            total = total + item.getPrice();
        }
        
        if(countGelati > 5) {
            total = total - (cheapestGelato / 2);
        }
        if(budiniGelatiTotal > 50) {
            total = total * 0.9;
        }
        if(total < 10) {
            total = total + 0.5;
        }
        if(giveaway.giveAwayOrder(user, orderTime)) {
            return 0;
        }
        
        return total;
    }

}