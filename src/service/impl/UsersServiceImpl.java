package service.impl;

import java.util.List;

import model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.inter.UsersService;
import dao.inter.UsersDao;
@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersDao usersDao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return usersDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Users record) {
		// TODO Auto-generated method stub
		return usersDao.insert(record);
	}

	@Override
	public int insertSelective(Users record) {
		// TODO Auto-generated method stub
		return usersDao.insertSelective(record);
	}

	@Override
	public Users selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return usersDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Users record) {
		// TODO Auto-generated method stub
		return usersDao.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Users record) {
		// TODO Auto-generated method stub
		return usersDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return usersDao.getAllUsers();
	}

	@Override
	public int findUserExistCount(Users record) {
		// TODO Auto-generated method stub
		return usersDao.findUserExistCount(record);
	}

	@Override
	public Users login(String username, String password) {
		// TODO Auto-generated method stub
		return usersDao.login(username, password);
	}
	

}
