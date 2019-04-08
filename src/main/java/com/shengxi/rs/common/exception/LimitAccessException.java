package com.shengxi.rs.common.exception;

/**
 * @author: Matthew
 * @Date: 2019/4/6 23:23
 * @Description:
 */
public class LimitAccessException extends Exception {

    private static final long serialVersionUID = -3608667856397125671L;

    public LimitAccessException(String message) {
        super(message);
    }
}