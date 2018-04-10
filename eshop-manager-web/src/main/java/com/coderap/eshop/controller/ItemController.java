package com.coderap.eshop.controller;

import com.coderap.eshop.pojo.TbItem;
import com.coderap.eshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: eshop-parent
 * @description: 商品管理Controller
 * @author: Lennon Chin
 * @create: 2018/04/10 23:39:37
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody // 需要依赖Jackson包才能返回JSON
    public TbItem getItemById(@PathVariable Long itemId) {
        TbItem itemById = itemService.getItemById(itemId);
        return itemById;
    }
}
