package service.inter;

import java.util.List;

import model.Orders;

public interface OrdersService {
	
	int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    
    List<Orders> getAllOrders();
	
}
