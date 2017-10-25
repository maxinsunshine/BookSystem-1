package test;
import java.util.List;

import model.BookInfo;
import model.BookTypeInfo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.inter.IBookService;
public class BookTest {

	//测试新增图书信息
	@Test
	public void addBook(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("beans.xml");
		IBookService bs = ac.getBean("bookServiceImpl",IBookService.class);
		BookInfo bi  = new BookInfo();
		bi.setAuthor("藤子不二雄3");
		bi.setBookName("机器猫");
		BookTypeInfo bti = new BookTypeInfo();
		bti.setId(5);
		bi.setBookTypeInfo(bti);
		bi.setPrice(35.5);
		try{
			bs.addBook(bi);
			System.out.println("ok");
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
	//测试更改图书信息
	@Test
	public void updateBook(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("beans.xml");
		IBookService bs = ac.getBean("bookServiceImpl",IBookService.class);
		BookInfo bi  = new BookInfo();
		bi.setId(5);
		bi.setAuthor("测试3");
		bi.setBookName("机器猫");
		BookTypeInfo bti = new BookTypeInfo();
		bti.setId(5);
		bi.setBookTypeInfo(bti);
		bi.setPrice(35.5);
		try{
			bs.editBook(bi);
			System.out.println("ok");
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
	//测试查询所有图书
	@Test
	public void selAllBook(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("beans.xml");
		IBookService bs = ac.getBean("bookServiceImpl",IBookService.class);
		try{
			List<BookInfo> li =bs.getAllBook();
			for(BookInfo bi:li){
				System.out.println(bi.getAuthor()+"   :"+bi.getBookName()+"  "+bi.getBookTypeInfo().getBookTypeName());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//测试查找指定图书
	@Test
	public void getOneBook(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("beans.xml");
		IBookService bs = ac.getBean("bookServiceImpl",IBookService.class);
		try{
			BookInfo bi =null;
			bi =bs.getBook(2);
			if(bi!=null)
			System.out.println(bi.getAuthor()+"   :"+bi.getBookName());
			else 
				System.out.println("kong ");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//测试删除特定图书
	@Test
	public void delBook(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("beans.xml");
		IBookService bs = ac.getBean("bookServiceImpl",IBookService.class);
		try{
			boolean flag =false;
			flag =bs.delBook(5);
			if(flag)
				System.out.println("删除成功");
			else 
				System.out.println("删除失败");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//得到所有图书类型
	@Test
	public void  getAllType(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("beans.xml");
		IBookService bs = ac.getBean("bookServiceImpl",IBookService.class);
		try{
			List<BookTypeInfo> list = bs.getBookTypeList();
			for(BookTypeInfo bti :list){
				System.out.println(bti.getId()+"  :" +bti.getBookTypeName());
			}
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
}
