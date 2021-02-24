package HMX.bean;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 数据输出给页面demo
 */

/**
 * SpringMVC除过在方法上传入原生的request和session,还能怎么样吧数据带给页面
 * 1.可以在方法出传入Map,或者Model或者ModelMap.给这些参数里面保存的所有数据都会
 *   放在[请求]域中,可以在页面获取
 *
 *  关系:三种都是bindingAwareModelMap在工作,相当于BindingAwareModeMap中保存的
 *  东西都会被放在请求域中;
 *  Map(interface(jdk))        Model(interface(Spring))
 *      ||                        //
 *      ||                       //
 *      \/                      //
 *   linkedHashMap             //
 *      ||                    //
 *      \/                   //
 *   ModelMap(class)        //
 *        \\               //
 *         \\             //
 *         ExtendedModelMap
 *              ||
 *              \/
 *          BindingAwareModelMap
 * 2.方法的返回值可以变成ModelAndView
 *   既包含视图信息(页面地址) 也包含模型数据(给页面的数据);
 *   而且数据是放在请求域中的;
 *
 * 3.SpringMVC提供了一种可以临时给session域中保存数据的方式
 * 提供了一个注解:@SessionAttributes(只能标注在类上)
 * @sessionAttributes(value="msg");
 * 给BindingAwareModelMap中保存的数据,则同时给session一份
 * value指定保存数据时给session中放的key
 *
 * @SessionAttributes(value = "msg",type={String.class})
 * 只要保存是String类型,也保存一份
 */
@SessionAttributes(value = "msg")
@Controller
public class worldController {
    @RequestMapping("/world")
    public String world(Map<String,Object> map){
        map.put("msg","你好!");
        return "output";
    }

    /**
     * 一个接口
     * @param model
     * @return
     */
    @RequestMapping("/world01")
    public String world01(Model model){
        model.addAttribute("msg","你好骚!");
        return "output";
    }
    @RequestMapping("/world02")
    public String world02(ModelMap modelMap){
        modelMap.addAttribute("msg","我好喜欢!");
        return "output";
    }
    @RequestMapping("/world03")
    public ModelAndView world03(){
        //之前的返回值我们就叫视图名
        ModelAndView view = new ModelAndView("output");
        view.addObject("msg","你好哦!");
        return  view;
    }
}
