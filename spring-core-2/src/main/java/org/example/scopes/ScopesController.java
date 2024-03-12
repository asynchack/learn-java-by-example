package org.example.scopes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.Resource;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.scopes
 * @date 2024/3/7 08:56
 */

@Controller
public class ScopesController {

    public static final Logger LOG = LoggerFactory.getLogger(ScopesController.class); // 是这个Controller的Class对象，拿到就可以通过反射操纵这个类

    @Resource(name = "requestScope")
    HelloMessageGenerator requestScopeBean;

    @Resource(name = "sessionScope")
    HelloMessageGenerator sessionScopeBean;

    @Resource(name = "applicationScope")
    HelloMessageGenerator applicationScopeBean;

    @RequestMapping("/scopes/request")
    public String getRequestScopeMessage(final Model model) {
        model.addAttribute("previouseMessage", requestScopeBean.getMessage()); // 每次请求都是一个新的，所以这里就是一个新的bean，message字段为空
        requestScopeBean.setMessage("request scope message");
        model.addAttribute("current", requestScopeBean.getMessage()); // message 是上面的值
        return "ScopesExample";
    }

    @RequestMapping("/scopes/session")
    public String getSessionScopeMessage(final Model model) {
        model.addAttribute("previouseMessage", sessionScopeBean.getMessage()); // 同一个会话的请求进来时，得到时上一个request 设置的bean的message 的值 （会话第一个reqeust得到的是空）
        sessionScopeBean.setMessage("session scope message");
        model.addAttribute("current", sessionScopeBean.getMessage()); // message 是上面的值
        return "ScopesExample";
    }

    @RequestMapping("/scopes/application")
    public String getApplicationScopeMessage(final Model model) {
        model.addAttribute("previouseMessage", applicationScopeBean.getMessage()); // 同一个application下的所有reqeust进来，得到时上一个request 设置的bean的message 的值（第一个得到的是空）
        applicationScopeBean.setMessage("application scope message");
        model.addAttribute("current", applicationScopeBean.getMessage());
        return "ScopesExample";
    }

}


