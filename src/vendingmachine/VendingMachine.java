package vendingmachine;

import vendingmachine.inventory.item.Coin;
import vendingmachine.inventory.item.Product;
import vendingmachine.utility.Bucket;

import java.util.List;

public interface VendingMachine {

    int getPrice(Product product);
    void insertCoin(Coin coin);
    Bucket<Product, List<Coin>> collectProductAndChange();
    List<Coin> refund(int quantity, Product product);
    void reset();

}
