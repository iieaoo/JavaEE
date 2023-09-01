import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * ClassName: ShowRequestServlet
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/7/30 17:54
 * Version 1.0
 */
@WebServlet("/showRequest")
public class ShowRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 这里是设置响应的 content-type，告诉浏览器，响应 body 里的数据格式是啥样的
        resp.setContentType("text/html");

        // 搞个 StringBuilder,把这些 api 的结果拼起来，统一写回到响应中
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(req.getProtocol());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getMethod());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getRequestURI());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getContextPath());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getQueryString());
        stringBuilder.append("<br>");
        stringBuilder.append("<br>");
        stringBuilder.append("<br>");
        stringBuilder.append("<br>");

        //获取到 header 中所有的键值对
        Enumeration<String>  headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            stringBuilder.append(headerName + ": " + req.getHeader(headerName));
            stringBuilder.append("<br>");
        }

        resp.getWriter().write(stringBuilder.toString());
    }
}
