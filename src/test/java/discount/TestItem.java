package discount;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestItem {
    private Item item = new Item();
    private Item multipleItems = new Item();

    @Before
    public void setup() {
        item.setBarcode("ITEM000001")
                .setName("可口可乐")
                .setUnit("瓶")
                .setCategory("食品")
                .setSubCategory("碳酸饮料")
                .setPrice(BigDecimal.valueOf(3.00));

        multipleItems.setBarcode("ITEM000001-2")
                .setName("百事可乐")
                .setUnit("瓶")
                .setCategory("食品")
                .setSubCategory("碳酸饮料")
                .setPrice(BigDecimal.valueOf(3.00));
    }

    @Test
    public void shouldGetInputItem() {
        assertEquals("可口可乐", item.getName());
    }

    @Test
    public void shouldGetMultipleItems () {
        System.out.println(multipleItems.getPrice());
        assertEquals(BigDecimal.valueOf(6.0), multipleItems.getPrice());
    }
}
