package dao.inter;

import java.util.List;

import model.Users;

public interface UsersDao {
	
	int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
	
    List<Users> getAllUsers();
    
    int findUserExistCount(Users record);
    
    Users login(String username,String password);
	
}
