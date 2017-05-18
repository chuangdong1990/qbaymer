package com.optimus.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.optimus.common.ValidateCode;
@Controller
public class LoginController {


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin(Model model) {
		return "login";// WEB-INF/jsp/"list".jsp
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> submit(String username, String password, HttpSession session, HttpServletRequest request) {
		Map<String,Object> resMap =new HashMap<String,Object>();

		Subject currentUser = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken(username, password);

		token.setRememberMe(true);
		try {
			currentUser.login(token);
		} catch (UnknownAccountException ace) {
			token.clear();
			resMap.put("succ", false);
			resMap.put("msg", "用户名或密码错误！");
			return resMap;
		} catch (AuthenticationException e) {
			token.clear();
			resMap.put("succ", false);
			resMap.put("msg", "用户名或密码错误！");
			return resMap;
		} catch (ParseException e) {
			token.clear();
			resMap.put("succ", false);
			resMap.put("msg", "用户名或密码错误！");
			return resMap;
		}
		if (currentUser.isAuthenticated()) {
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			resMap.put("succ", true);
			resMap.put("msg", "登录成功");
		} else {
			token.clear();
			resMap.put("succ", false);
			resMap.put("msg", "用户名或密码错误！");
		}
		return resMap;
	}
	@RequestMapping(value = "/toIndex", method = RequestMethod.GET)
	public String toIndex(Model model) {
		return "index";// WEB-INF/jsp/"list".jsp
	}
	/**
	 * 输出图形验证码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getCodeImage", method = RequestMethod.GET)
	public void getCodeImage(HttpServletRequest reqeust,
			HttpServletResponse response) {
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		try {
			HttpSession session = reqeust.getSession();

			ValidateCode vCode = new ValidateCode(160, 40, 5, 100);
			session.setAttribute("user_code", vCode.getCode());
			vCode.write(response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
