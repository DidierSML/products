package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/apiProducts")
public class ProductController {

    private final ProductService productService;

    @PostMapping("saveProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct (@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("getAllProducts")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts (){
        return productService.getAllProduts();
    }

    @GetMapping("getProductById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct (@PathVariable Integer id){
        return productService.findProductById(id);
    }

    @PutMapping("updateProductById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct (@PathVariable Integer id, @RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @GetMapping("searchByName") //Metodo donde buscaremos a través del @RequestParam
    @ResponseStatus(HttpStatus.OK)
    public List <Product> searchByName (@RequestParam String name){
        return productService.searchByName(name);
    }

    @DeleteMapping("deleteProductById/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String deleteProduct (@PathVariable Integer id){
        return productService.deleteProduct(id);
    }

    /*
        Cuando usamos NO_CONTENT, esta configuracion evita que se muetre por pantalla
        cualquier mensaje, así haya sido previamente asignado en la lógica.
     */



}
