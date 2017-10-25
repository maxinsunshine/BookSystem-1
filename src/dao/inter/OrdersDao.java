package dao.inter;

import java.util.List;

import model.Orders;

public interface OrdersDao {
	
	int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
	
    List<Orders> getAllOrders();
    
}
