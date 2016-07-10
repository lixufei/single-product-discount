package util;

import discount.Item;

import java.math.BigDecimal;
import java.util.List;

public class Sum {

    private BigDecimal sum = BigDecimal.ZERO;
    private BigDecimal discountSum = BigDecimal.ZERO;
    private List<Item> items;

    public Sum (List<Item> items) {
        BigDecimal newSum = BigDecimal.ZERO;
        BigDecimal newDiscountSum = BigDecimal.ZERO;
        for (Item item : items) {
            newDiscountSum = newDiscountSum.add(item.getItemPrice());
            newSum = newSum.add(item.getPrice());
        }

        this.sum = newSum;
        this.discountSum = newDiscountSum;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public Sum setSum(BigDecimal sum) {
        this.sum = sum;
        return this;
    }

    public Sum setDiscountSum(BigDecimal discountSum) {
        this.discountSum = discountSum;
        return this;
    }

    public List<Item> getItems() {
        return items;
    }

    public Sum setItems(List<Item> items) {
        this.items = items;
        return this;
    }

    public BigDecimal getDiscountSum() {
        return discountSum;
    }

    public BigDecimal getSavedSum () {
        return sum.subtract(discountSum);
    }

    private String formatPrice (BigDecimal price) {
        return new java.text.DecimalFormat("0.00").format(price);
    }


    public String printDiscountSum() {
        return "总计: " + formatPrice(getDiscountSum()) + "(元)";
    }

    public String printSavedSum() {
        return "节省: " + formatPrice(getSavedSum()) + "(元)";
    }
}
