package com.coderap.eshop.service.impl;

import com.coderap.eshop.common.pojo.EasyUIDataGridResult;
import com.coderap.eshop.mapper.TbItemMapper;
import com.coderap.eshop.pojo.TbItem;
import com.coderap.eshop.pojo.TbItemExample;
import com.coderap.eshop.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    /**
     * @Description: 用于返回商品列表的接口，带有分页功能
     * @Param: [page, rows]
     * @return: com.coderap.eshop.common.pojo.EasyUIDataGridResult
     * @Author: Lennon Chin
     * @Date: 2018/4/13
     */
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {

        PageHelper.startPage(page, rows);
        TbItemExample tbItemExample = new TbItemExample();
        List<TbItem> tbItems = itemMapper.selectByExample(tbItemExample);
        PageInfo<TbItem> tbItemPageInfo = new PageInfo<>(tbItems);
        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        easyUIDataGridResult.setTotal(tbItemPageInfo.getTotal());
        easyUIDataGridResult.setRows(tbItems);
        return easyUIDataGridResult;
    }
}
