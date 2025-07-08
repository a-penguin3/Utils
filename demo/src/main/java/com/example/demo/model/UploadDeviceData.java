package com.example.demo.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

@Data
public class UploadDeviceData {
    /**
     * 安装时间
     */
    @DateTimeFormat("yyyy年MM月dd日 HH时mm分ss秒")
    @ExcelProperty(index = 8)
    private String installTime;
    /**
     * 设备序列号
     */
    @ExcelProperty(index = 3)
    private String deviceSn;
    /**
     * 设备名称
     */
    @ExcelProperty(index = 1)
    private String deviceName;
    /**
     * 设备类型
     */
    @ExcelProperty(index = 2)
    private String deviceType;
    /**
     * 协约类型
     */
    private String contractType;
    /**
     * imei号
     */
    private String imei;
    /**
     * 安装地点
     */
    @ExcelProperty(index = 4)
    private String roomId;
    /**
     * 状态：1.在线；0.离线
     */
    private String state;
    /**
     * 物联网平台 设备id
     */
    private String aiotDeviceId;
    /**
     * 所属租户
     */
    private String customerId;

    private String roomDes;

    private Boolean controlStatus;

    private String openStatus;

    private String factoryType;

}
