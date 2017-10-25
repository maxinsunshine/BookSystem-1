package service.impl;

import java.util.List;

import model.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.inter.BooksService;
import dao.inter.BooksDao;
@Service
public class BooksServiceImpl implements BooksService {
	@Autowired
	private BooksDao booksDao;

	@Override
	public int deleteByPrimaryKey(String booksid) {
		// TODO Auto-generated method stub
		return booksDao.deleteByPrimaryKey(booksid);
	}

	@Override
	public int insert(Books record) {
		// TODO Auto-generated method stub
		return booksDao.insert(record);
	}

	@Override
	public int insertSelective(Books record) {
		// TODO Auto-generated method stub
		return booksDao.insertSelective(record);
	}

	@Override
	public Books selectByPrimaryKey(String booksid) {
		// TODO Auto-generated method stub
		return booksDao.selectByPrimaryKey(booksid);
	}

	@Override
	public int updateByPrimaryKey(Books record) {
		// TODO Auto-generated method stub
		return booksDao.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Books record) {
		// TODO Auto-generated method stub
		return booksDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Books> getAllBooks() {
		// TODO Auto-generated method stub
		return booksDao.getAllBooks();
	}

	@Override
	public List<Books> searchBooks(String booksName) {
		// TODO Auto-generated method stub
		return booksDao.searchBooks(booksName);
	}
	

}
