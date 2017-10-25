package mapper;

import java.util.List;

import model.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    
    //查询所有的用户
    List<Users> getAllUsers();
    
    //查询是否已经存在
    int findUserExistCount(Users record);
    
    //登录方法
    Users login(String username,String password);
}