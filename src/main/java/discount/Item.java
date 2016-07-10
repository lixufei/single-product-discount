package discount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item {

    private String barcode;
    private String name;
    private String unit;
    private String category;
    private String subCategory;
    private BigDecimal price;
    private String discountType = "";
    private String printDiscount = "";
    private List<DiscountItem> discountItems;
    private Map<String, String> discountInfo = new HashMap<>();

    public Item() {
        discountInfo.put("TWENTYPERCENT", "八折");
        discountInfo.put("TENPERCENT", "九折");
    }

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

    public List<DiscountItem> getDiscountItems() {
        return discountItems;
    }

    public Item setDiscountItems(List<DiscountItem> discountItems) {
        this.discountItems = discountItems;
        return this;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public Item setSubCategory(String subCategory) {
        this.subCategory = subCategory;
        return this;
    }

    public int getCount () {
        return  barcode.split("-").length == 2 ? Integer.parseInt(barcode.split("-")[1]) : 1;

    }

    public BigDecimal getUnitPrice () {
        return this.price;
    }
    public BigDecimal getPrice() {
        return price.multiply(BigDecimal.valueOf(this.getCount()));
    }

    public Item setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDiscountType (String barcode) {
        String pureBarcode = barcode.split("-")[0];
        for (DiscountItem discountItem : discountItems) {
            label:
            for (int i = 0; i < discountItem.getBarcodes().length; i++) {
                if (pureBarcode.equals(discountItem.getBarcodes()[i])){
                    discountType = discountItem.getType();
                    break label;
                }
            }
        }
        return discountType;
    }

    public BigDecimal getItemPrice() {
        BigDecimal discountPrice;
        BigDecimal originalPrice = getPrice();
        String discountType = getDiscountType(barcode);

        switch (discountType) {
            case "TENPERCENT":
                printDiscount = discountInfo.get("TENPERCENT");
                discountPrice = Discount.TENPERCENT.discountResult(originalPrice);
                break;
            case "TWENTYPERCENT":
                printDiscount = discountInfo.get("TWENTYPERCENT");
                discountPrice = Discount.TWENTYPERCENT.discountResult(originalPrice);
                break;
            default: discountPrice = getPrice();
        }
        return discountPrice;
    }

    private String formatPrice (BigDecimal price) {
        return new java.text.DecimalFormat("0.00").format(price);
    }

    public Boolean itemIsDiscount() {
        return this.getDiscountType (this.barcode)!= "";
    }

    public BigDecimal getSavedPrice() {
        return this.getPrice().subtract(getItemPrice());
    }

    @Override
    public String toString() {
        String printItem = "名称: " +
                this.name + ", " +
                "数量: " +
                this.getCount() +
                this.unit +  ", " +
                "单价: " +
                formatPrice(this.getUnitPrice()) +
                "(元), 小计: " +
                formatPrice(this.getItemPrice()) +
                "(元)";
        String discountString = ", 优惠" + formatPrice(this.getSavedPrice()) + "(元)";
        return itemIsDiscount() ? printItem + discountString : printItem;
    }

    public String printHowManyDiscount() {
        String howManyDiscount = "名称: " + this.name + ", 折扣: " + this.discountInfo.get(getDiscountType(this.barcode));
        return itemIsDiscount() ? howManyDiscount : "";
    }
}