package com.shengxi.rs.common.util;

import com.shengxi.system.common.util.IdCommon;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 通过雪花算法生成不重复id
 * @author: Matthew
 * @Date: 2019/4/9 17:12
 * @Description: 生成id
 */
public class IdUtil {

    public static String uuid(){
        IdCommon idCommon = new IdCommon(System.currentTimeMillis(),System.currentTimeMillis());
        //避免事件冲突
        try {
            Thread.sleep(Thread.MIN_PRIORITY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.valueOf(idCommon.nextId());
    }
}
