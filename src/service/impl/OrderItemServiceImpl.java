package service.impl;

import model.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.inter.OrderItemService;
import dao.inter.OrderItemDao;
@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Autowired
	private OrderItemDao orderItemDao;

	@Override
	public int deleteByPrimaryKey(OrderItem record) {
		// TODO Auto-generated method stub
		return orderItemDao.deleteByPrimaryKey(record);
	}

	@Override
	public int insert(OrderItem record) {
		// TODO Auto-generated method stub
		return orderItemDao.insert(record);
	}

	@Override
	public int insertSelective(OrderItem record) {
		// TODO Auto-generated method stub
		return orderItemDao.insertSelective(record);
	}

	@Override
	public OrderItem selectByPrimaryKey(OrderItem record) {
		// TODO Auto-generated method stub
		return orderItemDao.selectByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(OrderItem record) {
		// TODO Auto-generated method stub
		return orderItemDao.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(OrderItem record) {
		// TODO Auto-generated method stub
		return orderItemDao.updateByPrimaryKeySelective(record);
	}

}
