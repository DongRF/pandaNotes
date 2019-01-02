package com.dongrf.pandaNotes.code.util;


import org.apache.commons.codec.digest.DigestUtils;

/**
 * @ 类名：MD5
 * @ 作者：Mr_DongRF
 * @ 日期：2018/12/24 21:20
 * @ 功能：MD5加解密工具类
 * @ Version：1.0
 */
public class MD5 {

    public static void main(String[] args){
        String text = "123";
        String key = "123pandaNotes";
        System.out.println(md5(text,key));
    }

    public static String md5(String text, String key){
        /**
         * @ 方法名：md5
         * @ params: [text：明文, key：秘钥]
         * @ return: java.lang.String：密文
         * @ 作者：Mr_DongRF
         * @ 日期：2018/12/24
         * @ 功能：加密
         */
        //加密后的字符串
        String encodeStr= DigestUtils.md5Hex(text + key);
        return encodeStr;
    }
    public static boolean verify(String text, String key, String md5){
        /**
         * @ 方法名：verify
         * @ params: [text：明文, key：秘钥, md5：密文]
         * @ return: boolean
         * @ 作者：Mr_DongRF
         * @ 日期：2018/12/24
         * @ 功能：解密
         */
        String md5Text = md5(text, key);
        if(md5Text.equalsIgnoreCase(md5)) return true;
        return false;
    }
}
