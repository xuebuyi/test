package top.xuebuyi.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.xuebuyi.dao.OrdersDao;
import top.xuebuyi.domain.Orders;
import top.xuebuyi.service.OrdersService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-01-25 17:12
 */

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Resource
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int pageNumber, int pageSize) {
        //参数: pageNum: 页码, pageSize: 每页显示条数
        PageHelper.startPage(pageNumber,pageSize);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) {
        return ordersDao.findById(ordersId);
    }
}
