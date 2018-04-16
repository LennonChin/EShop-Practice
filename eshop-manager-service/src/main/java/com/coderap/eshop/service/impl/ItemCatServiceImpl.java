package com.coderap.eshop.service.impl;

import com.coderap.eshop.common.pojo.EasyUITreeNode;
import com.coderap.eshop.mapper.TbItemCatMapper;
import com.coderap.eshop.pojo.TbItemCat;
import com.coderap.eshop.pojo.TbItemCatExample;
import com.coderap.eshop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: eshop-parent
 * @description:
 * @author: Lennon Chin
 * @create: 2018/04/17 00:08:32
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public List<EasyUITreeNode> getCatListById(long parentId) {
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = tbItemCatExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(tbItemCatExample);
        List<EasyUITreeNode> resultList = new ArrayList<>();
        for (TbItemCat tbItemCat : tbItemCats) {
            EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
            easyUITreeNode.setId(tbItemCat.getId());
            easyUITreeNode.setText(tbItemCat.getName());
            easyUITreeNode.setState(tbItemCat.getIsParent() ? "closed" : "open");
            resultList.add(easyUITreeNode);
        }
        return resultList;
    }
}
