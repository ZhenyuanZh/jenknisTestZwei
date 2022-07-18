package org.example.dao;
import org.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
    /**
     * findUserByUsernameAndPassword
     * @param name name
     //* @param password password
     * @return User
     */

    Product findProductByProductname(String name);

    /**
     * updatePasswordById
     * @param id id
     //* @param newPassword newPassword
     * @param newPrice newPrice
     */
    @Modifying
    @Query("update Product p set p.productprice=:newPrice where p.id=:id")
    void updatePriceById(@Param("id") Integer id, @Param("newPrice") float newPrice);

    /**
     * deleteUserById
     * @param id id
     */
    @Modifying
    void deleteProductById(Integer id);
    @Modifying
    void deleteProductByProductname(String name);
    /**
     * findUserById
     * @param id id
     * @return User
     */
    Product findProductById(Integer id);
    List<Product> findAll(Sort sort);
}
