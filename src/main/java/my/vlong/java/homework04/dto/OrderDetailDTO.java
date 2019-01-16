package my.vlong.java.homework04.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {

    private ProductDTO productDTO;
    private OrderDTO orderDTO;
    private int quantity;
    private double price;

    @Override
    public String toString() {
        return "OrderDetailDTO{" + "productDTO=" + productDTO + ", orderDTO=" + orderDTO + ", quantity=" + quantity + ", price=" + price + '}';
    }

}
