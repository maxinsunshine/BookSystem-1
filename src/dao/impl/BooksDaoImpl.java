package dao.impl;

import java.util.List;

import mapper.BooksMapper;
import model.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.inter.BooksDao;

@Repository
public class BooksDaoImpl implements BooksDao{
	
	@Autowired
	private BooksMapper BooksMapper;

	@Override
	public int deleteByPrimaryKey(String booksid) {
		// TODO Auto-generated method stub
		return BooksMapper.deleteByPrimaryKey(booksid);
	}

	@Override
	public int insert(Books record) {
		// TODO Auto-generated method stub
		return BooksMapper.insert(record);
	}

	@Override
	public int insertSelective(Books record) {
		// TODO Auto-generated method stub
		return BooksMapper.insertSelective(record);
	}

	@Override
	public Books selectByPrimaryKey(String booksid) {
		// TODO Auto-generated method stub
		return BooksMapper.selectByPrimaryKey(booksid);
	}

	@Override
	public int updateByPrimaryKey(Books record) {
		// TODO Auto-generated method stub
		return BooksMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Books record) {
		// TODO Auto-generated method stub
		return BooksMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Books> getAllBooks() {
		// TODO Auto-generated method stub
		return BooksMapper.getAllBooks();
	}

	@Override
	public List<Books> searchBooks(String booksName) {
		// TODO Auto-generated method stub
		return BooksMapper.searchBooks(booksName);
	}

	

	
}
