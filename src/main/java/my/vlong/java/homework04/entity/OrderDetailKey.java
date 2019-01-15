package my.vlong.java.homework04.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class OrderDetailKey implements Serializable {

    @Column(name = "product_id")
    private int productId;

    @Column(name = "order_id")
    private int orderId;

    @Override
    public String toString() {
        return "OrderDetailKey{" + "productId=" + productId + ", orderId=" + orderId + '}';
    }

}
