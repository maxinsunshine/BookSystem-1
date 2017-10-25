package dao.impl;

import java.util.List;

import mapper.UsersMapper;
import model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.inter.UsersDao;


@Repository
public class UsersDaoImpl implements UsersDao{
	
	@Autowired
	private UsersMapper UsersMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return UsersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Users record) {
		// TODO Auto-generated method stub
		return UsersMapper.insert(record);
	}

	@Override
	public int insertSelective(Users record) {
		// TODO Auto-generated method stub
		return UsersMapper.insertSelective(record);
	}

	@Override
	public Users selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return UsersMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Users record) {
		// TODO Auto-generated method stub
		return UsersMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Users record) {
		// TODO Auto-generated method stub
		return UsersMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return UsersMapper.getAllUsers();
	}

	@Override
	public int findUserExistCount(Users record) {
		// TODO Auto-generated method stub
		return UsersMapper.findUserExistCount(record);
	}

	@Override
	public Users login(String username, String password) {
		// TODO Auto-generated method stub
		return UsersMapper.login(username, password);
	}

	

	
}
