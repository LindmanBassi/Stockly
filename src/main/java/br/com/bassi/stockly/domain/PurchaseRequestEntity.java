package br.com.bassi.stockly.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_purchase_request")
public class PurchaseRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "quantity_on_stock")
    private Integer quantityOnStock;

    @Column(name = "reorder_threshold")
    private Integer reorderThreshold;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "supplier_email")
    private String supplierEmail;

    @Column(name = "last_stock_update_time")
    private LocalDateTime lastStockUpdateTime;

    @Column(name = "purchase_quantity")
    private Integer purchaseQuantity;

    @Column(name = "purchased_with_success")
    private boolean purchasedWithSuccess;

    @Column(name = "purchase_date_time")
    private LocalDateTime purchaseDateTime;

    public PurchaseRequestEntity() {
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String  itemId) {
        this.itemId = itemId;
    }

    public LocalDateTime getPurchaseDateTime() {
        return purchaseDateTime;
    }

    public void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
        this.purchaseDateTime = purchaseDateTime;
    }

    public boolean isPurchasedWithSuccess() {
        return purchasedWithSuccess;
    }

    public void setPurchasedWithSuccess(boolean purchasedWithSuccess) {
        this.purchasedWithSuccess = purchasedWithSuccess;
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public LocalDateTime getLastStockUpdateTime() {
        return lastStockUpdateTime;
    }

    public void setLastStockUpdateTime(LocalDateTime lastStockUpdateTime) {
        this.lastStockUpdateTime = lastStockUpdateTime;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getReorderThreshold() {
        return reorderThreshold;
    }

    public void setReorderThreshold(Integer reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    public Integer getQuantityOnStock() {
        return quantityOnStock;
    }

    public void setQuantityOnStock(Integer quantityOnStock) {
        this.quantityOnStock = quantityOnStock;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
