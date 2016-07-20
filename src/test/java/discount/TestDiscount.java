package discount;

import org.junit.Before;
import org.junit.Test;
import util.Sum;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDiscount {
    private DiscountItem discountItem1 = new DiscountItem();
    private DiscountItem discountItem2 = new DiscountItem();
    List<DiscountItem> discountItems = new ArrayList<DiscountItem>();
    List<Item> items = new ArrayList<Item>();
    private Item item1 = new Item();
    private Item item2 = new Item();
    private Item item3 = new Item();
    BigDecimal ONE = BigDecimal.valueOf(1.0);

    @Before
    public void setup() {
        discountItem1.setType("TENPERCENT")
                .setBarcodes(new String[]{"ITEM000000", "ITEM0000001"});

        discountItem2.setType("TWENTYPERCENT")
                .setBarcodes(new String[]{"ITEM000002", "ITEM0000003"});

        discountItems.add(discountItem1);
        discountItems.add(discountItem2);

        item1.setBarcode("ITEM0000001-2")
                .setName("可口可乐")
                .setUnit("瓶")
                .setCategory("食品")
                .setSubCategory("碳酸饮料")
                .setPrice(BigDecimal.valueOf(3.00))
                .setDiscountItems(discountItems);

        item2.setBarcode("ITEM0000003-4")
                .setName("百事可乐")
                .setUnit("瓶")
                .setCategory("食品")
                .setSubCategory("碳酸饮料")
                .setPrice(BigDecimal.valueOf(5.00))
                .setDiscountItems(discountItems);;

        item3.setBarcode("ITEM000000312-4")
                .setName("百事可乐")
                .setUnit("瓶")
                .setCategory("食品")
                .setSubCategory("碳酸饮料")
                .setPrice(BigDecimal.valueOf(1.00))
                .setDiscountItems(discountItems);;

        items.add(item1);
        items.add(item2);
        items.add(item3);
    }

    @Test
    public void shouldGetDiscountedPriceWhenGivenAPrice() {
        BigDecimal price = BigDecimal.valueOf(6.0);
        assertEquals(BigDecimal.valueOf(5.4).multiply(ONE), Discount.TENPERCENT.discountResult(price));
        assertEquals(BigDecimal.valueOf(4.8).multiply(ONE), Discount.TWENTYPERCENT.discountResult(price));
    }

    @Test
    public void shouldGetTypeBaseOnBarcode () {
        String barcode = "ITEM000002-9";
        String type = item1.getDiscountType(barcode);
        assertEquals("TWENTYPERCENT", type);
    }

    @Test
    public void shouldNotGetTypeBaseOnBarcode () {
        String barcode = "ITEM000009090-9";
        String type = item1.getDiscountType(barcode);
        assertEquals("", type);
    }

    @Test
    public void shouldGetTotalDiscountPriceWhenBarcodeIsDiscount () {
        String barcode = item1.getBarcode();

        assertEquals(BigDecimal.valueOf(5.4).multiply(ONE), item1.getItemPrice());
    }

    @Test
    public void shouldGetTotalAmountIfMultipleItems () {
        BigDecimal price1 = item1.getItemPrice();
        BigDecimal price2 = item2.getItemPrice();
        assertEquals(BigDecimal.valueOf(21.4).multiply(ONE) , price1.add(price2));

    }

    @Test
    public void testSumGivenMultipleItems () {
        Sum sum = new Sum(items);
        assertEquals(BigDecimal.valueOf(25.4).multiply(ONE), sum.getDiscountSum());
    }

    @Test
    public void shouldGetTotalSavedMoney () {
        Sum sum = new Sum(items);
        assertEquals(BigDecimal.valueOf(4.6).multiply(ONE), sum.getSavedSum());
    }

    @Test
    public void shouldReturnFalseIfItemIsNotDiscount () {
        assertEquals(false, item3.itemIsDiscount());
    }

    @Test
    public void shouldGetSavedPriceWhenDiscount () {
        assertEquals(BigDecimal.valueOf(0.6).multiply(ONE), item1.getSavedPrice());
    }

    @Test
    public void shouldPrintOneItemInfo () {
        assertEquals("名称: 百事可乐, 数量: 4瓶, 单价: 1.00(元), 小计: 4.00(元)", item3.toString());
        assertEquals("名称: 可口可乐, 数量: 2瓶, 单价: 3.00(元), 小计: 5.40(元), 优惠0.60(元)", item1.toString());
    }

}
