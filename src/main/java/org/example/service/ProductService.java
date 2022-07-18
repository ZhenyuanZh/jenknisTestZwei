package org.example.service;

import org.example.model.Product;
import org.example.model.User_test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ProductService {
    boolean updatePrice(Integer id, float newPrice);

    List<Product> getProduct(HttpServletRequest request);

    void updateProduct(Product product) throws Exception;

    void saveProduct(Product product);

    void deleteProductById(Integer id);
    void deleteProductByName(String name);
    Product getProductById(Integer id);

    Product getProductByProduct_name(String name);
    List<Product> listAllProduct(int pageNum, int pageSize);


}
