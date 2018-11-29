package curs.ecenta.Controller;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import curs.ecenta.interfaces.Human;
import curs.ecenta.userBean.UserBean;
import curs.ecenta.userDAO.userDAO;

@Controller
public class UserController {

	@RequestMapping("/")//map on the root
	public String showHelloPage() {
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Human userBean = context.getBean("userBean",Human.class);
		System.out.println(userBean.getBehaviour());
		return "userPage";
	}
	
	@RequestMapping("/showUsers")
	public String showUsers(Model model ) {
		userDAO userDAO = new userDAO();
		ArrayList<UserBean> users= userDAO.getUser();
		model.addAttribute("users",users);
		return "usersList";
	}
}
