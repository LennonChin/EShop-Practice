package com.coderap.eshop.controller;

import com.coderap.eshop.common.pojo.EShopResult;
import com.coderap.eshop.common.pojo.EasyUIDataGridResult;
import com.coderap.eshop.pojo.TbItem;
import com.coderap.eshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        EasyUIDataGridResult itemList = itemService.getItemList(page, rows);
        return itemList;
    }

    @RequestMapping(value = "/item/save", method = RequestMethod.POST)
    @ResponseBody
    public EShopResult addItem(TbItem tbItem, String desc) {
        return itemService.addItem(tbItem, desc);
    }
}
