package HMX.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @RequestMapping模糊匹配功能
 * 模糊匹配统配符:
 *  ?  替代任意一个字符
 *  * 代替任意多个字符和一层路径
 *  **  代替多层路径
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
}
