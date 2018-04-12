package com.coderap.eshop.service;

import com.coderap.eshop.common.pojo.EasyUIDataGridResult;
import com.coderap.eshop.pojo.TbItem;

/**
 * @program: eshop-parent
 * @description: 商品管理Service
 * @author: Lennon Chin
 * @create: 2018/04/10 23:28:55
 */
public interface ItemService {
    TbItem getItemById(long itemId);
    EasyUIDataGridResult getItemList(Integer page, Integer rows);
}
