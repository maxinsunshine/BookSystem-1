package mapper;

import java.util.List;

import model.Books;

public interface BooksMapper {
    int deleteByPrimaryKey(String booksid);

    int insert(Books record);

    int insertSelective(Books record);

    Books selectByPrimaryKey(String booksid);

    int updateByPrimaryKeySelective(Books record);

    int updateByPrimaryKey(Books record);
    
    List<Books> getAllBooks();
    //根据条件查询
    List<Books> searchBooks(String booksName);
}