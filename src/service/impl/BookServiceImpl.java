package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.inter.IBookInfoDao;
import dao.inter.IBookTypeInfoDao;

import model.BookInfo;
import model.BookTypeInfo;
import service.inter.IBookService;
@Service
public class BookServiceImpl implements IBookService {
	@Autowired
	private IBookInfoDao iBookInfoDao;
	@Autowired
	private IBookTypeInfoDao iBookTypeInfoDao;
	@Override
	public boolean addBook(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return iBookInfoDao.addBook(bookInfo);
	}

	@Override
	public boolean delBook(int id) {
		// TODO Auto-generated method stub
		return iBookInfoDao.delBook(id);
	}

	@Override
	public boolean editBook(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return iBookInfoDao.editBook(bookInfo);
	}

	@Override
	public List<BookInfo> getAllBook() {
		// TODO Auto-generated method stub
		return iBookInfoDao.getAllBook();
	}

	@Override
	public BookInfo getBook(int id) {
		// TODO Auto-generated method stub
		return iBookInfoDao.getBook(id);
	}

	@Override
	public List<BookTypeInfo> getBookTypeList() {
		// TODO Auto-generated method stub
		return iBookTypeInfoDao.getBookTypeList();
	}

}
