package com.shengxi.rs.common.exception;

/**
 * @Auther: Matthew
 * @Date: 2019/4/6 23:23
 * @Description: 文件下载异常
 */
public class FileDownloadException  extends Exception {

    private static final long serialVersionUID = -3608667856397125671L;

    public FileDownloadException(String message) {
        super(message);
    }
}