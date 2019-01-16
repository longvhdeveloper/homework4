package my.vlong.java.homework04.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.vlong.java.homework04.controller.OrderController;
import my.vlong.java.homework04.controller.ProductController;
import my.vlong.java.homework04.dto.OrderDTO;
import my.vlong.java.homework04.dto.OrderDetailDTO;
import my.vlong.java.homework04.dto.ProductDTO;
import my.vlong.java.homework04.entity.Status;
import my.vlong.java.homework04.exception.CreatedException;
import my.vlong.java.homework04.exception.DataNotFoundException;
import my.vlong.java.homework04.exception.DeletedException;
import my.vlong.java.homework04.exception.UpdatedException;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        
    }

    public void addProduct() {
        try {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setName("Test");
            productDTO.setDescription("TestProduct");
            productDTO.setPrice(1003.15f);

            ProductController productController = new ProductController();
            Optional<ProductDTO> add = productController.add(productDTO);
            if (add.isPresent()) {
                System.out.println("add success");
            } else {
                System.out.println("add error");
            }
        } catch (CreatedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateProduct() {
        try {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setName("IPhone X");
            productDTO.setDescription("Best seller product");
            productDTO.setPrice(803.15f);

            ProductController productController = new ProductController();
            Optional<ProductDTO> add = productController.update(1, productDTO);
            if (add.isPresent()) {
                System.out.println("update success");
            } else {
                System.out.println("update error");
            }
        } catch (UpdatedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteProduct() {
        try {
            int id = 4;
            ProductController productController = new ProductController();
            productController.delete(id);
            System.out.println("Delete success");
        } catch (DeletedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void findProduct() {
        try {
            int id = 3;
            ProductController productController = new ProductController();
            Optional<ProductDTO> findProduct = productController.findProduct(id);
            if (findProduct.isPresent()) {
                System.out.println(findProduct.get());
            } else {
                System.out.println("Not found data");
            }
        } catch (DataNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void findAllProduct() {
        ProductController productController = new ProductController();
        try {
            List<ProductDTO> productDTOs = productController.findAll();
            productDTOs.forEach(System.out::println);
        } catch (DataNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addOrder() {
        try {
            OrderController orderController = new OrderController();
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setCustomerName("Vo Hoang Long");
            orderDTO.setDateCreated("2019-01-15");
            //orderDTO.setStatus(Status.OPEN);

            Optional<OrderDTO> add = orderController.add(orderDTO);
            if (add.isPresent()) {
                // add order detail
                addOrderDetail(add.get());
                System.out.println("add success");
            } else {
                System.out.println("add error");
            }
        } catch (CreatedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void addOrderDetail(OrderDTO orderDTO) {
        ProductController productController = new ProductController();
        OrderController orderController = new OrderController();
        Integer[] ids = {1, 2};
        List<Integer> idList = Arrays.asList(ids);
        List<OrderDetailDTO> orderDetailDTOs = new ArrayList<>();
        idList.forEach((Integer t) -> {
           
        });

        orderController.addOrderDetails(orderDetailDTOs);
    }

    public void updateOrder() {
        try {
            OrderController orderController = new OrderController();
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setCustomerName("Vo Hoang Long");
            orderDTO.setDateCreated("2019-01-15");
            //orderDTO.setStatus(Status.COMPLETE);

            Optional<OrderDTO> update = orderController.update(1, orderDTO);
            if (update.isPresent()) {
                System.out.println("update success");
            } else {
                System.out.println("update error");
            }
        } catch (UpdatedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteOrder() {
        try {
            int id = 1;
            OrderController orderController = new OrderController();
            orderController.delete(id);
            System.out.println("Delete success");
        } catch (DeletedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void findOrder() {
        try {
            int id = 2;
            OrderController orderController = new OrderController();
            Optional<OrderDTO> findOrder = orderController.findProduct(id);
            if (findOrder.isPresent()) {
                System.out.println(findOrder.get());
            } else {
                System.out.println("Not found data");
            }
        } catch (DataNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void findAllOrder() {
        OrderController orderController = new OrderController();
        try {
            List<OrderDTO> orderDTOs = orderController.findAll();
            orderDTOs.forEach(System.out::println);
        } catch (DataNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
