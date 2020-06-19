package ch.appaka.commerce.warehouse.data.entity;

import javax.persistence.*;

@Entity
@Table(name="appaka_commerce_warehouse_stock")
@IdClass(StockCompositeKey.class)
public class Stock {
    @Id
    @Column(name="sku")
    private String sku;

    @Id
    @Column(name="warehouse")
    private String warehouse;

    @Column(name="quantity")
    private Integer quantity;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
