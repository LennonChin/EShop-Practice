package com.coderap.eshop.common.pojo;

import java.io.Serializable;

/**
 * @program: eshop-parent
 * @description: 包装EasyUI中Tree结构的异步数据结构
 * @author: Lennon Chin
 * @create: 2018/04/16 23:45:42
 */
public class EasyUITreeNode implements Serializable {
    private static final long serialVersionUID = 5098573851551236206L;

    private long id;
    private String text;
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
