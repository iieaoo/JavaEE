import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: StatusServket
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/1 10:21
 * Version 1.0
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setStatus(404);
//        // 但是这里不设置 body
//        resp.setContentType("text/html;charset=UTF8");
//        resp.getWriter().write("<h1>404 没找到 </h1>");

        // 返回 tomcat 自带的错误页面
        resp.sendError(404);
    }
}
