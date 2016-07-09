package discount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Item {

    private String barcode;
    private String name;
    private String unit;
    private String category;
    private String subCategory;
    private BigDecimal price;
    private String discountType = "";
    private List<DiscountItem> discountItems;

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

    public BigDecimal getItemPrice(String barcode) {
        BigDecimal discountPrice;
        BigDecimal originalPrice = getPrice();
        String discountType = getDiscountType(barcode);

        switch (discountType) {
            case "TENPERCENT":
                discountPrice = Discount.TENPERCENT.discountResult(originalPrice);
                break;
            case "TWENTYPERCENT":
                discountPrice = Discount.TWENTYPERCENT.discountResult(originalPrice);
                break;
            default: discountPrice = getPrice();
        }
        return discountPrice;
    }

    private String formatPrice (BigDecimal price) {
        return new java.text.DecimalFormat("#.00").format(price);
    }

    public Boolean itemIsDiscount() {
        return this.getDiscountType (this.barcode)!= "";
    }

    public BigDecimal getSavedPrice() {
        return this.getPrice().subtract(getItemPrice(this.barcode));
    }

    @Override
    public String toString() {
        System.out.println("item is discount:"+itemIsDiscount());
        System.out.println("item is printing...:"+itemIsDiscount());
        String printItem = "名称: " +
                this.name + ", " +
                "数量: " +
                this.getCount() +
                this.unit +  ", " +
                "单价: " +
                formatPrice(this.getUnitPrice()) +
                "(元), 小计: " +
                formatPrice(this.getPrice()) +
                "(元)";
        String discountString = ", 优惠" + getSavedPrice() + "(元)";
        return itemIsDiscount() ? printItem + discountString : printItem;
    }
}