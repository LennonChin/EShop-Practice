package com.coderap.eshop.controller;

import com.coderap.eshop.common.pojo.EasyUITreeNode;
import com.coderap.eshop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: eshop-parent
 * @description: 商品类别Controller
 * @author: Lennon Chin
 * @create: 2018/04/17 00:14:26
 */
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatByParentId(@RequestParam(name = "id", defaultValue = "0") long parentId) {
        return itemCatService.getCatListById(parentId);
    }
}
