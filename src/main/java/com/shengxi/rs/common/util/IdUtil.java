package com.shengxi.rs.common.util;

import com.shengxi.system.common.util.IdCommon;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Matthew
 * @Date: 2019/4/9 17:12
 * @Description: 生成id
 */
public class IdUtil {

    public static String uuid(){
        IdCommon idCommon = new IdCommon(0,0);
        //避免事件冲突
        Thread.sleep(Thread.MIN_PRIORITY);
        return String.valueOf(idCommon.nextId());
    }
}
