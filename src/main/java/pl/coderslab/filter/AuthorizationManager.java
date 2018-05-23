package pl.coderslab.filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorizationManager implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession sess = request.getSession();
        Long user_id = (Long) sess.getAttribute("user_id");
        if (user_id!=null) {
            return true;    //true = allow handler to map url with get/post method of the controller
        } else {
            response.sendRedirect("/login");
        }
        return false;   //false = do not allow to handle this request if not logged (no user_id session attribute). Redirect to /login (see above)
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object o,
                                Exception e) throws Exception {

    }
}
