package service.impl;

import java.util.List;

import model.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.inter.OrdersService;
import dao.inter.OrdersDao;
@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersDao ordersDao;

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return ordersDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Orders record) {
		// TODO Auto-generated method stub
		return ordersDao.insert(record);
	}

	@Override
	public int insertSelective(Orders record) {
		// TODO Auto-generated method stub
		return ordersDao.insertSelective(record);
	}

	@Override
	public Orders selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return ordersDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Orders record) {
		// TODO Auto-generated method stub
		return ordersDao.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Orders record) {
		// TODO Auto-generated method stub
		return ordersDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return ordersDao.getAllOrders();
	}
	

}
