package site.bigbear.demo.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import site.bigbear.demo.constant.Constant;
import site.bigbear.demo.vo.Message;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 登录拦截器
 * @author cheyantao
 */
public class LoginInterceptor implements HandlerInterceptor {
    private static final String LOGIN_URL="login";
    private static final String ADMIN_URL_PRE_STRING="admin/";
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object
            o) throws Exception {
        String url = httpServletRequest.getRequestURI();
        if(url.contains(LOGIN_URL)){
            return true;
        }
        HttpSession session=httpServletRequest.getSession();
        if (session.getAttribute(Constant.CURRENT_USER_TAG)==null){
            Message notLoginMsg =Message.fail("用户未登录", Constant.ERROR_CODE_NOT_LOGIN);
            httpServletResponse.setContentType("application/json; charset=utf-8");
            PrintWriter writer = httpServletResponse.getWriter();
            writer.print(notLoginMsg.toString());
            writer.close();
            httpServletResponse.flushBuffer();
            return false;

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
