package HMX.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/haha")
@Controller
public class RequestMappingController {
    @RequestMapping("hello1")
    public String hello(){
        System.out.println("RequestMapping---hello1");
        return "success";
    }

    /**
     * RequestMapping的而其他属性
     * method  限定请求方式(get,post)  默认是全部接受(get,post,put,delete,head...)
     * params  规定请求参数
     *       params=XXX,表示请求必须带上名为xxx的参数  eg:params={"username"}   ,可以写多个
     *       同理 !params=xxx  不能包含
     * headers  规定请求头
     *
     * consumes  只接收内容类型是哪种的请求, Content-Type
     * produces  告诉浏览器返回的内容类型是什么,给响应头加上Content-Type
     * @return
     */
    @RequestMapping(value ="handle",method = RequestMethod.POST)
    public String handle(){
        return "success";
    }

    @RequestMapping(value ="/handle01",params ={"username"} )
    public String handle01(){
        return "success";
    }

    @RequestMapping(value ="/handle02")
    public String handle02(){
        return "success";
    }
}
