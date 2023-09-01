import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ClassName: TestJackson
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/1 17:23
 * Version 1.0
 */
class Student {
    public int classId;
    public int studentId;
}

public class TestJackson {
    public static void main(String[] args) throws JacksonException {
        ObjectMapper objectMapper = new ObjectMapper();
        //readValue 是把json 格式的字符串转成 Java 对象
//        String s = "{ \"classId\": 10, \"studentId\": 20}";
//        // readValue 第一个参数可以直接写个 String 也可以写个 InputStream.
//        Student student = objectMapper.readValue(s, Student.class);
//        System.out.println(student.classId);
//        System.out.println(student.studentId);

        // writeValue / writeValueAsString 是把 java 对象转成 json 字符串
        Student student = new Student();
        student.classId = 10;
        student.studentId = 20;
        String s = objectMapper.writeValueAsString(student);
        System.out.println(s);
    }
}
