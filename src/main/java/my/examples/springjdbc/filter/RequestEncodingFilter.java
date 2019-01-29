package my.examples.springjdbc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-29
 * Github : https://github.com/YeoHoonYun
 */
@WebFilter(filterName = "reqeustencodingfilter", urlPatterns = {"/"})
public class RequestEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("실행???");
//        RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/main");
//        requestDispatcher.forward(servletRequest, servletResponse);
        ((HttpServletResponse) servletResponse).sendRedirect("/main");

    }

    @Override
    public void destroy() {

    }
}
