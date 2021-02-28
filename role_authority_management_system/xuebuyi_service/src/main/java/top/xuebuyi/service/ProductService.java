package top.xuebuyi.service;

import top.xuebuyi.domain.Product;

import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-01-24 14:10
 */
public interface ProductService {

    List<Product> findAll();

    void save(Product product);
}
