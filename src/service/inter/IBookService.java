package service.inter;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.BookInfo;
import model.BookTypeInfo;

public interface IBookService {
	
	//增加图书信息
	public boolean addBook(BookInfo bookInfo);
	//删除图书信息
	public boolean delBook(int id);
	//修改图书信息
	public boolean editBook(BookInfo bookInfo);
	//获取图书列表
	public List<BookInfo> getAllBook();
	//获取某本图书
	public BookInfo getBook(int id);
	//得到所有图书类型
	public List<BookTypeInfo> getBookTypeList();
	
}
