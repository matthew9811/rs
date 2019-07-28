package com.shengxi.rs.common.domain;

/**
 * @author : Matthew
 * @Date: 2019/4/6 23:40
 * @Description: 验证码使用类
 */
public class ValidateCodeProperties {

    /**
     * 验证码图片宽度
     */
    private int width = 146;
    /**
     * 验证码图片高度
     */
    private int height = 33;
    /**
     * 验证码字符位数
     */
    private int length = 4;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
