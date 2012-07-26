package com.customer.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>首页处理</p>
 * @author Eric.fu
 * @version $Id: IndexAction.java, v 0.1 2011-1-21 上午10:07:42 fuyangbiao Exp $
 */
@Controller
@RequestMapping("/index.htm")
public class IndexAction extends BaseAction {

    /**
     * 默认入口
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String comeIn() {

        return "index";
    }
}
