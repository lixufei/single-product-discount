package discount;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestDiscount {
    private Item item = new Item();

    @Before
    public void setup() {
        item.setBarcode("ITEM000001")
                .setName("可口可乐")
                .setUnit("瓶")
                .setCategory("食品")
                .setSubCategory("碳酸饮料")
                .setPrice(BigDecimal.valueOf(3.00));
    }

    @Test
    public void shouldGetInputItem() {
        assertEquals("可口可乐", item.getName());
    }

}
