package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * ClassName: IndexServlet
 * Package: login
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/2 9:15
 * Version 1.0
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先判定用户的登录状态
        // 如果用户还没登录，要求先登录
        // 已经登陆了，则根据 会话 中的用户名，来显示到页面上。
        // 这个操作不会触发会话的创建
        HttpSession session = req.getSession(false);
        if (session == null) {
            // 未登录状态
            System.out.println("用户未登录");
            resp.sendRedirect("login.html");
            return;
        }
        // 已经登录
        String username = (String) session.getAttribute("username");
        // 构造页面
        resp.setContentType("text/html; Charset=utf8");
        resp.getWriter().write("欢迎" + username + "回来!");
    }
}
