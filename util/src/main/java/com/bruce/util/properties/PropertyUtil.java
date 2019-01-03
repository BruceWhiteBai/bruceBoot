package com.bruce.util.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);
    private static Properties props;

    synchronized static private void loadProps(String path){
        logger.info("开始加载properties文件内容.......");
        props = new Properties();
        InputStream in = null;
        try {
                /*第一种，通过类加载器进行获取properties文件流*/
                  //  in = PropertyUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
                /*第二种，通过类进行获取properties文件流*/
                    in = PropertyUtil.class.getResourceAsStream(path);
                    props.load(in);
        } catch (FileNotFoundException e) {
            logger.error("文件{}未找到",path);
        } catch (IOException e) {
            logger.error("出现IOException,异常原因{}",e.getMessage());
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("文件流关闭出现异常");
            }
        }
        logger.info("加载properties文件内容完成...........");
        logger.info("properties文件内容：" + props);
    }

    public static String getProperty(String key,String path){
        if(null == props) {
            loadProps(path);
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue,String path) {
        if(null == props) {
            loadProps(path);
        }
        return props.getProperty(key, defaultValue);
    }
}