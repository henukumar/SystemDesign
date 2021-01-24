package vendingmachine;

import vendingmachine.exception.NotFullPaidException;
import vendingmachine.exception.NotSufficientChangeException;
import vendingmachine.exception.SoldOutException;
import vendingmachine.inventory.item.Coin;
import vendingmachine.inventory.item.Product;
import vendingmachine.utility.VendingMachineResponse;

public interface VendingMachine {

    int selectItemAndGetPrice(Product product) throws SoldOutException;
    void insertCoin(Coin coin);
    VendingMachineResponse collectProductAndChange() throws NotSufficientChangeException, NotFullPaidException;
    void reset();

}
