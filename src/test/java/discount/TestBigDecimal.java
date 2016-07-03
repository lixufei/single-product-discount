package discount;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestBigDecimal {
    @Test
    public void TestBigDecimal () {
        BigDecimal initValue = BigDecimal.ZERO;
        initValue = initValue.add(BigDecimal.valueOf(19.0));
        assertEquals(BigDecimal.valueOf(19.0), initValue);
    }
}
