package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import org.example.dao.ProductDao;
import org.example.model.Product;
import org.example.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service("productService")
@Transactional(rollbackOn = Exception.class)
public class ProductServiceImpl implements ProductService {
    @Resource(name="productDao")
    private ProductDao productDao;
    @Override
    public boolean updatePrice(Integer id, float newPrice) {
        productDao.updatePriceById(id,newPrice);
        return true;
    }

    @Override
    public List<Product> getProduct(HttpServletRequest request) {
        return null;
    }

    @Override
    public void updateProduct(Product product) throws Exception {

    }

    @Override
    public void saveProduct(Product product) {
        productDao.save(product);

    }

    @Override
    public void deleteProductById(Integer id) {

    }

    @Override
    public void deleteProductByName(String name) {
        productDao.deleteProductByProductname(name);
    }

    @Override
    public Product getProductById(Integer id) {
        return null;
    }

    @Override
    public Product getProductByProduct_name(String name) {
        return productDao.findProductByProductname(name);

    }

    @Override
    public List<Product> listAllProduct(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return productDao.findAll();
    }
    private Specification<Product> getProductSpecification( Integer departmentId, String name, String createTime, String price) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (departmentId != null && departmentId != -1){
                predicate.getExpressions().add(criteriaBuilder.equal(root.get("departmentId"), departmentId));
            }
            if (name != null && !"".equals(name.trim())) {
                predicate.getExpressions().add(criteriaBuilder.equal(root.get("product_name"), name));
            }
            if (createTime != null && !"".equals(createTime.trim())) {
                predicate.getExpressions().add(criteriaBuilder.equal(root.get("create_time"), createTime));
            }
            if (price != null && !"".equals(price.trim())) {
                predicate.getExpressions().add(criteriaBuilder.equal(root.get("product_price"), price));
            }
            return predicate;
        };
    }

}
