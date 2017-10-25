package dao.impl;

import mapper.OrderItemMapper;
import model.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.inter.OrderItemDao;

@Repository
public class OrderItemDaoImpl implements OrderItemDao{

	//具体由我们配置好的mybatis的mapper来实现
	@Autowired
	private OrderItemMapper OrderItemMapper;

	@Override
	public int deleteByPrimaryKey(OrderItem record) {
		// TODO Auto-generated method stub
		return OrderItemMapper.deleteByPrimaryKey(record);
	}

	@Override
	public int insert(OrderItem record) {
		// TODO Auto-generated method stub
		return OrderItemMapper.insert(record);
	}

	@Override
	public int insertSelective(OrderItem record) {
		// TODO Auto-generated method stub
		return OrderItemMapper.insertSelective(record);
	}

	@Override
	public OrderItem selectByPrimaryKey(OrderItem record) {
		// TODO Auto-generated method stub
		return OrderItemMapper.selectByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(OrderItem record) {
		// TODO Auto-generated method stub
		return OrderItemMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(OrderItem record) {
		// TODO Auto-generated method stub
		return OrderItemMapper.updateByPrimaryKeySelective(record);
	}
	

	
}
