package com.example.products.repository;

import com.example.products.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    //Lista Inicializada
    private List<Product> products = new ArrayList<>();

    //Metodo obtener todos los productos
    public List<Product> getAllProducts (){
        return products;
    }

    //Metodo obtener producto por Id
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

    //Metodo guardar Producto
    public Product save (Product p){

        Product product = new Product();
        product.setId(p.getId());
        product.setName(p.getName());
        product.setQuantity(p.getQuantity());
        product.setCost(p.getCost());

        products.add(product);
        return product;
    }

    //Metodo actualizar Producto
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

    //Metodo Eliminar Producto
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
