package discount;

import java.math.BigDecimal;

public class Item {

    private String barcode;
    private String name;
    private String unit;
    private String category;
    private String subCategory;
    private BigDecimal price;

    public String getBarcode() {
        return barcode;
    }

    public Item setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public Item setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Item setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public Item setSubCategory(String subCategory) {
        this.subCategory = subCategory;
        return this;
    }

    public BigDecimal getPrice() {
        int count = barcode.split("-").length == 2 ? Integer.parseInt(barcode.split("-")[1]) : 1;
        return price.multiply(BigDecimal.valueOf(count));
    }

    public Item setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

}
