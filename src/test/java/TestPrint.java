import discount.DiscountItem;
import discount.Item;
import org.junit.Before;
import org.junit.Test;
import util.Sum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestPrint {

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
    public void shouldPrintOneItemWhenGivenOneItem () {
        System.out.println("in testing");
    }

    @Test
    public void shouldPrintSumOfItemsWhenGivenMultipleItem () {
        Sum sum = new Sum(items);
        assertEquals("总计: 25.40(元)", sum.printDiscountSum ());
        assertEquals("节省: 4.60(元)", sum.printSavedSum());
    }

    @Test
    public void shouldPrintOneItemInfo () {
        assertEquals("名称: 百事可乐, 数量: 4瓶, 单价: 1.00(元), 小计: 4.00(元)", item3.toString());
        assertEquals("名称: 可口可乐, 数量: 2瓶, 单价: 3.00(元), 小计: 5.40(元), 优惠0.60(元)", item1.toString());
    }

    @Test
    public void shouldPrintDiscountItemsIfThereIs () {
        assertEquals("", item3.printHowManyDiscount());
        assertEquals("名称: 可口可乐, 折扣: 九折", item1.printHowManyDiscount());
    }
}
