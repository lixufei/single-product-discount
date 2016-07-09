package util;

import discount.DiscountItem;
import discount.Item;

import java.math.BigDecimal;
import java.util.List;

public class Sum {

    public BigDecimal getSum(List<Item> items) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item : items) {
            sum = sum.add(item.getItemPrice(item.getBarcode()));
        }
        return sum;
    }
}
