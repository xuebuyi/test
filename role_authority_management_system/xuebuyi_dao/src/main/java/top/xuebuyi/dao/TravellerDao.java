package top.xuebuyi.dao;

import org.apache.ibatis.annotations.Select;
import top.xuebuyi.domain.Traveller;

import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-01-27 16:03
 */
public interface TravellerDao {
    //从中间表根据订单Id查询旅客信息
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId);

}
