import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
* ClassName: HelloServlet
* Package: PACKAGE_NAME
* Description:
* @Author 全家乐
* @Create 2023/7/28 21:17
* Version 1.0
*/
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这个方法一定要干掉，父类里的这个方法只是返回了一个错误页面~
       // super.doGet(req, resp);

        //这个是在服务器的控制台里打印
        System.out.println("hello world");
        //要想吧 hello world 返回到客户端，需要使用下面的代码
        //getWriter 会得到一个 Writer 对象
        resp.getWriter().write("hello world");
    }
}

