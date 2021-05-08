package com.zyh.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Zyh
 * @date 2020/12/24/0024 13:03
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession();
        String path = request.getRequestURI();
        // 没有userName为空就转发到登陆页面
        if (path.contains("login")){
            chain.doFilter(req, resp);
        } else if(session.getAttribute("userSession")==null){
            request.getRequestDispatcher("/jsp/401.jsp").forward(request,response);
//            response.sendRedirect(request.getContextPath()+"/index.jsp");  //重定向就相当于地址栏输入 也不能随便访问jsp
        }else{
            // 不为空，就继续请求下一级资源（继续访问）
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
