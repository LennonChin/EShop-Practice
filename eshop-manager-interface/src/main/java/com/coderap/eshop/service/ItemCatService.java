package com.coderap.eshop.service;

import com.coderap.eshop.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * @program: eshop-parent
 * @description: 商品类别Service
 * @author: Lennon Chin
 * @create: 2018/04/17 00:06:12
 */
public interface ItemCatService {

    // 根据parentId来查找子分类
    List<EasyUITreeNode> getCatListById(long parentId);
}
