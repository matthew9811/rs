package com.shengxi.system.common.util;

import com.alibaba.druid.util.Base64;
import com.shengxi.system.common.constant.SysConstant;

import java.util.UUID;

/**
 *
 * @author: Matthew
 * @Date: 2019/4/9 17:12
 * @Description: 生成id
 */
public class IdUtil {

    public static String uuid() {
        return UUID.randomUUID().toString();
    }


    public static String igId(){
        return String.valueOf(Base64.base64ToByteArray(Long.toBinaryString(System.currentTimeMillis())));
    }


    public static String IGenId(){
        IdCommon idCommon = new IdCommon(SysConstant.WORK_ID, SysConstant.DATA_CENTER_ID);
        //避免事件冲突
        try {
            Thread.sleep(Thread.MIN_PRIORITY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.valueOf(idCommon.nextId());
    }

}
