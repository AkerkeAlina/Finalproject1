package Shop.data;

import java.io.Serializable;

public abstract class Good implements Serializable {
    private Long id;
    private String model;
    private int price;
    private int count;
    private int sold;

    public abstract String showDetails();

    public Good() {
    }

    public Good(Long id, String model, int price, int count, int sold) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.count = count;
        this.sold = sold;
    }

    public Good(Long id, String model, int price, int count) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
}
