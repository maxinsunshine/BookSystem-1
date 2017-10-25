package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mapper.IBookTypeInfoMapper;
import model.BookTypeInfo;
import dao.inter.IBookTypeInfoDao;

@Repository
public class BookTypeInfoDaoImpl implements IBookTypeInfoDao{

	@Autowired
	private IBookTypeInfoMapper iBookTypeInfoMapper;
	@Override
	public List<BookTypeInfo> getBookTypeList() {
		// TODO Auto-generated method stub
		return iBookTypeInfoMapper.getBookTypeList();
	}

}
