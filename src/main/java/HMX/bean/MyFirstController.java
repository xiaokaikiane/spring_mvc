package HMX.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "/WEB-INF/pages/success.jsp";
    }
}
