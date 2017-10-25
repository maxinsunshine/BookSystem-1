package dao.impl;

import java.util.List;

import mapper.IBookInfoMapper;
import model.BookInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.inter.IBookInfoDao;

@Repository
public class BookInfoDaoImpl implements IBookInfoDao{

	//具体由我们配置好的mybatis的mapper来实现
	@Autowired
	private IBookInfoMapper iBookInfoMapper;
	@Override
	public boolean addBook(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return iBookInfoMapper.addBook(bookInfo);
	}

	@Override
	public boolean delBook(int id) {
		// TODO Auto-generated method stub
		return iBookInfoMapper.delBook(id);
	}

	@Override
	public boolean editBook(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return iBookInfoMapper.editBook(bookInfo);
	}

	@Override
	public List<BookInfo> getAllBook() {
		// TODO Auto-generated method stub
		return iBookInfoMapper.getAllBook();
	}

	@Override
	public BookInfo getBook(int id) {
		// TODO Auto-generated method stub
		return iBookInfoMapper.getBook(id);
	}

	
}
