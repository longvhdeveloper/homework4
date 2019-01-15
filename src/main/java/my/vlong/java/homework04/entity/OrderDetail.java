package my.vlong.java.homework04.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "order_detail")
@Data
public class OrderDetail implements Serializable {

    @EmbeddedId
    private OrderDetailKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;
    
    @ManyToOne
    @MapsId("orderI")
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Order order;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Override
    public String toString() {
        return "OrderDetail{" + "id=" + id + ", quantity=" + quantity + ", price=" + price + '}';
    }

}
