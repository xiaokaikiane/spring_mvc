package HMX.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @RequestMapping模糊匹配功能
 * 模糊匹配统配符:
 *  ?  替代任意一个字符
 *  * 代替任意多个字符和一层路径
 *  **  代替多层路径
 *
 *
 *
 */
@Controller
public class RequestMappingTest {
    @RequestMapping("/antTest01")
    public String antTest01(){
        return "success";
    }

    @RequestMapping("antTest0?")
    public String antTest02(){
        return "success";
    }

    /**
     * 路径上可以使用占位符
     * @return
     */
    @RequestMapping("/user/{id}")
    public String pathVaiableTest(@PathVariable("id")String id){
        System.out.println("路径上的占位符的值"+id);
        return "success";
    }

    /**
     * 获取请求参数的方法:
     *  默认方式获取请求参数
     *   直接给方法上写一个和请求参数名相同的变量,这个变量就来接收请求参数的值;带参数就有值,没带就为null
     *
     * @RequestParam 获取请求参数 eg:username=request.getParameter("user")
     * @RequestParam(value="xxx", required="true  or false"[是否必须],DefaultValue[设置默认值])
     *
     * @RequestHeader  获取请求头中的值
     *
     * @CookieValue  获取某个cookie的值
     * 以前的操作获取某个cookie
     * Cookie[] cookie=request.getCookies();
     * for(Cookie c:cookie){
     *     if(c.getName().equals("JSESSIONID")){
     *         String cv=c.getValue();
     *     }
     * }
     *
     * 现在:@CookieValue("JSESSIONID")可以获取对应的value值
     * @param username
     * @return
     */
    @RequestMapping("/handle03")
    public String handle03(@RequestParam("username") String username){
        System.out.println("这个参数的值为"+username);
        return "success";
    }

    /**
     * SpringMVC可以直接在参数上写原生Api
     * HTTPSession
     * HttpServletRequest
     * HttpServletResponse
     *
     *
     * 乱码处理:
     * 响应乱码:response.setContentType("text/html;charset=utf-8")
     * 请求乱码:
     *    GET请求:改Server.xml  在8080端口处加 URIEncoding="utf-8"
     *    POST请求:在第一次获取请求参数之前设置 request.setCharacterEncoding("utf-8")
     *    自己可以写入filter
     * @param s
     * @param request
     * @return
     */
    @RequestMapping("/handle04")
    public String handle04(HttpSession s, HttpServletRequest request){
        request.setAttribute("requestParam","我是请求域中的");
        s.setAttribute("sessionParam","我是session域中的");
        return "success";
    }
}
