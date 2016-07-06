package util;

import discount.DiscountItem;
import discount.Item;

import java.math.BigDecimal;
import java.util.List;

public class Sum {

    public BigDecimal getSum(List<Item> items, List<DiscountItem> discountItems) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item : items) {
            sum = sum.add(item.getItemPrice(item.getBarcode(), discountItems));
        }
        return sum;
    }
}
