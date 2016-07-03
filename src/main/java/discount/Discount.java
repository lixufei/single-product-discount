package discount;

import java.math.BigDecimal;

public enum Discount {
    TENPERCENT(0.9), TWENTYPERCENT(0.8);

    private Double discount;
    private Discount (double discount) {
        this.discount = discount;
    }

    public BigDecimal discountResult (BigDecimal price) {
        return price.multiply(BigDecimal.valueOf(discount));
    }
}
