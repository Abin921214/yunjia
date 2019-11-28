package com.jzhl.yunjia.model;

import java.io.Serializable;
import java.util.Date;

/**
 * door_open_log
 * @author 
 */
public class OpenLog implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 项目id
     */
    private Integer heId;

    /**
     * 楼栋id 打开楼栋门/单元门 时才会设置值
     */
    private Integer buildingId;

    /**
     * 单元id 打开单元门 时才会设置值
     */
    private Integer unitId;

    /**
     * 云控制器id
     */
    private Integer deviceId;

    /**
     * 打开的门id
     */
    private Integer openSubDeviceId;

    /**
     * 0门禁卡 1二维码 2访客二维码 3人脸识别 4按钮开门 5前端主动开门 6后端主动开门
     */
    private Integer openType;

    /**
     * 卡号 只有门禁卡情况下才会设置
     */
    private String cardNumber;

    /**
     * 访客二维码id 只有访客二维码情况才会设置值
     */
    private Integer visitorQrId;

    /**
     * 日志关联业主id
     */
    private Integer ownerId;

    /**
     * 日志关联用户id
     */
    private Integer userId;

    /**
     * 作废
     */
    private Integer houseId;

    /**
     * 读取子设备id (主动开门时没有)
     */
    private Integer readSubDeviceId;

    /**
     * 读取卡号/二维码/访客二维码号
     */
    private String readInfo;

    /**
     * 继电器持续时长 秒
     */
    private Integer activTime;

    /**
     * 说明
     */
    private String logDesc;

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

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getOpenSubDeviceId() {
        return openSubDeviceId;
    }

    public void setOpenSubDeviceId(Integer openSubDeviceId) {
        this.openSubDeviceId = openSubDeviceId;
    }

    public Integer getOpenType() {
        return openType;
    }

    public void setOpenType(Integer openType) {
        this.openType = openType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getVisitorQrId() {
        return visitorQrId;
    }

    public void setVisitorQrId(Integer visitorQrId) {
        this.visitorQrId = visitorQrId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getReadSubDeviceId() {
        return readSubDeviceId;
    }

    public void setReadSubDeviceId(Integer readSubDeviceId) {
        this.readSubDeviceId = readSubDeviceId;
    }

    public String getReadInfo() {
        return readInfo;
    }

    public void setReadInfo(String readInfo) {
        this.readInfo = readInfo;
    }

    public Integer getActivTime() {
        return activTime;
    }

    public void setActivTime(Integer activTime) {
        this.activTime = activTime;
    }

    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc;
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
        OpenLog other = (OpenLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHeId() == null ? other.getHeId() == null : this.getHeId().equals(other.getHeId()))
            && (this.getBuildingId() == null ? other.getBuildingId() == null : this.getBuildingId().equals(other.getBuildingId()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getOpenSubDeviceId() == null ? other.getOpenSubDeviceId() == null : this.getOpenSubDeviceId().equals(other.getOpenSubDeviceId()))
            && (this.getOpenType() == null ? other.getOpenType() == null : this.getOpenType().equals(other.getOpenType()))
            && (this.getCardNumber() == null ? other.getCardNumber() == null : this.getCardNumber().equals(other.getCardNumber()))
            && (this.getVisitorQrId() == null ? other.getVisitorQrId() == null : this.getVisitorQrId().equals(other.getVisitorQrId()))
            && (this.getOwnerId() == null ? other.getOwnerId() == null : this.getOwnerId().equals(other.getOwnerId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getReadSubDeviceId() == null ? other.getReadSubDeviceId() == null : this.getReadSubDeviceId().equals(other.getReadSubDeviceId()))
            && (this.getReadInfo() == null ? other.getReadInfo() == null : this.getReadInfo().equals(other.getReadInfo()))
            && (this.getActivTime() == null ? other.getActivTime() == null : this.getActivTime().equals(other.getActivTime()))
            && (this.getLogDesc() == null ? other.getLogDesc() == null : this.getLogDesc().equals(other.getLogDesc()))
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
        result = prime * result + ((getHeId() == null) ? 0 : getHeId().hashCode());
        result = prime * result + ((getBuildingId() == null) ? 0 : getBuildingId().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getOpenSubDeviceId() == null) ? 0 : getOpenSubDeviceId().hashCode());
        result = prime * result + ((getOpenType() == null) ? 0 : getOpenType().hashCode());
        result = prime * result + ((getCardNumber() == null) ? 0 : getCardNumber().hashCode());
        result = prime * result + ((getVisitorQrId() == null) ? 0 : getVisitorQrId().hashCode());
        result = prime * result + ((getOwnerId() == null) ? 0 : getOwnerId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getReadSubDeviceId() == null) ? 0 : getReadSubDeviceId().hashCode());
        result = prime * result + ((getReadInfo() == null) ? 0 : getReadInfo().hashCode());
        result = prime * result + ((getActivTime() == null) ? 0 : getActivTime().hashCode());
        result = prime * result + ((getLogDesc() == null) ? 0 : getLogDesc().hashCode());
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
        sb.append(", heId=").append(heId);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", unitId=").append(unitId);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", openSubDeviceId=").append(openSubDeviceId);
        sb.append(", openType=").append(openType);
        sb.append(", cardNumber=").append(cardNumber);
        sb.append(", visitorQrId=").append(visitorQrId);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", userId=").append(userId);
        sb.append(", houseId=").append(houseId);
        sb.append(", readSubDeviceId=").append(readSubDeviceId);
        sb.append(", readInfo=").append(readInfo);
        sb.append(", activTime=").append(activTime);
        sb.append(", logDesc=").append(logDesc);
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