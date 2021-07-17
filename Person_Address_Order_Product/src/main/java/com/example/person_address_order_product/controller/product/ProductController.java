package com.example.person_address_order_product.controller.product;

import com.example.person_address_order_product.controller.person.model.PersonResponse;
import com.example.person_address_order_product.controller.product.model.ProductRequest;
import com.example.person_address_order_product.controller.product.model.ProductResponse;
import com.example.person_address_order_product.facade.ProductFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductFacade productFacade;

    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }


    //create
    @PostMapping(value = "/product")
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request){
        ResponseEntity<ProductResponse> body = ResponseEntity.status(HttpStatus.CREATED).body(productFacade.create(request));
        return body;
    }

    //read
    @GetMapping(value = "/product/{id}")
    public ResponseEntity<ProductResponse> readById(@PathVariable Long id){
        ResponseEntity<ProductResponse> body = ResponseEntity.status(HttpStatus.CREATED).body(productFacade.readById(id));
        return body;
    }

    //readAll
    @GetMapping(value = "/product")
    public ResponseEntity<List<ProductResponse>> readAll(){
        ResponseEntity<List<ProductResponse>> body = ResponseEntity.status(HttpStatus.CREATED).body(productFacade.readAll());
        return body;
    }

    //update
    @PutMapping(value = "product/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @RequestBody ProductRequest product){
        ResponseEntity<ProductResponse> body = ResponseEntity.status(HttpStatus.CREATED).body(productFacade.update(id, product));
        return body;
    }

    //delete
    @DeleteMapping(value = "product/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        ResponseEntity<Boolean> body = ResponseEntity.status(HttpStatus.CREATED).body(productFacade.delete(id));
        return body;
    }

    //search
    @GetMapping(value = "product/search")
    public ResponseEntity<List<ProductResponse>> search(@RequestParam String title){
        ResponseEntity<List<ProductResponse>> body = ResponseEntity.status(HttpStatus.CREATED).body(productFacade.search(title));
        return body;
    }

}
