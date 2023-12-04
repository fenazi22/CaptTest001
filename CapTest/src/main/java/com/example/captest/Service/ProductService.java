package com.example.captest.Service;

import com.example.captest.Model.Product;
import com.example.captest.Repository.ProductRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private  final ProductRepository productRepository;

   // ArrayList<Product> products=new ArrayList<>();

    public List<Product> getProduct(){
        return productRepository.findAll();
    }

    public char addProduct(Product product){
//        for (int i = 0; i <products.size() ; i++) {
//            if (products.get(i).getId().equals(product.getId()) || products.get(i).getName().equals(product.getName()) || products.get(i).getCategoryID().equals(product.getCategoryID()));
//            return 'a';
//        }

        if (product.getId()==null || product.getPrice()==0 || product.getCategoryID()==null || product.getName()==null){
            return 'b';
        }else {
            productRepository.save(product);
            return 'c';

        }

    }

    public char updateProduct(Integer id , Product product){
        Product product1=productRepository.getReferenceById(id);
        if (product1==null){
            return 'b';
        }
        product1.setName(product.getName());
        product1.setId(product.getId());
        product1.setPrice(product.getPrice());
        product1.setCategoryID(product.getCategoryID());
        productRepository.save(product1);
        return 'a';
//        for (int i = 0; i <products.size() ; i++) {
//            if (products.get(i).getId().equals(id)){
//                products.set(i,product);
//                return 'a';
//            }else{
//                return 'b';
//            }
//        }
//        return 'c';

    }



    public char deleteProduct(Integer id){
        Product product=productRepository.getById(id);
        if (product==null){
            return 'b';
        }else {
         productRepository.delete(product);
            return 'a';
        }


//        for (int i = 0; i <products.size() ; i++) {
//            if (products.get(i).getId().equals(id)){
//                products.remove(i);
//                return 'a';
//            }else {
//                return 'b';
//            }
//        }
//        return 'c';

    }



}
