package discount;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestDiscount {
    @Test
    public void shouldOnePlusOneEqualsTwo () {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void shouldGetInputItem () {
        String barcode = "ITEM000001";
        Item item = new Item()
                .setBarcode(barcode)
                .setName("可口可乐")
                .setUnit("瓶")
                .setCategory("食品")
                .setSubCategory("碳酸饮料")
                .setPrice(BigDecimal.valueOf(3.00));

        assertEquals("可口可乐", item.getName());
    }

    @Test
    public void TestBigDecimal () {
        BigDecimal initValue = BigDecimal.ZERO;
        initValue = initValue.add(BigDecimal.valueOf(19));
        System.out.println("this is the init value:" + initValue);
    }
}
