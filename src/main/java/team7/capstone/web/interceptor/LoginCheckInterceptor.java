package team7.capstone.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import team7.capstone.web.SessionConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /**
         * 컨트롤러 호출 시 실행되는 로직 ( /login, /join 제외 )
         * session 정보와 session의 user_seq를 읽을 수 없을 경우
         * 로그인이 안된 유저로 간주하여 컨트롤러 흐름 차단
         */
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute(SessionConst.LOGIN_USER) == null) {
            PrintWriter w = response.getWriter();
            w.write("not login user"); w.flush(); w.close();
            return false;
        }
        return true;
    }

}
