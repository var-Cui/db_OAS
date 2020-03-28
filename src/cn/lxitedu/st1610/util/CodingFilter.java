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
    	System.out.println("1)���������󴴽���");
    }


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("��������������");
	}


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("3)����������ִ�й������񡪡���������");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");		
		chain.doFilter(request,response);		
		System.out.println("5)����������ִ�й������񡪡�������Ӧ");
	}


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("2)���˳�ʼ������");
	}


}