package com.bruce.jwt.config.exception;

public class ExceptionDef extends RuntimeException {
    /**
     * 仅包含message, 没有cause, 也不记录栈异常, 性能最高
     * @param msg
     */
    public ExceptionDef(String msg) {
        this(msg, false);
    }

    /**
     * 包含message, 可指定是否记录异常
     * @param msg
     * @param recordStackTrace
     */
    public ExceptionDef(String msg, boolean recordStackTrace) {
        super(msg, null, false, recordStackTrace);
    }

    /**
     * 包含message和cause, 会记录栈异常
     * @param msg
     * @param cause
     */
    public ExceptionDef(String msg, Throwable cause) {
        super(msg, cause, false, true);
    }

}
