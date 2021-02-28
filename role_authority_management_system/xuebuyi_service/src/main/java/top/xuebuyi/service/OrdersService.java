package top.xuebuyi.service;

import top.xuebuyi.domain.Orders;

import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-01-25 17:11
 */
public interface OrdersService {
    List<Orders> findAll(int pageNumber, int pageSize);

    Orders findById(String ordersId);
}
