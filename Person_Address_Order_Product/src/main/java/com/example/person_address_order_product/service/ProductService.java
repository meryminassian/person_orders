package com.example.person_address_order_product.service;

import com.example.person_address_order_product.controller.product.model.ProductRequest;
import com.example.person_address_order_product.persistence.ProductRepository;
import com.example.person_address_order_product.persistence.model.Person;
import com.example.person_address_order_product.persistence.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(ProductRequest request){
        Product savedProduct = productRepository.save(convertFromRequestToProduct(request));
        return savedProduct;

    }
    public Product readById(Long id){
        return productRepository.getById(id);
    }

    public List<Product> readAll(){
        List<Product> all = productRepository.findAll();
        return all;
    }

    public Product update(Long id, ProductRequest request){

        Product byId = productRepository.getById(id);
        byId.setDescription(request.getDescription());
        byId.setPrice(request.getPrice());
        Product saved = productRepository.save(byId);
        return saved;
    }

    public Boolean delete(Long id){
        productRepository.deleteById(id);
        return !productRepository.existsById(id);
    }

    public List<Product> search(String title){
        return productRepository.findByDescriptionContainingIgnoreCase(title);
    }

    private Product convertFromRequestToProduct(ProductRequest request){
        Product product = new Product();
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        return product;

    }
}
