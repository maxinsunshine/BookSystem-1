package dao.inter;

import java.util.List;

import model.BookTypeInfo;

public interface IBookTypeInfoDao {

	//得到所有图书类型
		public List<BookTypeInfo> getBookTypeList();
}
