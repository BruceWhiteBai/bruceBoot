package com.bruce.jwt.config.api;


public class ApiConstants {
    private ApiConstants() {
    }

    public static final String STATUS_CODE = "statusCode";
    public static final int  STATUS_CODE_SUCCESS = 0;
    public static final int  STATUS_CODE_FAIL_1 = 1;
    public static final int  MAX_STUID_COUNT = 600;

    public static final String STATUS_DESC = "statusDesc";

    // 接口返回标志
    public static final int  FLAG_FAIL = 0;
    public static final int  FLAG_SUCCESS = 1;
    public static final String  FLAG_FAIL_STR = "0";
    public static final String  FLAG_SUCCESS_STR = "1";
    public static final String FLAG = "flag";
    public static final String FLAG_DESC = "message";
    public static final String STATUS_DESC_SUCCESS = "ok";

    // 方法参数
    public static final String ONE = "1";
    public static final String ZERO = "0";
    public static final String DATA = "data";
    public static final String STATUS = "status";
    public static final String SERIAL_NO = "serialNo";
    public static final String DATA_LIST = "dataList";

}
