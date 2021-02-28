package top.xuebuyi.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.xuebuyi.domain.Product;

import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-01-24 14:07
 */
public interface ProductDao {

    //根据Id查询商品
    @Select("select * from product where id=#{id}")
    public Product findById(String id);
    //查询所有的产品信息
    @Select("select * from product")
    public List<Product> findAll();

    //保存产品
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
