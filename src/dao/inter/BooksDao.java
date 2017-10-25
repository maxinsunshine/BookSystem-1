package dao.inter;

import java.util.List;

import model.Books;

public interface BooksDao {
	
	int deleteByPrimaryKey(String booksid);

    int insert(Books record);

    int insertSelective(Books record);

    Books selectByPrimaryKey(String booksid);

    int updateByPrimaryKeySelective(Books record);

    int updateByPrimaryKey(Books record);
    
    List<Books> getAllBooks();
    
    List<Books> searchBooks(String booksName);
	
	
}
