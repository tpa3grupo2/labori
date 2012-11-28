package filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mb.MessageBean;
import mb.UserBean;

@WebFilter("/user/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        UserBean userBean = (UserBean) req.getSession().getAttribute("userBean");
        MessageBean messageBean = (MessageBean) req.getSession().getAttribute("messageBean");

        if (userBean != null && userBean.isLogged())
            chain.doFilter(request, response);
        else {
            //messageBean.addMessage("Você precisa estar logado para acessar a página requisitada!", "error");
            res.sendRedirect(req.getContextPath() + "/index.xhtml");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}