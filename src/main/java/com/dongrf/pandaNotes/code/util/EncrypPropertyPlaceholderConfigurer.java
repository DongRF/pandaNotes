package com.dongrf.pandaNotes.code.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * @ 类名：pandaNotes
 * @ 作者：Mr_DongRF
 * @ 日期：2019/1/2 16:08
 * @ 功能：将数据库配置文件中的数据库用户名和密码解密
 * @ Version：1.0
 */
public class EncrypPropertyPlaceholderConfigurer extends
        PropertyPlaceholderConfigurer {

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        Base64Util base64 = new Base64Util();

        String username = props.getProperty("database.username");
        String password = props.getProperty("database.password");

        if (username != null){
            username = base64.decode(username);
            props.setProperty("database.username", username);
        }

        if (password != null) {// 将加密的password解密后塞到props
            password = base64.decode(password);
            props.setProperty("database.password", password);
        }
        super.processProperties(beanFactoryToProcess, props);
    }
}