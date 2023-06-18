package com.airline.checkin.models;

public class EndPointEntity {

    private Integer code;

    private CheckInEntity data;

    private String errors;

    public EndPointEntity() {
    }

    public EndPointEntity(Integer code, CheckInEntity data, String errors) {
        this.code = code;
        this.data = data;
        this.errors = errors;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public CheckInEntity getData() {
        return data;
    }

    public void setData(CheckInEntity data) {
        this.data = data;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "EndPointEntity{" +
                "code=" + code +
                ", data=" + data +
                ", errors='" + errors + '\'' +
                '}';
    }
}
