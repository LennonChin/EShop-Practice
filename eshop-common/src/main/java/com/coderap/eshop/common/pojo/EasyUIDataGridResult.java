package com.coderap.eshop.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @program: eshop-parent
 * @description: 用于包装返回给前端的特定JSON格式数据的POJO
 * @author: Lennon Chin
 * @create: 2018/04/13 00:59:14
 */
public class EasyUIDataGridResult implements Serializable {

    private static final long serialVersionUID = -8365705006669004291L;
    private Long total;
    private List rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
