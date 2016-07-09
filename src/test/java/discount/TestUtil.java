package discount;

import org.junit.Test;
import util.Sum;

import java.math.BigDecimal;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestUtil {
    @Test
    public void TestBigDecimal () {
        BigDecimal initValue = BigDecimal.ZERO;
        initValue = initValue.add(BigDecimal.valueOf(19.0));
        assertEquals(BigDecimal.valueOf(19.0), initValue);
    }

    @Test
    public void shouldCombineOneArrayWhenItIsMultipleArray () {
        String[] strings = {"ITEM000000", "ITEM0000001", "ITEM000002", "ITEM0000003"};
        String[] strings1 = {"ITEM000000", "ITEM0000001"};
        String[] strings2 = {"ITEM000002", "ITEM0000003"};
//        assertEquals(strings, new Sum().getCombinedArray(strings1, strings2));
    }
}
