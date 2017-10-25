package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Books;
import model.Users;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.inter.UsersService;
import utils.Md5Utils;


@RequestMapping("users")
@Controller
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/usersList")
	/**
	 * 加载部分图书,用于首页模块显示
	 * @return
	 */
	public ModelAndView usersList(){
		List<Users> li = null;
		try{
			li =usersService.getAllUsers();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("user_all","list",li);
	}
	/**
	 * 新增
	 * @return
	 *//*
	public ModelAndView toAddUsers(HttpServletRequest request, HttpServletResponse response){
		
		
		return new ModelAndView("user_add");
	}
	
	@RequestMapping("doAddUsers")
	*//**
	 * 新增
	 * @return
	 *//*
	public ModelAndView doAddUsers(HttpServletRequest request, HttpServletResponse response){
		String UsersName = request.getParameter("searchName");//条件名称
		return new ModelAndView("user_add");
	}*/
	
	@RequestMapping("toEditUsers")
	/**
	 * 跳转去编辑页面
	 * @return
	 */
	public ModelAndView toEditUsers(HttpServletRequest request, HttpServletResponse response){
		String userid = request.getParameter("id");
		Users user = usersService.selectByPrimaryKey(Integer.valueOf(userid));
		return new ModelAndView("user_edit","user",user);
	}
	
	@RequestMapping("doEditUsers")
	/**
	 * 编辑用户
	 * @return
	 */
	public ModelAndView doEditUsers(HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView("user_edit");
	}
	
	
	@RequestMapping("deleteUsers")
	/**
	 * 删除用户
	 * @return
	 */
	public ModelAndView deleteUsers(HttpServletRequest request, HttpServletResponse response){
		String userid = request.getParameter("id");
		int count = usersService.deleteByPrimaryKey(Integer.valueOf(userid));
		if(count>0){
			System.out.println("删除成功");
		}
		return new ModelAndView("book_all");
	}
	
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping("regist")
	public ModelAndView regist(HttpServletRequest request, HttpServletResponse response){
		String msg = "";
		// 验证码
		String checkcode = request.getParameter("checkcode");

		String _checkcode = (String) request.getSession().getAttribute(
				"checkcode_session");

		request.getSession().removeAttribute("checkcode_session");
		if (_checkcode == null || (!_checkcode.equals(checkcode))) {
			/*request.setAttribute("regist.message", "��֤�벻��ȷ");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;*/
			msg = "验证码不正确ȷ";
			return new ModelAndView("regist","msg", msg);
		}

		// 
		Users user = new Users();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// 获取
		String userName = request.getParameter("username");//用户名
		String password = request.getParameter("password");//密码
		String nickname = request.getParameter("nickname");//昵称
		String email = request.getParameter("email");//邮箱

		
		if (userName == null || userName.trim().isEmpty()) {
			msg = "用户名不能为空";
			return new ModelAndView("regist","msg", msg);
		}

		if (password == null || password.trim().isEmpty()) {
			msg = "密码不能为空";
			return new ModelAndView("regist","msg", msg);
		}

		if (nickname == null || nickname.trim().isEmpty()) {
			msg = "昵称不能为空";
			return new ModelAndView("regist","msg", msg);
		}

		if (email == null || email.trim().isEmpty()) {
			msg = "邮箱不能为空";
			return new ModelAndView("regist","msg", msg);
		}
		user.setUsername(userName);
		
		int count = usersService.findUserExistCount(user);
		if(count>0){
			msg = "该用户已存在";
			return new ModelAndView("regist","msg", msg);
		}
        user.setPassword(Md5Utils.md5(password));
        user.setUpdatetime(new Date());//更新时间
        
		user.setNickname(nickname);
		
		int count2 = usersService.findUserExistCount(user);
		if(count2>0){
			msg = "该昵称已存在";
			return new ModelAndView("regist","msg", msg);
		}
		user.setEmail(email);
		//保存一个激活码
		user.setActivecode(UUID.randomUUID().toString());
		user.setRole("user");//普通注册规定用户角色
		user.setState(1);//用户为激活状态

		usersService.insertSelective(user);

		/*try {
			response.getWriter().write(
					"ע��ɹ�����<a href='" + request.getContextPath()
							+ "/index.jsp'>��¼</a>");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return new ModelAndView("success");
	}
	
	@RequestMapping("checkIsExist")
	/**
	 * 登录时校验用户是否存在
	 * @return
	 */
	public Map<String, Object> checkIsExist(HttpServletRequest request, HttpServletResponse response){
		String userName = request.getParameter("username");
		Map<String, Object> map = new HashMap<String, Object>();
		Users user = new Users();
		user.setUsername(userName);
		int count = usersService.findUserExistCount(user);
		if(count==0){
			map.put("success", false);
			map.put("msg", "该用户不存在");
		}
		return map;
	}
	
	@RequestMapping("success")
	/**
	 * 注册成功后跳转成功页面
	 * @return
	 */
	public ModelAndView success(){
		
		return new ModelAndView("success");
	}
	
	@RequestMapping("successLogin")
	/**
	 * 登录成功后跳转的页面
	 * @return
	 */
	public ModelAndView successLogin(){
		
		return new ModelAndView("successLogin");
	}
	
	
	
	@RequestMapping("checkcode")
	/**
	 * 加载验证码
	 * @return
	 */
	public void checkcode(HttpServletRequest request, HttpServletResponse response){
		List<String> words = new ArrayList<String>();
		
		String path = request.getRealPath("/WEB-INF/new_words.txt");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(path), "utf-8"));
			String line;
			while ((line = reader.readLine()) != null) {
				words.add(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int width = 120;
		int height = 30;

		// ����һ ����һ���ڴ���ͼƬ
		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// ����� ͼƬ���Ʊ�����ɫ ---ͨ���ͼ����
		Graphics graphics = bufferedImage.getGraphics();// �õ���ͼ���� --- ����
		// �����κ�ͼ��֮ǰ ������ָ��һ����ɫ
		graphics.setColor(getRandColor(200, 250));
		graphics.fillRect(0, 0, width, height);

		// ������ ���Ʊ߿�
		graphics.setColor(Color.WHITE);
		graphics.drawRect(0, 0, width - 1, height - 1);

		// ������ �ĸ��������
		Graphics2D graphics2d = (Graphics2D) graphics;
		// �����������
		graphics2d.setFont(new Font("����", Font.BOLD, 18));

		Random random = new Random();// ��������
		int index = random.nextInt(words.size());
		String word = words.get(index);// ��ó���

		// ����x���
		int x = 10;
		for (int i = 0; i < word.length(); i++) {
			// �����ɫ
			graphics2d.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			// ��ת -30 --- 30��
			int jiaodu = random.nextInt(60) - 30;
			// ���㻡��
			double theta = jiaodu * Math.PI / 180;

			// �����ĸ����
			char c = word.charAt(i);

			// ��c �����ͼƬ
			graphics2d.rotate(theta, x, 20);
			graphics2d.drawString(String.valueOf(c), x, 20);
			graphics2d.rotate(-theta, x, 20);
			x += 30;
		}

		// ����֤�����ݱ���session
		request.getSession().setAttribute("checkcode_session", word);

		System.out.println(word);


		// ������ͼƬ���������� ImageIO
		graphics.dispose();// �ͷ���Դ
		try {
			ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param fc
	 * @param bc
	 * @return Color
	 */
	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	
	
}
