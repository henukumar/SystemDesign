package vendingmachine.inventory;

import vendingmachine.inventory.item.InventoryItem;

import java.util.HashMap;
import java.util.Map;

public class InventoryImpl<T extends InventoryItem> implements Inventory<T> {

    private Map<InventoryItem, Integer> inventory = new HashMap<>();

    @Override
    public void addItem(InventoryItem item) {
        if(inventory.containsKey(item)){
            inventory.put(item, inventory.get(item)+1);
        }else {
            inventory.put(item, 1);
        }
    }

    @Override
    public void deductItem(InventoryItem item){
        if(inventory.get(item) > 0){
            inventory.put(item, inventory.get(item)-1);
        }
    }

    @Override
    public boolean hasItem(T item) {
        return inventory.containsKey(item);
    }

    @Override
    public int getQuantity(T item) {
        return inventory.getOrDefault(item, 0);
    }

    @Override
    public void clear() {
        inventory.clear();
    }

}
