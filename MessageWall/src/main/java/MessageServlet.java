import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.DCMPG;
import sun.nio.cs.ext.IBM037;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MessageServlet
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/1 12:36
 * Version 1.0
 */

class Message {
    public String from;
    public String to;
    public String message;
}

@WebServlet("/message")
public class MessageServlet extends HttpServlet {

    //使用这个 List 变量保存多有消息
   // private List<Message> messageList = new ArrayList<>();
    private  ObjectMapper objectMapper = new ObjectMapper();

    // 向服务器提交数据
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //把 body 里的内容读出来解析成 message 对象
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
        //此处通过简单粗暴的方式来完成保存
        //messageList.add(message);
        save(message);
        //此处的设定状态码可以省略，不设置默认也是 200
        resp.setStatus(200);
    }

    // 从服务器获取数据
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //显示告诉浏览器，数据是 json 格式的，字符集是 utf8 的
        resp.setContentType("application/json; charset=utf8");
        //objectMapper.writeValue(resp.getWriter(), messageList);
        //把 java 对象转成 json 字符串
        List<Message> messageList = load();
        String jsonResp = objectMapper.writeValueAsString(messageList);
        System.out.println("jsonResp " + jsonResp);
        //把这个字符串写回到响应 body 中
        resp.getWriter().write(jsonResp);
    }

    //提供一对方法
    //往数据库中存一条消息
    private void save(Message message) {
        //基本的 JDBC 操作
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1、建立连接
            connection = DBUtil.getConnection();
            // 2、构造 SQL 语句
            String sql = "insert  into message values(?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,message.from);
            statement.setString(2,message.to);
            statement.setString(3,message.message);
            // 3、执行sql
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4、关闭连接
            DBUtil.close(connection, statement, null);
        }
    }

    //从数据库取所有消息
    private List<Message> load() {
        List<Message> messageList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 1、和数据库建立连接
            connection = DBUtil.getConnection();
            // 2、构造 SQL
            String sql = "select * from message";
            statement = connection.prepareStatement(sql);
            // 3、执行 SQL
            resultSet = statement.executeQuery();
            // 4、遍历结果集合
            while (resultSet.next()) {
                Message message = new Message();
                message.from = resultSet.getString("from");
                message.to = resultSet.getString("to");
                message.message = resultSet.getString("message");
                messageList.add(message);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5、 需要释放资源，断开连接
            DBUtil.close(connection,statement,resultSet);
        }
        return messageList;
    }
}
