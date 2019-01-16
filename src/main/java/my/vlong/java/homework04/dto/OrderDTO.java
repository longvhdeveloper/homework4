package my.vlong.java.homework04.dto;

import java.util.List;
import lombok.Data;
import my.vlong.java.homework04.entity.Status;

@Data
public class OrderDTO {

    private String id;
    private String dateCreated;
    private String customerName;
    private Status status;
    private List<OrderDetailDTO> productDtos;

    @Override
    public String toString() {        
        return "OrderDTO{" + "id=" + id + ", dateCreated=" + dateCreated + ", customerName=" + customerName + ", status=" + status + ", productDtos=" + productDtos + '}';
    }

}
