package my.vlong.java.homework04.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "[order]")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_created", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> products;

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", dateCreated=" + dateCreated + ", customerName=" + customerName + ", status=" + status + '}';
    }
}
