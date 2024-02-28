package ie.tcd.sweng2024.groupone.api.model;

public class Discount {
    private int id;
    private String provider;
    private String type;
    private String productName;
    private String linkToPage;

    public Discount(int id, String provider, String type, String productName, String linkToPage) {
        this.id = id;
        this.provider = provider;
        this.type = type;
        this.productName = productName;
        this.linkToPage = linkToPage;
    }

    public int getId() {
        return this.id;
    }
    public String getProvider() {
        return this.provider;
    }
    public String getType() {
        return this.type;
    }
    public String getProductName() {
        return this.productName;
    }

}
