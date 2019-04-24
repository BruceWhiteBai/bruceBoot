package com.bruce.jwt.config.api;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class ApiUtils {
    private static final Logger logger = LoggerFactory.getLogger(ApiUtils.class);

    private ApiUtils() {
    }

    /**
     * 格式化参数错误等非数据库异常信息.
     *
     * @param desc
     * @param map
     */
    public static void formatJsonError(String desc, Map map) {
        map.put(ApiConstants.FLAG, ApiConstants.FLAG_FAIL);
        map.put(ApiConstants.FLAG_DESC, desc == null ? "" : desc);
    }

    public static void formatJson(JSONObject rstJson) {
        rstJson.put(ApiConstants.FLAG, ApiConstants.FLAG_SUCCESS);
        rstJson.put(ApiConstants.FLAG_DESC, ApiConstants.STATUS_DESC_SUCCESS);
    }

    public static void formatJsonWithData(JSONObject rstJson, Object obj) {
        rstJson.put(ApiConstants.FLAG, ApiConstants.FLAG_SUCCESS);
        rstJson.put(ApiConstants.FLAG_DESC, ApiConstants.STATUS_DESC_SUCCESS);
        rstJson.put(ApiConstants.DATA, obj == null ? "" : obj);
    }

    public static void formatJsonError(String desc, JSONObject rstJson) {
        rstJson.put(ApiConstants.FLAG, ApiConstants.FLAG_FAIL);
        rstJson.put(ApiConstants.FLAG_DESC, desc == null ? "" : desc);
    }

    public static void formatJsonException(Exception e, JSONObject rstJson) {
        rstJson.put(ApiConstants.FLAG, ApiConstants.FLAG_FAIL);
        rstJson.put(ApiConstants.FLAG_DESC, e.getMessage());
    }


    public static void formatJsonWithDataSecond(JSONObject rstJson, Object obj) {
        rstJson.put(ApiConstants.STATUS_CODE, ApiConstants.STATUS_CODE_SUCCESS);
        rstJson.put(ApiConstants.STATUS_DESC, ApiConstants.STATUS_DESC_SUCCESS);
        rstJson.put(ApiConstants.DATA, obj == null ? "" : obj);
    }


    public static void formatJsonErrorSecond(String desc, JSONObject rstJson) {
        rstJson.put(ApiConstants.STATUS_CODE, ApiConstants.STATUS_CODE_FAIL_1);
        rstJson.put(ApiConstants.STATUS_DESC, desc);
    }

    public static void formatJsonWithData1(JSONObject rstJson, Object obj) {
        rstJson.put(ApiConstants.FLAG, ApiConstants.FLAG_SUCCESS_STR);
        rstJson.put(ApiConstants.FLAG_DESC, ApiConstants.STATUS_DESC_SUCCESS);
        rstJson.put(ApiConstants.DATA, obj == null ? "" : obj);
    }

    public static void formatJsonError1(String desc, JSONObject rstJson) {
        rstJson.put(ApiConstants.FLAG, ApiConstants.FLAG_FAIL_STR);
        rstJson.put(ApiConstants.FLAG_DESC, desc == null ? "" : desc);
    }

    public static void formatJsonException1(Exception e, JSONObject rstJson) {
        rstJson.put(ApiConstants.FLAG, ApiConstants.FLAG_FAIL_STR);
        rstJson.put(ApiConstants.FLAG_DESC, e.getMessage());
    }


}
