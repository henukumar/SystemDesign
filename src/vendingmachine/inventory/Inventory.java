package vendingmachine.inventory;

public interface Inventory<T> {

    void addItem(T item);
    void deductItem(T item);

}
