package questions.vendingMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class InventoryManager {
    private Map<Product, Integer> inventory;
    InventoryManager() {
        this.inventory = new ConcurrentHashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        inventory.compute(product,(k,v)->{
            if(v==null) return quantity;
            return v+quantity;
        });
    }

    public boolean checkAvailability(Product product, int quantity) {
        return inventory.getOrDefault(product, 0) >= quantity;
    }

    public boolean reduceQuantity(Product product, int quantity) {
        AtomicBoolean reduced = new AtomicBoolean(false);

        inventory.compute(product, (k, v) -> {
            if (v == null || v < quantity) {
                return v;
            }
            reduced.set(true);
            return v - quantity;
        });

        return reduced.get();
    }
}
