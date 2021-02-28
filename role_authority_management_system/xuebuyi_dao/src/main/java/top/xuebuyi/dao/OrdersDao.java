package top.xuebuyi.dao;

import net.sf.jsqlparser.schema.Column;
import org.apache.ibatis.annotations.*;
import top.xuebuyi.domain.Member;
import top.xuebuyi.domain.Orders;
import top.xuebuyi.domain.Product;
import top.xuebuyi.domain.Traveller;

import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-01-25 17:13
 */
public interface OrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "top.xuebuyi.dao.ProductDao.findById")),
    })
    public List<Orders> findAll();

    //多表操作
    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "top.xuebuyi.dao.ProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "top.xuebuyi.dao.MemberDao.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class, many = @Many(select = "top.xuebuyi.dao.TravellerDao.findByOrdersId"))
    })
    Orders findById(String ordersId);
}
