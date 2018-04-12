package com.coderap.eshop.pagehelper;

import com.coderap.eshop.mapper.TbItemMapper;
import com.coderap.eshop.pojo.TbItem;
import com.coderap.eshop.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @program: eshop-parent
 * @description: 分页插件测试器
 * @author: Lennon Chin
 * @create: 2018/04/13 00:36:13
 */
public class PageHelperTest {

    @Test
    public void testPageHelper() throws Exception {
        // 初始化Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-dao.xml");
        TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);
        // 执行SQL语句之前设置分页信息
        PageHelper.startPage(1, 10);
        // 执行查询
        TbItemExample tbItemExample = new TbItemExample();
        List<TbItem> tbItems = tbItemMapper.selectByExample(tbItemExample);
        // 取分页信息
        PageInfo<TbItem> tbItemPageInfo = new PageInfo<>(tbItems);
        System.out.println(tbItemPageInfo.getTotal());
        System.out.println(tbItemPageInfo.getPages());
        System.out.println(tbItems.size());
    }
}
