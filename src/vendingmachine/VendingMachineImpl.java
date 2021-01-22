package vendingmachine;

import vendingmachine.inventory.Inventory;
import vendingmachine.inventory.InventoryImpl;
import vendingmachine.inventory.item.Coin;
import vendingmachine.inventory.item.Product;
import vendingmachine.utility.Bucket;

import java.util.List;

/*
* Reference:-
* https://javarevisited.blogspot.com/2016/06/design-vending-machine-in-java.html
* */
public class VendingMachineImpl implements VendingMachine {

    private Inventory<Coin> coinInventory = new InventoryImpl<>();
    private Inventory<Product> productInventory = new InventoryImpl<>();

    private Product currentItem;
    private int cashCollectedForCurrentItem;

    @Override
    public int getPrice(Product product) {
        return 0;
    }

    @Override
    public void insertCoin(Coin coin) {

    }

    @Override
    public Bucket<Product, List<Coin>> collectProductAndChange() {
        return null;
    }

    @Override
    public List<Coin> refund(int quantity, Product product) {
        return null;
    }

    @Override
    public void reset() {

    }

}
