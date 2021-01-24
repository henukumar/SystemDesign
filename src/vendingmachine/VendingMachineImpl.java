package vendingmachine;

import vendingmachine.exception.NotFullPaidException;
import vendingmachine.exception.NotSufficientChangeException;
import vendingmachine.exception.SoldOutException;
import vendingmachine.inventory.Inventory;
import vendingmachine.inventory.InventoryImpl;
import vendingmachine.inventory.item.Coin;
import vendingmachine.inventory.item.Product;
import vendingmachine.utility.VendingMachineResponse;

import java.util.ArrayList;
import java.util.Collections;
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

    /*
    * When user select a product
    * */
    @Override
    public int selectItemAndGetPrice(Product product) throws SoldOutException {
        this.currentItem = product;
        if(productInventory.hasItem(currentItem)){
            return currentItem.getPrice();
        }
        throw new SoldOutException();
    }

    /*
    * every time user inserts a coin
    * */
    @Override
    public void insertCoin(Coin coin) {
        cashCollectedForCurrentItem += coin.getDenomination();
        coinInventory.addItem(coin);
    }

    /*
    * when user press collect button
    * */
    @Override
    public VendingMachineResponse collectProductAndChange() throws NotSufficientChangeException, NotFullPaidException {
        if(cashCollectedForCurrentItem >= currentItem.getPrice()){
            if(hasSufficientChange()){
                productInventory.deductItem(currentItem);
                return new VendingMachineResponse(currentItem, getChange(), "Thanks for the shopping");
            }else {
                throw new NotSufficientChangeException();
            }
        }
        throw new NotFullPaidException();
    }

    @Override
    public void reset() {
        productInventory.clear();
        coinInventory.clear();
        currentItem = null;
    }

    private boolean hasSufficientChange(){
        try{
            getChange();
        }catch (NotSufficientChangeException e){
            return false;
        }
        return true;
    }

    private List<Coin> getChange() throws NotSufficientChangeException {
        List<Coin> changes = Collections.emptyList();
        int amount = cashCollectedForCurrentItem;
        if (amount > 0) {
            long balance = amount;
            changes = new ArrayList<>();
            while(balance > 0){
                if(balance >= Coin.QUARTER.getDenomination() && coinInventory.hasItem(Coin.QUARTER)){
                    changes.add(Coin.QUARTER);
                    balance = balance - Coin.QUARTER.getDenomination();
                }else if(balance >= Coin.DIME.getDenomination() && coinInventory.hasItem(Coin.DIME)){
                    changes.add(Coin.DIME);
                    balance = balance - Coin.DIME.getDenomination();
                }else if(balance >= Coin.NICKLE.getDenomination() && coinInventory.hasItem(Coin.NICKLE)){
                    changes.add(Coin.NICKLE);
                    balance = balance - Coin.NICKLE.getDenomination();
                }else if(balance >= Coin.PENNY.getDenomination() && coinInventory.hasItem(Coin.PENNY)){
                    changes.add(Coin.PENNY);
                    balance = balance - Coin.PENNY.getDenomination();
                }else{
                    throw new NotSufficientChangeException();
                }
            }
        }
        return changes;
    }

}
