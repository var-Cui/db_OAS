package cn.lxitedu.st1610.util;


import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * Servlet Filter implementation class CodingFilter
 */
public class CodingFilter implements Filter {


    /**
     * Default constructor. 
     */
    public CodingFilter() {
    	System.out.println("1)过滤器对象创建了");
    }


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("过滤器被销毁了");
	}


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("3)过滤器正在执行过滤任务——过滤请求");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");		
		chain.doFilter(request,response);		
		System.out.println("5)过滤器正在执行过滤任务——过滤响应");
	}


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("2)过滤初始化方法");
	}


}