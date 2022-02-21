package sorted.collections;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            StockItem inStock = list.getOrDefault(item.getName(), item);
            if (inStock != item) {
                item.adjustStock(inStock.availableQuantity());
            }
            list.put(item.getName(), item);
            return item.availableQuantity();
        }
        return 0;
    }

    public int sellStock(String item, int count) {
        StockItem inStock = list.get(item);
        if (inStock != null && count > 0) {
            return inStock.finalizeStock(count);
        }
//        old sell stock code before challenge
//        StockItem inStock = list.getOrDefault(item, null);
//
//        if (inStock != null && inStock.availableQuantity() >= count && count > 0) {
//            inStock.adjustStock(-count);
//            return count;
//        }
//        System.out.println("There are no more " + item + "s in stock.");
        return 0;
    }

    public int reserveStock(String item, int count) {
        StockItem inStock = list.get(item);
        if (inStock != null && count > 0) {
            return inStock.reserveStock(count);
        }
        return 0;
    }

    public int unreserveStock(String item, int count) {
        StockItem inStock = list.get(item);
        if (inStock != null && count > 0) {
            return inStock.unReserveStock(count);
        }
        return 0;
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    @Override

    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();

            s = s + stockItem + ". There are " + stockItem.availableQuantity() + " in stock. Value of items: ";
            s = s + String.format("$%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total Stock Value " + String.format("$%.2f", totalCost);
    }
}
