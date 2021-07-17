package com.example.person_address_order_product.facade;

import com.example.person_address_order_product.controller.converter.Converter;
import com.example.person_address_order_product.controller.person.model.PersonResponse;
import com.example.person_address_order_product.controller.product.model.ProductRequest;
import com.example.person_address_order_product.controller.product.model.ProductResponse;
import com.example.person_address_order_product.persistence.model.Person;
import com.example.person_address_order_product.persistence.model.Product;
import com.example.person_address_order_product.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductFacade {

    private final ProductService productService;
    private final Converter converter;

    public ProductFacade(ProductService productService, Converter converter) {
        this.productService = productService;
        this.converter = converter;
    }


    public ProductResponse create(ProductRequest request){
        Product product = productService.create(request);
        ProductResponse productResponse = converter.convertFromProductToProductResponse(product);
        return productResponse;
    }

    public ProductResponse readById(Long id){
        Product product = productService.readById(id);
        ProductResponse productResponse = converter.convertFromProductToProductResponse(product);
        return productResponse;

    }

    public List<ProductResponse> readAll(){
        List<Product> products = productService.readAll();

        List<ProductResponse> productResponses = products.stream()
                .map(each -> converter.convertFromProductToProductResponse(each))
                .collect(Collectors.toList());

        return productResponses;
    }

    public ProductResponse update(Long id, ProductRequest request){
        Product updated = productService.update(id, request);
        ProductResponse productResponse = converter.convertFromProductToProductResponse(updated);
        return productResponse;
    }

    public Boolean delete(Long id){
        return productService.delete(id);
    }

    public List<ProductResponse> search(String title){
        List<Product> search = productService.search(title);

        List<ProductResponse> productResponses = search.stream()
                .map(each -> converter.convertFromProductToProductResponse(each))
                .collect(Collectors.toList());

        return productResponses;
    }
}
