package vendingmachine.inventory.item;

import vendingmachine.inventory.item.InventoryItem;

public enum Product implements InventoryItem {

    PEPSI("Pepsi", 15),
    COCA_COLA("Coca Cola", 10),
    SODA("Soda", 5),
    EMPTY("Sold out", 0),
    ;

    private String name;
    private int price;

    Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
