package com.atzhang.admin.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

/**
 * ログインチェック
 * 1. 创建拦截器，并去实现-》HandlerInterceptor，编写拦截器逻辑
 * 2. 将拦截器注册到web容器中，注册方法创建AdminWebConfig类，@Configuration 实现WebMvcConfigurer的addInterceptors（）方法
 * 3. 编写拦截规则，拦截器发生后，会把动静资源都会拦截到，因此需要把静态资源放行
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor{
	
	/**
	 * ターゲットメソッドが実行する前に
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { 
		
		String paths = request.getRequestURI();
		log.info("拦截的请求路径是{}", paths);
		
		HttpSession session = request.getSession();
		Object user = session.getAttribute("loginUser");
		if(user != null) {
			return true;
		}
		
		// ログインしない場合：ログイン画面に遷移
		request.setAttribute("msg", "ログインください。");
		// response.sendRedirect("/");
		request.getRequestDispatcher("/").forward(request, response);
		return false;
	}
	
	/**
	 *  ターゲットメソッドが実行する後に
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}
	
	/**
	 * 画面がテンプレートされる後
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
	}
	
	

}
