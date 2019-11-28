package com.jzhl.yunjia.model;

import java.io.Serializable;
import java.util.Date;

/**
 * door_sub_device
 * @author 
 */
public class SubDevice implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 控制器id
     */
    private Integer deviceId;

    /**
     * 门禁控制器序列号
     */
    private String deviceSerial;

    /**
     * 门禁控制器自定义id
     */
    private String deviceCustomId;

    /**
     * 子设备序列号
     */
    private String serial;

    /**
     * 子设备自定义id
     */
    private String customId;

    /**
     * 项目id
     */
    private Integer heId;

    /**
     * 楼栋id
     */
    private Integer buildingId;

    /**
     * 单元id
     */
    private Integer unitId;

    /**
     * 设备名称
     */
    private String subDeviceName;

    /**
     * 说明
     */
    private String subDeviceDesc;

    /**
     * 1 door 门, 2 card 门禁卡, 3 qr 二维码, 4 face 人脸识别,  5 button 按钮
     */
    private String subDeviceType;

    /**
     * 附属设备对应几号口 0 进入 1 出去
     */
    private Integer activType;

    /**
     * 继电器持续时长 秒
     */
    private Integer activTime;

    /**
     * 设备图片url
     */
    private String subDeviceUrl;

    /**
     * 在线状态 0在线 1不在线
     */
    private String online;

    /**
     * 人脸比对阀值
     */
    private Integer faceThreshold;

    /**
     * 状态（0正常 1停用）
     */
    private String status;

    /**
     * 是否删除（0存在 1删除）
     */
    private String delFlag;

    /**
     * 创建人id
     */
    private Integer buildUserid;

    /**
     * 创建时间
     */
    private Date buildTime;

    /**
     * 修改人id
     */
    private Integer updateUserid;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 公司id
     */
    private Integer companyId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public String getDeviceCustomId() {
        return deviceCustomId;
    }

    public void setDeviceCustomId(String deviceCustomId) {
        this.deviceCustomId = deviceCustomId;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public Integer getHeId() {
        return heId;
    }

    public void setHeId(Integer heId) {
        this.heId = heId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getSubDeviceName() {
        return subDeviceName;
    }

    public void setSubDeviceName(String subDeviceName) {
        this.subDeviceName = subDeviceName;
    }

    public String getSubDeviceDesc() {
        return subDeviceDesc;
    }

    public void setSubDeviceDesc(String subDeviceDesc) {
        this.subDeviceDesc = subDeviceDesc;
    }

    public String getSubDeviceType() {
        return subDeviceType;
    }

    public void setSubDeviceType(String subDeviceType) {
        this.subDeviceType = subDeviceType;
    }

    public Integer getActivType() {
        return activType;
    }

    public void setActivType(Integer activType) {
        this.activType = activType;
    }

    public Integer getActivTime() {
        return activTime;
    }

    public void setActivTime(Integer activTime) {
        this.activTime = activTime;
    }

    public String getSubDeviceUrl() {
        return subDeviceUrl;
    }

    public void setSubDeviceUrl(String subDeviceUrl) {
        this.subDeviceUrl = subDeviceUrl;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public Integer getFaceThreshold() {
        return faceThreshold;
    }

    public void setFaceThreshold(Integer faceThreshold) {
        this.faceThreshold = faceThreshold;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getBuildUserid() {
        return buildUserid;
    }

    public void setBuildUserid(Integer buildUserid) {
        this.buildUserid = buildUserid;
    }

    public Date getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Date buildTime) {
        this.buildTime = buildTime;
    }

    public Integer getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Integer updateUserid) {
        this.updateUserid = updateUserid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SubDevice other = (SubDevice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getDeviceSerial() == null ? other.getDeviceSerial() == null : this.getDeviceSerial().equals(other.getDeviceSerial()))
            && (this.getDeviceCustomId() == null ? other.getDeviceCustomId() == null : this.getDeviceCustomId().equals(other.getDeviceCustomId()))
            && (this.getSerial() == null ? other.getSerial() == null : this.getSerial().equals(other.getSerial()))
            && (this.getCustomId() == null ? other.getCustomId() == null : this.getCustomId().equals(other.getCustomId()))
            && (this.getHeId() == null ? other.getHeId() == null : this.getHeId().equals(other.getHeId()))
            && (this.getBuildingId() == null ? other.getBuildingId() == null : this.getBuildingId().equals(other.getBuildingId()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getSubDeviceName() == null ? other.getSubDeviceName() == null : this.getSubDeviceName().equals(other.getSubDeviceName()))
            && (this.getSubDeviceDesc() == null ? other.getSubDeviceDesc() == null : this.getSubDeviceDesc().equals(other.getSubDeviceDesc()))
            && (this.getSubDeviceType() == null ? other.getSubDeviceType() == null : this.getSubDeviceType().equals(other.getSubDeviceType()))
            && (this.getActivType() == null ? other.getActivType() == null : this.getActivType().equals(other.getActivType()))
            && (this.getActivTime() == null ? other.getActivTime() == null : this.getActivTime().equals(other.getActivTime()))
            && (this.getSubDeviceUrl() == null ? other.getSubDeviceUrl() == null : this.getSubDeviceUrl().equals(other.getSubDeviceUrl()))
            && (this.getOnline() == null ? other.getOnline() == null : this.getOnline().equals(other.getOnline()))
            && (this.getFaceThreshold() == null ? other.getFaceThreshold() == null : this.getFaceThreshold().equals(other.getFaceThreshold()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getBuildUserid() == null ? other.getBuildUserid() == null : this.getBuildUserid().equals(other.getBuildUserid()))
            && (this.getBuildTime() == null ? other.getBuildTime() == null : this.getBuildTime().equals(other.getBuildTime()))
            && (this.getUpdateUserid() == null ? other.getUpdateUserid() == null : this.getUpdateUserid().equals(other.getUpdateUserid()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getDeviceSerial() == null) ? 0 : getDeviceSerial().hashCode());
        result = prime * result + ((getDeviceCustomId() == null) ? 0 : getDeviceCustomId().hashCode());
        result = prime * result + ((getSerial() == null) ? 0 : getSerial().hashCode());
        result = prime * result + ((getCustomId() == null) ? 0 : getCustomId().hashCode());
        result = prime * result + ((getHeId() == null) ? 0 : getHeId().hashCode());
        result = prime * result + ((getBuildingId() == null) ? 0 : getBuildingId().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getSubDeviceName() == null) ? 0 : getSubDeviceName().hashCode());
        result = prime * result + ((getSubDeviceDesc() == null) ? 0 : getSubDeviceDesc().hashCode());
        result = prime * result + ((getSubDeviceType() == null) ? 0 : getSubDeviceType().hashCode());
        result = prime * result + ((getActivType() == null) ? 0 : getActivType().hashCode());
        result = prime * result + ((getActivTime() == null) ? 0 : getActivTime().hashCode());
        result = prime * result + ((getSubDeviceUrl() == null) ? 0 : getSubDeviceUrl().hashCode());
        result = prime * result + ((getOnline() == null) ? 0 : getOnline().hashCode());
        result = prime * result + ((getFaceThreshold() == null) ? 0 : getFaceThreshold().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getBuildUserid() == null) ? 0 : getBuildUserid().hashCode());
        result = prime * result + ((getBuildTime() == null) ? 0 : getBuildTime().hashCode());
        result = prime * result + ((getUpdateUserid() == null) ? 0 : getUpdateUserid().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", deviceSerial=").append(deviceSerial);
        sb.append(", deviceCustomId=").append(deviceCustomId);
        sb.append(", serial=").append(serial);
        sb.append(", customId=").append(customId);
        sb.append(", heId=").append(heId);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", unitId=").append(unitId);
        sb.append(", subDeviceName=").append(subDeviceName);
        sb.append(", subDeviceDesc=").append(subDeviceDesc);
        sb.append(", subDeviceType=").append(subDeviceType);
        sb.append(", activType=").append(activType);
        sb.append(", activTime=").append(activTime);
        sb.append(", subDeviceUrl=").append(subDeviceUrl);
        sb.append(", online=").append(online);
        sb.append(", faceThreshold=").append(faceThreshold);
        sb.append(", status=").append(status);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", buildUserid=").append(buildUserid);
        sb.append(", buildTime=").append(buildTime);
        sb.append(", updateUserid=").append(updateUserid);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", companyId=").append(companyId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}