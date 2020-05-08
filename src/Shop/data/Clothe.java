package Shop.data;

import java.io.Serializable;

public class Clothe extends Good implements Serializable {
    private String size;
    private String type;

    public Clothe() {
    }

    public Clothe(Long id, String model, int price, int count, String size, String type) {
        super(id, model, price, count);
        this.size = size;
        this.type = type;
    }

    public Clothe(Long id, String model, int price, int count, int sold, String size, String type) {
        super(id, model, price, count, sold);
        this.size = size;
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String showDetails() {
        return null;
    }
}
