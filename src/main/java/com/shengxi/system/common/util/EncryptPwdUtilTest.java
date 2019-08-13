package com.shengxi.system.common.util;


import com.alibaba.druid.filter.config.ConfigTools;
import org.junit.Test;

/**
 *数据库配置加密使用
 * 修改password字符串为对应的密码输出
 * copy对应的publicKey放在yml中对应useName中的publicKey和key
 * copy对应的password到对应的password
 * @author matthew
 */
public class EncryptPwdUtilTest {

    @Test
    public void EncryptPwdUtil() {
        try {
            String password = "pwd";
            String[] arr = ConfigTools.genKeyPair(512);

            System.out.println("publicKey:" + arr[1]);
            System.out.println("password:" + ConfigTools.encrypt(arr[0], password));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}