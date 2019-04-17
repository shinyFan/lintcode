package com.yuantu.faceUtils;

/**
 * Created by JINZONGFAN on 2019/4/16 14:24
 */
public class JsonResult {
    private int error_code;
    private String error_msg;
    private long log_id;
    private long timestamp;
    private int cached;
    private Result result;

    @Override
    public String toString() {
        return "JsonResult{" +
                "error_code=" + error_code +
                ", error_msg='" + error_msg + '\'' +
                ", log_id=" + log_id +
                ", timestamp=" + timestamp +
                ", cached=" + cached +
                ", result=" + result +
                '}';
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getCached() {
        return cached;
    }

    public void setCached(int cached) {
        this.cached = cached;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public JsonResult(int error_code, String error_msg, long log_id, long timestamp, int cached, Result result) {
        this.error_code = error_code;
        this.error_msg = error_msg;
        this.log_id = log_id;
        this.timestamp = timestamp;
        this.cached = cached;
        this.result = result;
    }

    public JsonResult() {
    }
}
