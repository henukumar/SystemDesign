package vendingmachine.utility;

import vendingmachine.inventory.item.Coin;
import vendingmachine.inventory.item.Product;

import java.util.List;

public class VendingMachineResponse {

    private Product product;
    private List<Coin> change;
    private String message;

    public VendingMachineResponse(Product product, List<Coin> change, String message) {
        this.product = product;
        this.change = change;
        this.message = message;
    }

    public Product getProduct() {
        return product;
    }

    public List<Coin> getChange() {
        return change;
    }

    public String getMessage() {
        return message;
    }

}
