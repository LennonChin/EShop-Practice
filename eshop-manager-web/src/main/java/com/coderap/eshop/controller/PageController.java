package com.coderap.eshop.controller;

import com.coderap.eshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: eshop-parent
 * @description: 页面跳转Controller
 * @author: Lennon Chin
 * @create: 2018/04/13 00:14:39
 */
@Controller
public class PageController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
