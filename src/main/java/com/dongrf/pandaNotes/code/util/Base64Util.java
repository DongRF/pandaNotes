package com.dongrf.pandaNotes.code.util;

import org.apache.commons.codec.binary.Base64;
/**
 * @ 类名：pandaNotes
 * @ 作者：Mr_DongRF
 * @ 日期：2019/1/2 16:08
 * @ 功能：Base64加解密
 * @ Version：1.0
 */
public class Base64Util {
    public static void main(String[] args){
        Base64Util base64Util = new Base64Util();
        System.out.println(base64Util.encode("root"));
        System.out.println(base64Util.decode("MTIzNDU2"));
}

    Base64 base64 = new Base64();
    public String encode(String rText){
        /**
          * @ 方法名：encode
          * @ params: [text]
          * @ return: java.lang.String
          * @ 作者：Mr_DongRF
          * @ 日期：2019/1/2
          * @ 功能：Base64加密
          */
        byte[] byteText = rText.getBytes();
        byteText = base64.encode(byteText);
        String cText = new String(byteText);
        return cText;
    }

    public String decode(String cText){
        /**
          * @ 方法名：decode
          * @ params: [cText]
          * @ return: java.lang.String
          * @ 作者：Mr_DongRF
          * @ 日期：2019/1/2
          * @ 功能：Base64解密
          */
        byte[] byteText = cText.getBytes();
        byteText = base64.decode(byteText);
        String rText = new String(byteText);
        return rText;
    }
}
