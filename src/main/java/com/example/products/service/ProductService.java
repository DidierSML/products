package com.example.products.service;

import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product saveProduct (Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProduts (){
        return productRepository.getAllProducts();
    }

    public Product findProductById (Integer id){
        return productRepository.findById(id);
    }

//    public Product searchById (String name){
//        return productRepository.searchByName(name);
//    }

    public Product updateProduct (Integer id, Product updateProduct){
       return productRepository.updateById(id,updateProduct);
    }
    public String deleteProduct (Integer id){
        return productRepository.deleteById(id);
    }


}
