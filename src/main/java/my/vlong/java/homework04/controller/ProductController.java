package my.vlong.java.homework04.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.vlong.java.homework04.dto.ProductDTO;
import my.vlong.java.homework04.entity.Product;
import my.vlong.java.homework04.exception.CreatedException;
import my.vlong.java.homework04.exception.DataNotFoundException;
import my.vlong.java.homework04.exception.DeletedException;
import my.vlong.java.homework04.exception.UpdatedException;
import my.vlong.java.homework04.infrastructure.repository.ProductRepositoryImpl;
import my.vlong.java.homework04.mapping.ProductMapping;
import my.vlong.java.homework04.repository.IProductRepository;

public class ProductController {

    private final IProductRepository productRepository;

    public ProductController() {
        productRepository = new ProductRepositoryImpl();
    }

    public Optional<ProductDTO> add(ProductDTO productDTO) throws CreatedException {
        ProductDTO productDTOAdded = null;
        try {
            Product product = ProductMapping.INSTANCE.toEntity(productDTO);
            Optional<Product> productAdded = productRepository.add(product);
            if (productAdded.isPresent()) {
                productDTOAdded = ProductMapping.INSTANCE.toDTO(productAdded.get());
            }
        } catch (CreatedException ex) {
            throw new CreatedException("Can not add product");
        }

        return Optional.ofNullable(productDTO);
    }

    public Optional<ProductDTO> update(int id, ProductDTO productDTO) throws UpdatedException {
        ProductDTO productDTOUpdated = null;
        try {
            Optional<Product> productOptional = productRepository.findByOne(id);
            if (!productOptional.isPresent()) {
                return Optional.empty();
            }
            Product product = productOptional.get();
            Product productUpdate = ProductMapping.INSTANCE.toEntity(productDTO);
            productUpdate.setId(product.getId());
            
            Optional<Product> update = productRepository.update(productUpdate);

            if (update.isPresent()) {
                productDTOUpdated = ProductMapping.INSTANCE.toDTO(update.get());
            }
        } catch (DataNotFoundException | UpdatedException ex) {
            throw new UpdatedException(("Can not update product"));
        }
        return Optional.ofNullable(productDTOUpdated);
    }

    public boolean delete(int id) throws DeletedException {
        try {
            productRepository.delete(id);
        } catch (DeletedException ex) {
            throw new DeletedException(("Can not delete product"));
        }
        return false;
    }

    public Optional<ProductDTO> findProduct(int id) throws DataNotFoundException {
        ProductDTO productDTO = null;

        try {
            Optional<Product> productOptional = productRepository.findByOne(id);
            if (!productOptional.isPresent()) {
                throw new DataNotFoundException(("Can not found data"));
            }

            Product product = productOptional.get();
            productDTO = ProductMapping.INSTANCE.toDTO(product);
        } catch (DataNotFoundException ex) {
            throw new DataNotFoundException(("Can not found data"));
        }

        return Optional.ofNullable(productDTO);
    }

    public List<ProductDTO> findAll() throws DataNotFoundException {
        List<ProductDTO> productDtos = new ArrayList<>();
        try {
            List<Product> products = productRepository.findAll();
            productDtos = ProductMapping.INSTANCE.toDTOs(products);
        } catch (DataNotFoundException ex) {
            throw new DataNotFoundException(("Can not found data"));
        }
        return productDtos;
    }
    
    private boolean isAddValid(ProductDTO productDTO) {
        return true;
    }
    
    private boolean isUpdateValid(ProductDTO productDTO) {
        return true;
    }
}
