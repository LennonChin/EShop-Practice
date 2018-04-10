package com.coderap.eshop.service.impl;

import com.coderap.eshop.mapper.TbItemMapper;
import com.coderap.eshop.pojo.TbItem;
import com.coderap.eshop.pojo.TbItemExample;
import com.coderap.eshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: eshop-parent
 * @description: 商品管理Service
 * @author: Lennon Chin
 * @create: 2018/04/10 23:30:08
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    /**
     * @Description:
     * @Param: [itemId]
     * @return: com.coderap.eshop.pojo.TbItem
     * @Author: Lennon Chin
     * @Date: 2018/4/10
     */
    public TbItem getItemById(long itemId) {
        // 根据主键查询
//        TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
        // 设置查询条件
        TbItemExample tbItemExample = new TbItemExample();
        TbItemExample.Criteria criteria = tbItemExample.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> tbItems = itemMapper.selectByExample(tbItemExample);
        if (tbItems != null && tbItems.size() > 0) {
            return tbItems.get(0);
        }
        return null;
    }
}
