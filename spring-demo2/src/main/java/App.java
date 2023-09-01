import com.demo.component.ArticleController;
import com.demo.component.BController;
import com.demo.component.UserComponent;
import com.demo.component.aController;
import com.demo.controller.StudentController;
import com.demo.controller.UserAdviceController;
import com.demo.controller.UserController;
import com.demo.model.Student;
import javafx.application.Application;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;

import javax.naming.Context;
import java.beans.Introspector;

/**
 * ClassName: App
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/15 14:37
 * Version 1.0
 */
public class App {
    public static void main(String[] args) {

//        BeanFactory context = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
//        System.out.println("得到 Spring 之后");
       //1、先得到 Spring 对象
       ApplicationContext context =
               new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println("得到 Spring 之后");
//       //2、从 Spring 中取出 Bean 对象
//       User user = (User) context.getBean("user");//根据 bean 的名称（标识）来得到 Bean 对象
//       User user = context.getBean(User.class);//根据 bean 的类型获取 Bean
//       User user = context.getBean("user",User.class);//根据 Bean 名称+Bean 类型 或 Bean 对象
//       //3、使用 Bean（可选）
//       System.out.println(user.sayHi());

//        ArticleController articleController = context.getBean("articleController",
//                ArticleController.class);
//        System.out.println(articleController.sayHello());

//        aController controller = context.getBean("aController",
//                aController.class);
//        System.out.println(controller.sayHi());

//        BController controller = context.getBean("BController",
//                BController.class);
//        System.out.println(controller.sayHi());

//        String s1 = "UserInfo";
//        System.out.println(Introspector.decapitalize("s1: " + s1));
//
//        String s2 = "UserInfo";
//        System.out.println(Introspector.decapitalize("s2: " + s2));
//
//        String s3 = "UserInfo";
//        System.out.println(Introspector.decapitalize("s3: " + s3));

//        UserComponent component = context.getBean("userComponent",UserComponent.class);
//        System.out.println(component.sayHi());

//        User user = context.getBean("user",User.class);
//        System.out.println(user.sayHi());

//        Student student= context.getBean("s2", Student.class);
//        System.out.println(student);

//        StudentController sc = context.getBean("studentController", StudentController.class);
//        sc.sayHi();

        UserController uc = context.getBean("userController", UserController.class);
        uc.getUser();

        UserAdviceController ua = context.getBean("userAdviceController",UserAdviceController.class);
        ua.getUser();

    }
}
