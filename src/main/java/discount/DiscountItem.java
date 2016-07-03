package discount;

public class DiscountItem {
    private String type;
    private String[] barcodes;

    public String getType() {
        return type;
    }

    public DiscountItem setType(String type) {
        this.type = type;
        return this;
    }

    public String[] getBarcodes() {
        return barcodes;
    }

    public DiscountItem setBarcodes(String[] barcodes) {
        this.barcodes = barcodes;
        return this;
    }

}
