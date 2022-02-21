package sorted.collections;

import java.util.Objects;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityInStock; // = 0;  can be initialized later and should be when using multiple constructors
    private int reserved;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0; // or here - do not do it in both
        this.reserved = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int availableQuantity() {
        return quantityInStock - reserved;
    }

    public void setPrice(double price) {
        if (price > 0.0) this.price = price;
    }

    public void adjustStock(int count) {
        int newStock = this.quantityInStock + count;
        if (newStock >= 0) this.quantityInStock = newStock;
    }

    public int reserveStock(int count) {
        if (this.availableQuantity() >= count) {
            this.reserved += count;
            return count;
        }
        return 0;
    }

    public int unReserveStock(int count) {
        if (this.reserved >= count) {
            this.reserved -= count;
            return count;
        }
        return 0;
    }

    public int finalizeStock(int count) {
        if (count <= reserved) {
            quantityInStock -= count;
            reserved -= count;
            return count;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockItem stockItem = (StockItem) o;
        return getName().equals(stockItem.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), 31);
    }

    @Override
    public int compareTo(StockItem o) {
        if (this == o) return 0;
        if (o != null) return this.name.compareTo(o.getName());
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return name + " : price " + String.format("$%.2f", price) + " reserved: " + reserved;
    }
}
