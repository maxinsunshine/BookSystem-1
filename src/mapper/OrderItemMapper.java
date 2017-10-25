package mapper;

import model.OrderItem;

public interface OrderItemMapper {
    int deleteByPrimaryKey(OrderItem record);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(OrderItem record);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}