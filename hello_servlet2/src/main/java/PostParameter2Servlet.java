import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;
import jdk.internal.util.xml.impl.Input;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: PostParameter2Servlet
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/7/31 12:32
 * Version 1.0
 */
class Student {
    public int studentId;
    public int classId;
}

@WebServlet("/postParameter2")
public class PostParameter2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过这个方法来处理 body 为 json 格式的数据
        //直接把 req 对象里 body 完整的读取出来
        //getInputStream
        //这个流对象中读多少个字节？ 取决于 Content-Length
//        int length = req.getContentLength();
//        byte[] buffer = new byte[length];
//
//        InputStream inputStream = req.getInputStream();
//        inputStream.read(buffer);
//
//        // 把这个字节数组构造成 string，打印出来
//        String body = new String(buffer, 0, length,"utf8");
//        System.out.println("body = " + body);
//        resp.getWriter().write(body);

        //使用 jackson 涉及到的核心对象.
        ObjectMapper objectMapper = new ObjectMapper();
        //readValue 就是把一个 json 格式的字符串转成 Java 对象
        Student student = objectMapper.readValue(req.getInputStream(), Student.class);
        System.out.println(student.studentId + ", " + student.classId);

        // resp.getWriter().write(body);
    }
}
