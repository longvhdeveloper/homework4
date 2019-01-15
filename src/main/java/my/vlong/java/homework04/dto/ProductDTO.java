package my.vlong.java.homework04.dto;

import java.util.List;
import lombok.Data;

@Data
public class ProductDTO {

    private String id;
    private String name;
    private String description;
    private float price;
    private List<OrderDetailDTO> orderDtos;

    @Override
    public String toString() {
        return "ProductDTO{" + "id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", orderDtos=" + orderDtos + '}';
    }

}
