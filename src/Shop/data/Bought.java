package Shop.data;

import java.io.Serializable;

public class Bought implements Serializable {
    private Long id;
    private Long user_id;
    private String clothe_type;
    private int count;
    private int total_sum;

    public Bought() {
    }

    public Bought(Long id, Long user_id, String clothe_type, int count, int total_sum) {
        this.id = id;
        this.user_id = user_id;
        this.clothe_type = clothe_type;
        this.count = count;
        this.total_sum = total_sum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getClothe_type() {
        return clothe_type;
    }

    public void setClothe_type(String clothe_type) {
        this.clothe_type = clothe_type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal_sum() {
        return total_sum;
    }

    public void setTotal_sum(int total_sum) {
        this.total_sum = total_sum;
    }
}
