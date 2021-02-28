package top.xuebuyi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.xuebuyi.dao.ProductDao;
import top.xuebuyi.domain.Product;
import top.xuebuyi.service.ProductService;

import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-01-24 14:14
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }
}
