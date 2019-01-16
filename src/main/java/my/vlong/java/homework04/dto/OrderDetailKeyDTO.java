package my.vlong.java.homework04.dto;

import lombok.Data;

@Data
public class OrderDetailKeyDTO {

    private String productId;
    private String orderId;

    @Override
    public String toString() {
        return "OrderDetailKeyDTO{" + "productId=" + productId + ", orderId=" + orderId + '}';
    }

}
