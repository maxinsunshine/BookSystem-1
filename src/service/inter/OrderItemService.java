package service.inter;

import model.OrderItem;

public interface OrderItemService {
	
	int deleteByPrimaryKey(OrderItem record);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(OrderItem record);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
	
}
