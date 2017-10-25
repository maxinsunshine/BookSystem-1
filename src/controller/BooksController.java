package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.inter.BooksService;


@RequestMapping("books")
@Controller
public class BooksController {
	
	@Autowired
	private BooksService booksService;
	
	@RequestMapping("/booksList")
	/**
	 * 加载部分图书,用于首页模块显示
	 * @return
	 */
	public ModelAndView booksList(){
		List<Books> li = null;
		try{
			li =booksService.getAllBooks().subList(0,4);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("book_list","list",li);
	}
	@RequestMapping("/booksAll")
	/**
	 * 加载全部的图书
	 * @return
	 */
	public ModelAndView booksAll(){
		List<Books> li = null;
		try{
			li =booksService.getAllBooks();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("book_all","list",li);
	}
	
	@RequestMapping("/bookDetail")
	/**
	 * 详情
	 * @param bi
	 * @return
	 */
	public ModelAndView  bookDetail(String booksid){
		Books books = null;
		try{
			books = booksService.selectByPrimaryKey(booksid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("book_detail","book",books);
	}
	
	@RequestMapping("searchBooks")
	/**
	 * 搜索
	 * @return
	 */
	public ModelAndView searchBooks(HttpServletRequest request, HttpServletResponse response){
		List<Books> li=null;
		String booksName = request.getParameter("searchName");//条件名称
		try{
			li =booksService.searchBooks(booksName);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("book_all","list" ,li);
	}
	
	@RequestMapping("toAddBooks")
	/**
	 * 新增
	 * @return
	 */
	public ModelAndView toAddBooks(HttpServletRequest request, HttpServletResponse response){
		List<String> list = new ArrayList<String>();
		list.add("玄幻小说");
		list.add("现代文学小说");
		list.add("都市言情");
		list.add("历史文献");
		list.add("政治纲要");
		
		return new ModelAndView("book_add","list",list);
	}
	
	@RequestMapping("doAddBooks")
	/**
	 * 新增
	 * @return
	 */
	public ModelAndView doAddBooks(HttpServletRequest request, HttpServletResponse response){
		String booksName = request.getParameter("searchName");//条件名称
		return new ModelAndView("book_add");
	}
	
	@RequestMapping("toEditBooks")
	/**
	 * 跳转去编辑页面
	 * @return
	 */
	public ModelAndView toEditBooks(HttpServletRequest request, HttpServletResponse response){
		String booksid = request.getParameter("id");
		Books book = booksService.selectByPrimaryKey(booksid);
		return new ModelAndView("book_edit","book",book);
	}
	
	@RequestMapping("doEditBooks")
	/**
	 * 编辑图书
	 * @return
	 */
	public ModelAndView doEditBooks(HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView("book_edit");
	}
	
	
	@RequestMapping("deleteBooks")
	/**
	 * 跳转去编辑页面
	 * @return
	 */
	public ModelAndView deleteBooks(HttpServletRequest request, HttpServletResponse response){
		String booksid = request.getParameter("id");
		int count = booksService.deleteByPrimaryKey(booksid);
		if(count>0){
			System.out.println("删除成功");
		}
		return new ModelAndView("book_all");
	}
	
	/*@RequestMapping("toaddBook")
	*//**
	 * ��ȡ����ͼ�����Ͳ�ת��ҳ��
	 * @return
	 *//*
	public ModelAndView toAddBookView(){
		List<BookTypeInfo> li=null;
		try{
			li =booksService.getBookTypeList();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("book_add","list" ,li);
	}
	
	@RequestMapping("addBook")
	*//**
	 * ͼ������
	 * @param bi
	 * @return
	 *//*
	public String  toAddBookView(BookInfo bi){
		try{
			System.out.println(bi.getBookName());
			bookService.addBook(bi);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:bookList";
	}
	@RequestMapping("toEditBook")
	*//**
	 * �������������ͼ�������뵽requestȻ��ת��toEdit
	 * @param id
	 * @param redirectAttributes
	 * @return
	 *//*
	public String toEditBook(int id ,RedirectAttributes redirectAttributes){
		
		BookInfo bi =bookService.getBook(id);
		//�൱������ε�request�����һ������
		redirectAttributes.addFlashAttribute("book",bi);
		
		return "redirect:toEdit";
	}
	@RequestMapping("toEdit")
	*//**
	 * ��ȡͼ������Ȼ��ת��book_editҳ��
	 * @return
	 *//*
	public ModelAndView toEditBook(){
		List<BookTypeInfo> li=null;
		try{
			li =bookService.getBookTypeList();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("book_edit","list" ,li);
	}
	@RequestMapping("editBook")
	@ResponseBody
	*//**
	 * �޸ķ���
	 * @param book
	 * @return
	 *//*
	public String editBook(BookInfo book){
		try{
			bookService.editBook(book);
			return "succeed";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "falied";
	}
	@RequestMapping("delBook")
	*//**
	 * ɾ��
	 * @param id
	 * @return
	 *//*
	public String delBook(int id){
		boolean flag=false;
		try{
			bookService.delBook(id);
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		if(flag){
			return "redirect:bookList";
		}else{
			return "failed_delete";
		}
	}*/
}
