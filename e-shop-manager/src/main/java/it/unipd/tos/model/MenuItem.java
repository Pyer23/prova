////////////////////////////////////////////////////////////////////
// [Marco] [Dello Iacovo] [1193421]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {

    public enum item {Gelato, Budino, Bevanda};

    private item itemType;
    private String name;
    private double price;

    public MenuItem(item _itemType, String _name, double _price){
        this.itemType  = _itemType;
        this.name      = _name;
        if(_price >= 0.0D) {
            this.price     = _price;
        }else {
            throw new IllegalArgumentException("Il prezzo deve essere >= 0");
        }
        
    }

    public item getItemType(){
        return itemType;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    
}