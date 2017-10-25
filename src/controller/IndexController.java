package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Books;
import model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.inter.BooksService;
import service.inter.UsersService;
import utils.Md5Utils;


@RequestMapping("indexs")
@Controller
public class IndexController {
	
	@Autowired
	private BooksService booksService;
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("logout")
	/**
	 * 注销
	 * @return
	 */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
		
		List<Books> li =booksService.getAllBooks().subList(0,4);
		request.getSession().invalidate(); // 销毁session
		return new ModelAndView("book_list","list",li);
		
	}
	
	@RequestMapping("/login")
	/**
	 * 登录
	 * @return
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		List<Books> li =booksService.getAllBooks().subList(0,4);
		if(username==null||"".equals(username)){
			request.setAttribute("login.message", "用户名不能为空");
			return new ModelAndView("book_list","list",li);
		}
		if(password==null||"".equals(password)){
			request.setAttribute("login.message", "密码不能为空");
			return new ModelAndView("book_list","list",li);
		}
		
		String newPassword = Md5Utils.md5(password);
		Users user = usersService.login(username, newPassword);
		if(user!=null){
			request.getSession().invalidate();
//			ModelAndView model = new ModelAndView("successLogin","user",user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("book_list","list",li);
		}else{
			request.setAttribute("login.message", "用户名或密码错误");
			return new ModelAndView("book_list","list",li);
		}
	}
	
}
