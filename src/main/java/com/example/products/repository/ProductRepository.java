package com.example.products.repository;

import com.example.products.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {


    private List<Product> products = new ArrayList<>();

    public void createProduct(){
        products = List.of(
                new Product(1,"Producto1",3,1000),
                new Product(2,"Producto2",4,2000),
                new Product(3,"Producto3",5,3000),
                new Product(4,"Producto4",6,4000),
                new Product(5,"Producto5",7,5000)
        );

    }

    public List<Product> getAllProducts (){
        return products;
    }

    public Product findById (int id){
        for (int i = 0; i < products.size();i++){
            if (products.get(i).getId() == id){
                return products.get(i);
            }
        }

        System.out.println("Este Producto no esta en nuestro stock");
        return null;

        /*
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
            System.out.println("Este Producto no esta en nuestro stock");
            return null;
        }
         */
    }

    public List<Product> searchByName (String name){

        List <Product> matchingProducts = new ArrayList<>();

        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getName().equals(name)){
                matchingProducts.add(products.get(i));
            }
        }

        return matchingProducts;

        /*
        for (Product product : products) {
            if (product.getName().equals(name)) {
                matchingProducts.add(product);
            }
        }

        return matchingProducts;
         */

        /*
        public List<Product> searchByName(String name) {
            return products.stream()
                   .filter(product -> product.getName().equals(name))
                   .collect(Collectors.toList());

         */
    }

    public Product save (Product p){

        Product product = new Product();
        product.setId(p.getId());
        product.setName(p.getName());
        product.setCantidad(p.getCantidad());
        product.setPrecio(p.getPrecio());

        products.add(product);
        return product;
    }

    public Product updateById(Integer id, Product updateProduct){
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getId() == id){
                products.set(i,updateProduct);
                System.out.println("actualizacion exitosa");
                return updateProduct;
            }
        }
        System.out.println("No se encontro el usario con ese id");
        return null;
    }

    public String deleteById (Integer id){

        for (int i = 0; i < products.size();i++){
            if (products.get(i).getId() == id){
                products.remove(i);
                return "Producto eliminado exitosamente";
            }
        }
        return "No se encontro un producto con el Id especificado";

    }
/*
        products.removeIf(x -> x.getId() == id);
        return null;
*/
}
