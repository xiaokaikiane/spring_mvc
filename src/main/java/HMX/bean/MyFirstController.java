package HMX.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 执行细节:
 * 一.运行流程
 *   1).客户端点击链接会发送hello请求
 *   2).来到tomcat服务器
 *   3).SpringMVC前端控制器收到所有请求
 *   4).来看请求地址和@RequestMapping注解和哪个匹配,来找到到底使用哪个类的哪个方法
 *   5).前端控制器找到了目标处理器类和目标方法,直接利用反射执行目标方法
 *   6).方法执行完以后会有一个返回值,springMVC认为这个返回值就是要去的页面地址
 *   7).拿到方法返回值以后,用视图解析器进行拼串得到完整的地址
 *   8).拿到页面地址,前端控制器帮我们转发到页面
 * 二.@RequestMapping
 *    告诉SpringMVC,这个方法用来处理什么请求
 *    标注在方法上,即找到对应的方法
 *    标注到类上,就相当于给整个类的方法都加有对应的路径
 * 三.如果不指定配置文件位置?
 *    会在web-inf目录下找 你的Servlrt名字+ --Servlet.xml
 *    只需要在web-inf目录下创建  你的Servlrt名字+ --Servlet.xml
 */

/**
 * 标识这是个控制器
 */
@Controller
public class MyFirstController {

    /**
     *处理当前项目下的hello请求
     */
    @RequestMapping("/hello")
    public String myFirstRequest(){
        System.out.println("请求收到,处理中");
        return "success";
    }
    @RequestMapping("/hello2")
    public String hello(){
        System.out.println("请求收到,处理中");
        return "error";
    }

}
