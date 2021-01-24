package vendingmachine.inventory;

public interface Inventory<T> {

    void addItem(T item);
    void deductItem(T item);
    boolean hasItem(T item);
    int getQuantity(T item);
    void clear();

}
