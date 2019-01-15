package my.vlong.java.homework04.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {

    private ProductDTO product;    
    private OrderDTO order;
    private int quantity;
    private double price;

    @Override
    public String toString() {
        return "OrderDetailDTO{" + "product=" + product + ", order=" + order + ", quantity=" + quantity + ", price=" + price + '}';
    }

}
