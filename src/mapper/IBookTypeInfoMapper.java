package mapper;

import java.util.List;

import model.BookTypeInfo;

public interface IBookTypeInfoMapper {
	
	//得到所有图书类型
	public List<BookTypeInfo> getBookTypeList();
}
