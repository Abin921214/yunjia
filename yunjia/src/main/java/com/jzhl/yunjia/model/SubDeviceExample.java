package com.jzhl.yunjia.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubDeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public SubDeviceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(Integer value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(Integer value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(Integer value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(Integer value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<Integer> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<Integer> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(Integer value1, Integer value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialIsNull() {
            addCriterion("device_serial is null");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialIsNotNull() {
            addCriterion("device_serial is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialEqualTo(String value) {
            addCriterion("device_serial =", value, "deviceSerial");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNotEqualTo(String value) {
            addCriterion("device_serial <>", value, "deviceSerial");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialGreaterThan(String value) {
            addCriterion("device_serial >", value, "deviceSerial");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialGreaterThanOrEqualTo(String value) {
            addCriterion("device_serial >=", value, "deviceSerial");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialLessThan(String value) {
            addCriterion("device_serial <", value, "deviceSerial");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialLessThanOrEqualTo(String value) {
            addCriterion("device_serial <=", value, "deviceSerial");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialLike(String value) {
            addCriterion("device_serial like", value, "deviceSerial");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNotLike(String value) {
            addCriterion("device_serial not like", value, "deviceSerial");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialIn(List<String> values) {
            addCriterion("device_serial in", values, "deviceSerial");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNotIn(List<String> values) {
            addCriterion("device_serial not in", values, "deviceSerial");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialBetween(String value1, String value2) {
            addCriterion("device_serial between", value1, value2, "deviceSerial");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNotBetween(String value1, String value2) {
            addCriterion("device_serial not between", value1, value2, "deviceSerial");
            return (Criteria) this;
        }

        public Criteria andDeviceCustomIdIsNull() {
            addCriterion("device_custom_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceCustomIdIsNotNull() {
            addCriterion("device_custom_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceCustomIdEqualTo(String value) {
            addCriterion("device_custom_id =", value, "deviceCustomId");
            return (Criteria) this;
        }

        public Criteria andDeviceCustomIdNotEqualTo(String value) {
            addCriterion("device_custom_id <>", value, "deviceCustomId");
            return (Criteria) this;
        }

        public Criteria andDeviceCustomIdGreaterThan(String value) {
            addCriterion("device_custom_id >", value, "deviceCustomId");
            return (Criteria) this;
        }

        public Criteria andDeviceCustomIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_custom_id >=", value, "deviceCustomId");
            return (Criteria) this;
        }

        public Criteria andDeviceCustomIdLessThan(String value) {
            addCriterion("device_custom_id <", value, "deviceCustomId");
            return (Criteria) this;
        }

        public Criteria andDeviceCustomIdLessThanOrEqualTo(String value) {
            addCriterion("device_custom_id <=", value, "deviceCustomId");
            return (Criteria) this;
        }

        public Criteria andDeviceCustomIdLike(String value) {
            addCriterion("device_custom_id like", value, "deviceCustomId");
            return (Criteria) this;
        }

        public Criteria andDeviceCustomIdNotLike(String value) {
            addCriterion("device_custom_id not like", value, "deviceCustomId");
            return (Criteria) this;
        }

        public Criteria andDeviceCustomIdIn(List<String> values) {
            addCriterion("device_custom_id in", values, "deviceCustomId");
            return (Criteria) this;
        }

        public Criteria andDeviceCustomIdNotIn(List<String> values) {
            addCriterion("device_custom_id not in", values, "deviceCustomId");
            return (Criteria) this;
        }

        public Criteria andDeviceCustomIdBetween(String value1, String value2) {
            addCriterion("device_custom_id between", value1, value2, "deviceCustomId");
            return (Criteria) this;
        }

        public Criteria andDeviceCustomIdNotBetween(String value1, String value2) {
            addCriterion("device_custom_id not between", value1, value2, "deviceCustomId");
            return (Criteria) this;
        }

        public Criteria andSerialIsNull() {
            addCriterion("serial is null");
            return (Criteria) this;
        }

        public Criteria andSerialIsNotNull() {
            addCriterion("serial is not null");
            return (Criteria) this;
        }

        public Criteria andSerialEqualTo(String value) {
            addCriterion("serial =", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotEqualTo(String value) {
            addCriterion("serial <>", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialGreaterThan(String value) {
            addCriterion("serial >", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialGreaterThanOrEqualTo(String value) {
            addCriterion("serial >=", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLessThan(String value) {
            addCriterion("serial <", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLessThanOrEqualTo(String value) {
            addCriterion("serial <=", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLike(String value) {
            addCriterion("serial like", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotLike(String value) {
            addCriterion("serial not like", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialIn(List<String> values) {
            addCriterion("serial in", values, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotIn(List<String> values) {
            addCriterion("serial not in", values, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialBetween(String value1, String value2) {
            addCriterion("serial between", value1, value2, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotBetween(String value1, String value2) {
            addCriterion("serial not between", value1, value2, "serial");
            return (Criteria) this;
        }

        public Criteria andCustomIdIsNull() {
            addCriterion("custom_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomIdIsNotNull() {
            addCriterion("custom_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomIdEqualTo(String value) {
            addCriterion("custom_id =", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdNotEqualTo(String value) {
            addCriterion("custom_id <>", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdGreaterThan(String value) {
            addCriterion("custom_id >", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdGreaterThanOrEqualTo(String value) {
            addCriterion("custom_id >=", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdLessThan(String value) {
            addCriterion("custom_id <", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdLessThanOrEqualTo(String value) {
            addCriterion("custom_id <=", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdLike(String value) {
            addCriterion("custom_id like", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdNotLike(String value) {
            addCriterion("custom_id not like", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdIn(List<String> values) {
            addCriterion("custom_id in", values, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdNotIn(List<String> values) {
            addCriterion("custom_id not in", values, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdBetween(String value1, String value2) {
            addCriterion("custom_id between", value1, value2, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdNotBetween(String value1, String value2) {
            addCriterion("custom_id not between", value1, value2, "customId");
            return (Criteria) this;
        }

        public Criteria andHeIdIsNull() {
            addCriterion("he_id is null");
            return (Criteria) this;
        }

        public Criteria andHeIdIsNotNull() {
            addCriterion("he_id is not null");
            return (Criteria) this;
        }

        public Criteria andHeIdEqualTo(Integer value) {
            addCriterion("he_id =", value, "heId");
            return (Criteria) this;
        }

        public Criteria andHeIdNotEqualTo(Integer value) {
            addCriterion("he_id <>", value, "heId");
            return (Criteria) this;
        }

        public Criteria andHeIdGreaterThan(Integer value) {
            addCriterion("he_id >", value, "heId");
            return (Criteria) this;
        }

        public Criteria andHeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("he_id >=", value, "heId");
            return (Criteria) this;
        }

        public Criteria andHeIdLessThan(Integer value) {
            addCriterion("he_id <", value, "heId");
            return (Criteria) this;
        }

        public Criteria andHeIdLessThanOrEqualTo(Integer value) {
            addCriterion("he_id <=", value, "heId");
            return (Criteria) this;
        }

        public Criteria andHeIdIn(List<Integer> values) {
            addCriterion("he_id in", values, "heId");
            return (Criteria) this;
        }

        public Criteria andHeIdNotIn(List<Integer> values) {
            addCriterion("he_id not in", values, "heId");
            return (Criteria) this;
        }

        public Criteria andHeIdBetween(Integer value1, Integer value2) {
            addCriterion("he_id between", value1, value2, "heId");
            return (Criteria) this;
        }

        public Criteria andHeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("he_id not between", value1, value2, "heId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNull() {
            addCriterion("building_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("building_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(Integer value) {
            addCriterion("building_id =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(Integer value) {
            addCriterion("building_id <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(Integer value) {
            addCriterion("building_id >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("building_id >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(Integer value) {
            addCriterion("building_id <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(Integer value) {
            addCriterion("building_id <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<Integer> values) {
            addCriterion("building_id in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<Integer> values) {
            addCriterion("building_id not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(Integer value1, Integer value2) {
            addCriterion("building_id between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("building_id not between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andUnitIdIsNull() {
            addCriterion("unit_id is null");
            return (Criteria) this;
        }

        public Criteria andUnitIdIsNotNull() {
            addCriterion("unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnitIdEqualTo(Integer value) {
            addCriterion("unit_id =", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotEqualTo(Integer value) {
            addCriterion("unit_id <>", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThan(Integer value) {
            addCriterion("unit_id >", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("unit_id >=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThan(Integer value) {
            addCriterion("unit_id <", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThanOrEqualTo(Integer value) {
            addCriterion("unit_id <=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdIn(List<Integer> values) {
            addCriterion("unit_id in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotIn(List<Integer> values) {
            addCriterion("unit_id not in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdBetween(Integer value1, Integer value2) {
            addCriterion("unit_id between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotBetween(Integer value1, Integer value2) {
            addCriterion("unit_id not between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andSubDeviceNameIsNull() {
            addCriterion("sub_device_name is null");
            return (Criteria) this;
        }

        public Criteria andSubDeviceNameIsNotNull() {
            addCriterion("sub_device_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubDeviceNameEqualTo(String value) {
            addCriterion("sub_device_name =", value, "subDeviceName");
            return (Criteria) this;
        }

        public Criteria andSubDeviceNameNotEqualTo(String value) {
            addCriterion("sub_device_name <>", value, "subDeviceName");
            return (Criteria) this;
        }

        public Criteria andSubDeviceNameGreaterThan(String value) {
            addCriterion("sub_device_name >", value, "subDeviceName");
            return (Criteria) this;
        }

        public Criteria andSubDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("sub_device_name >=", value, "subDeviceName");
            return (Criteria) this;
        }

        public Criteria andSubDeviceNameLessThan(String value) {
            addCriterion("sub_device_name <", value, "subDeviceName");
            return (Criteria) this;
        }

        public Criteria andSubDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("sub_device_name <=", value, "subDeviceName");
            return (Criteria) this;
        }

        public Criteria andSubDeviceNameLike(String value) {
            addCriterion("sub_device_name like", value, "subDeviceName");
            return (Criteria) this;
        }

        public Criteria andSubDeviceNameNotLike(String value) {
            addCriterion("sub_device_name not like", value, "subDeviceName");
            return (Criteria) this;
        }

        public Criteria andSubDeviceNameIn(List<String> values) {
            addCriterion("sub_device_name in", values, "subDeviceName");
            return (Criteria) this;
        }

        public Criteria andSubDeviceNameNotIn(List<String> values) {
            addCriterion("sub_device_name not in", values, "subDeviceName");
            return (Criteria) this;
        }

        public Criteria andSubDeviceNameBetween(String value1, String value2) {
            addCriterion("sub_device_name between", value1, value2, "subDeviceName");
            return (Criteria) this;
        }

        public Criteria andSubDeviceNameNotBetween(String value1, String value2) {
            addCriterion("sub_device_name not between", value1, value2, "subDeviceName");
            return (Criteria) this;
        }

        public Criteria andSubDeviceDescIsNull() {
            addCriterion("sub_device_desc is null");
            return (Criteria) this;
        }

        public Criteria andSubDeviceDescIsNotNull() {
            addCriterion("sub_device_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSubDeviceDescEqualTo(String value) {
            addCriterion("sub_device_desc =", value, "subDeviceDesc");
            return (Criteria) this;
        }

        public Criteria andSubDeviceDescNotEqualTo(String value) {
            addCriterion("sub_device_desc <>", value, "subDeviceDesc");
            return (Criteria) this;
        }

        public Criteria andSubDeviceDescGreaterThan(String value) {
            addCriterion("sub_device_desc >", value, "subDeviceDesc");
            return (Criteria) this;
        }

        public Criteria andSubDeviceDescGreaterThanOrEqualTo(String value) {
            addCriterion("sub_device_desc >=", value, "subDeviceDesc");
            return (Criteria) this;
        }

        public Criteria andSubDeviceDescLessThan(String value) {
            addCriterion("sub_device_desc <", value, "subDeviceDesc");
            return (Criteria) this;
        }

        public Criteria andSubDeviceDescLessThanOrEqualTo(String value) {
            addCriterion("sub_device_desc <=", value, "subDeviceDesc");
            return (Criteria) this;
        }

        public Criteria andSubDeviceDescLike(String value) {
            addCriterion("sub_device_desc like", value, "subDeviceDesc");
            return (Criteria) this;
        }

        public Criteria andSubDeviceDescNotLike(String value) {
            addCriterion("sub_device_desc not like", value, "subDeviceDesc");
            return (Criteria) this;
        }

        public Criteria andSubDeviceDescIn(List<String> values) {
            addCriterion("sub_device_desc in", values, "subDeviceDesc");
            return (Criteria) this;
        }

        public Criteria andSubDeviceDescNotIn(List<String> values) {
            addCriterion("sub_device_desc not in", values, "subDeviceDesc");
            return (Criteria) this;
        }

        public Criteria andSubDeviceDescBetween(String value1, String value2) {
            addCriterion("sub_device_desc between", value1, value2, "subDeviceDesc");
            return (Criteria) this;
        }

        public Criteria andSubDeviceDescNotBetween(String value1, String value2) {
            addCriterion("sub_device_desc not between", value1, value2, "subDeviceDesc");
            return (Criteria) this;
        }

        public Criteria andSubDeviceTypeIsNull() {
            addCriterion("sub_device_type is null");
            return (Criteria) this;
        }

        public Criteria andSubDeviceTypeIsNotNull() {
            addCriterion("sub_device_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubDeviceTypeEqualTo(String value) {
            addCriterion("sub_device_type =", value, "subDeviceType");
            return (Criteria) this;
        }

        public Criteria andSubDeviceTypeNotEqualTo(String value) {
            addCriterion("sub_device_type <>", value, "subDeviceType");
            return (Criteria) this;
        }

        public Criteria andSubDeviceTypeGreaterThan(String value) {
            addCriterion("sub_device_type >", value, "subDeviceType");
            return (Criteria) this;
        }

        public Criteria andSubDeviceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sub_device_type >=", value, "subDeviceType");
            return (Criteria) this;
        }

        public Criteria andSubDeviceTypeLessThan(String value) {
            addCriterion("sub_device_type <", value, "subDeviceType");
            return (Criteria) this;
        }

        public Criteria andSubDeviceTypeLessThanOrEqualTo(String value) {
            addCriterion("sub_device_type <=", value, "subDeviceType");
            return (Criteria) this;
        }

        public Criteria andSubDeviceTypeLike(String value) {
            addCriterion("sub_device_type like", value, "subDeviceType");
            return (Criteria) this;
        }

        public Criteria andSubDeviceTypeNotLike(String value) {
            addCriterion("sub_device_type not like", value, "subDeviceType");
            return (Criteria) this;
        }

        public Criteria andSubDeviceTypeIn(List<String> values) {
            addCriterion("sub_device_type in", values, "subDeviceType");
            return (Criteria) this;
        }

        public Criteria andSubDeviceTypeNotIn(List<String> values) {
            addCriterion("sub_device_type not in", values, "subDeviceType");
            return (Criteria) this;
        }

        public Criteria andSubDeviceTypeBetween(String value1, String value2) {
            addCriterion("sub_device_type between", value1, value2, "subDeviceType");
            return (Criteria) this;
        }

        public Criteria andSubDeviceTypeNotBetween(String value1, String value2) {
            addCriterion("sub_device_type not between", value1, value2, "subDeviceType");
            return (Criteria) this;
        }

        public Criteria andActivTypeIsNull() {
            addCriterion("activ_type is null");
            return (Criteria) this;
        }

        public Criteria andActivTypeIsNotNull() {
            addCriterion("activ_type is not null");
            return (Criteria) this;
        }

        public Criteria andActivTypeEqualTo(Integer value) {
            addCriterion("activ_type =", value, "activType");
            return (Criteria) this;
        }

        public Criteria andActivTypeNotEqualTo(Integer value) {
            addCriterion("activ_type <>", value, "activType");
            return (Criteria) this;
        }

        public Criteria andActivTypeGreaterThan(Integer value) {
            addCriterion("activ_type >", value, "activType");
            return (Criteria) this;
        }

        public Criteria andActivTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("activ_type >=", value, "activType");
            return (Criteria) this;
        }

        public Criteria andActivTypeLessThan(Integer value) {
            addCriterion("activ_type <", value, "activType");
            return (Criteria) this;
        }

        public Criteria andActivTypeLessThanOrEqualTo(Integer value) {
            addCriterion("activ_type <=", value, "activType");
            return (Criteria) this;
        }

        public Criteria andActivTypeIn(List<Integer> values) {
            addCriterion("activ_type in", values, "activType");
            return (Criteria) this;
        }

        public Criteria andActivTypeNotIn(List<Integer> values) {
            addCriterion("activ_type not in", values, "activType");
            return (Criteria) this;
        }

        public Criteria andActivTypeBetween(Integer value1, Integer value2) {
            addCriterion("activ_type between", value1, value2, "activType");
            return (Criteria) this;
        }

        public Criteria andActivTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("activ_type not between", value1, value2, "activType");
            return (Criteria) this;
        }

        public Criteria andActivTimeIsNull() {
            addCriterion("activ_time is null");
            return (Criteria) this;
        }

        public Criteria andActivTimeIsNotNull() {
            addCriterion("activ_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivTimeEqualTo(Integer value) {
            addCriterion("activ_time =", value, "activTime");
            return (Criteria) this;
        }

        public Criteria andActivTimeNotEqualTo(Integer value) {
            addCriterion("activ_time <>", value, "activTime");
            return (Criteria) this;
        }

        public Criteria andActivTimeGreaterThan(Integer value) {
            addCriterion("activ_time >", value, "activTime");
            return (Criteria) this;
        }

        public Criteria andActivTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("activ_time >=", value, "activTime");
            return (Criteria) this;
        }

        public Criteria andActivTimeLessThan(Integer value) {
            addCriterion("activ_time <", value, "activTime");
            return (Criteria) this;
        }

        public Criteria andActivTimeLessThanOrEqualTo(Integer value) {
            addCriterion("activ_time <=", value, "activTime");
            return (Criteria) this;
        }

        public Criteria andActivTimeIn(List<Integer> values) {
            addCriterion("activ_time in", values, "activTime");
            return (Criteria) this;
        }

        public Criteria andActivTimeNotIn(List<Integer> values) {
            addCriterion("activ_time not in", values, "activTime");
            return (Criteria) this;
        }

        public Criteria andActivTimeBetween(Integer value1, Integer value2) {
            addCriterion("activ_time between", value1, value2, "activTime");
            return (Criteria) this;
        }

        public Criteria andActivTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("activ_time not between", value1, value2, "activTime");
            return (Criteria) this;
        }

        public Criteria andSubDeviceUrlIsNull() {
            addCriterion("sub_device_url is null");
            return (Criteria) this;
        }

        public Criteria andSubDeviceUrlIsNotNull() {
            addCriterion("sub_device_url is not null");
            return (Criteria) this;
        }

        public Criteria andSubDeviceUrlEqualTo(String value) {
            addCriterion("sub_device_url =", value, "subDeviceUrl");
            return (Criteria) this;
        }

        public Criteria andSubDeviceUrlNotEqualTo(String value) {
            addCriterion("sub_device_url <>", value, "subDeviceUrl");
            return (Criteria) this;
        }

        public Criteria andSubDeviceUrlGreaterThan(String value) {
            addCriterion("sub_device_url >", value, "subDeviceUrl");
            return (Criteria) this;
        }

        public Criteria andSubDeviceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("sub_device_url >=", value, "subDeviceUrl");
            return (Criteria) this;
        }

        public Criteria andSubDeviceUrlLessThan(String value) {
            addCriterion("sub_device_url <", value, "subDeviceUrl");
            return (Criteria) this;
        }

        public Criteria andSubDeviceUrlLessThanOrEqualTo(String value) {
            addCriterion("sub_device_url <=", value, "subDeviceUrl");
            return (Criteria) this;
        }

        public Criteria andSubDeviceUrlLike(String value) {
            addCriterion("sub_device_url like", value, "subDeviceUrl");
            return (Criteria) this;
        }

        public Criteria andSubDeviceUrlNotLike(String value) {
            addCriterion("sub_device_url not like", value, "subDeviceUrl");
            return (Criteria) this;
        }

        public Criteria andSubDeviceUrlIn(List<String> values) {
            addCriterion("sub_device_url in", values, "subDeviceUrl");
            return (Criteria) this;
        }

        public Criteria andSubDeviceUrlNotIn(List<String> values) {
            addCriterion("sub_device_url not in", values, "subDeviceUrl");
            return (Criteria) this;
        }

        public Criteria andSubDeviceUrlBetween(String value1, String value2) {
            addCriterion("sub_device_url between", value1, value2, "subDeviceUrl");
            return (Criteria) this;
        }

        public Criteria andSubDeviceUrlNotBetween(String value1, String value2) {
            addCriterion("sub_device_url not between", value1, value2, "subDeviceUrl");
            return (Criteria) this;
        }

        public Criteria andOnlineIsNull() {
            addCriterion("`online` is null");
            return (Criteria) this;
        }

        public Criteria andOnlineIsNotNull() {
            addCriterion("`online` is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineEqualTo(String value) {
            addCriterion("`online` =", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotEqualTo(String value) {
            addCriterion("`online` <>", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThan(String value) {
            addCriterion("`online` >", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThanOrEqualTo(String value) {
            addCriterion("`online` >=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThan(String value) {
            addCriterion("`online` <", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThanOrEqualTo(String value) {
            addCriterion("`online` <=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLike(String value) {
            addCriterion("`online` like", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotLike(String value) {
            addCriterion("`online` not like", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineIn(List<String> values) {
            addCriterion("`online` in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotIn(List<String> values) {
            addCriterion("`online` not in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineBetween(String value1, String value2) {
            addCriterion("`online` between", value1, value2, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotBetween(String value1, String value2) {
            addCriterion("`online` not between", value1, value2, "online");
            return (Criteria) this;
        }

        public Criteria andFaceThresholdIsNull() {
            addCriterion("face_threshold is null");
            return (Criteria) this;
        }

        public Criteria andFaceThresholdIsNotNull() {
            addCriterion("face_threshold is not null");
            return (Criteria) this;
        }

        public Criteria andFaceThresholdEqualTo(Integer value) {
            addCriterion("face_threshold =", value, "faceThreshold");
            return (Criteria) this;
        }

        public Criteria andFaceThresholdNotEqualTo(Integer value) {
            addCriterion("face_threshold <>", value, "faceThreshold");
            return (Criteria) this;
        }

        public Criteria andFaceThresholdGreaterThan(Integer value) {
            addCriterion("face_threshold >", value, "faceThreshold");
            return (Criteria) this;
        }

        public Criteria andFaceThresholdGreaterThanOrEqualTo(Integer value) {
            addCriterion("face_threshold >=", value, "faceThreshold");
            return (Criteria) this;
        }

        public Criteria andFaceThresholdLessThan(Integer value) {
            addCriterion("face_threshold <", value, "faceThreshold");
            return (Criteria) this;
        }

        public Criteria andFaceThresholdLessThanOrEqualTo(Integer value) {
            addCriterion("face_threshold <=", value, "faceThreshold");
            return (Criteria) this;
        }

        public Criteria andFaceThresholdIn(List<Integer> values) {
            addCriterion("face_threshold in", values, "faceThreshold");
            return (Criteria) this;
        }

        public Criteria andFaceThresholdNotIn(List<Integer> values) {
            addCriterion("face_threshold not in", values, "faceThreshold");
            return (Criteria) this;
        }

        public Criteria andFaceThresholdBetween(Integer value1, Integer value2) {
            addCriterion("face_threshold between", value1, value2, "faceThreshold");
            return (Criteria) this;
        }

        public Criteria andFaceThresholdNotBetween(Integer value1, Integer value2) {
            addCriterion("face_threshold not between", value1, value2, "faceThreshold");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("`status` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`status` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("del_flag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("del_flag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andBuildUseridIsNull() {
            addCriterion("build_userid is null");
            return (Criteria) this;
        }

        public Criteria andBuildUseridIsNotNull() {
            addCriterion("build_userid is not null");
            return (Criteria) this;
        }

        public Criteria andBuildUseridEqualTo(Integer value) {
            addCriterion("build_userid =", value, "buildUserid");
            return (Criteria) this;
        }

        public Criteria andBuildUseridNotEqualTo(Integer value) {
            addCriterion("build_userid <>", value, "buildUserid");
            return (Criteria) this;
        }

        public Criteria andBuildUseridGreaterThan(Integer value) {
            addCriterion("build_userid >", value, "buildUserid");
            return (Criteria) this;
        }

        public Criteria andBuildUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("build_userid >=", value, "buildUserid");
            return (Criteria) this;
        }

        public Criteria andBuildUseridLessThan(Integer value) {
            addCriterion("build_userid <", value, "buildUserid");
            return (Criteria) this;
        }

        public Criteria andBuildUseridLessThanOrEqualTo(Integer value) {
            addCriterion("build_userid <=", value, "buildUserid");
            return (Criteria) this;
        }

        public Criteria andBuildUseridIn(List<Integer> values) {
            addCriterion("build_userid in", values, "buildUserid");
            return (Criteria) this;
        }

        public Criteria andBuildUseridNotIn(List<Integer> values) {
            addCriterion("build_userid not in", values, "buildUserid");
            return (Criteria) this;
        }

        public Criteria andBuildUseridBetween(Integer value1, Integer value2) {
            addCriterion("build_userid between", value1, value2, "buildUserid");
            return (Criteria) this;
        }

        public Criteria andBuildUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("build_userid not between", value1, value2, "buildUserid");
            return (Criteria) this;
        }

        public Criteria andBuildTimeIsNull() {
            addCriterion("build_time is null");
            return (Criteria) this;
        }

        public Criteria andBuildTimeIsNotNull() {
            addCriterion("build_time is not null");
            return (Criteria) this;
        }

        public Criteria andBuildTimeEqualTo(Date value) {
            addCriterion("build_time =", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeNotEqualTo(Date value) {
            addCriterion("build_time <>", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeGreaterThan(Date value) {
            addCriterion("build_time >", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("build_time >=", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeLessThan(Date value) {
            addCriterion("build_time <", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeLessThanOrEqualTo(Date value) {
            addCriterion("build_time <=", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeIn(List<Date> values) {
            addCriterion("build_time in", values, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeNotIn(List<Date> values) {
            addCriterion("build_time not in", values, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeBetween(Date value1, Date value2) {
            addCriterion("build_time between", value1, value2, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeNotBetween(Date value1, Date value2) {
            addCriterion("build_time not between", value1, value2, "buildTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridIsNull() {
            addCriterion("update_userid is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridIsNotNull() {
            addCriterion("update_userid is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridEqualTo(Integer value) {
            addCriterion("update_userid =", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridNotEqualTo(Integer value) {
            addCriterion("update_userid <>", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridGreaterThan(Integer value) {
            addCriterion("update_userid >", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_userid >=", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridLessThan(Integer value) {
            addCriterion("update_userid <", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridLessThanOrEqualTo(Integer value) {
            addCriterion("update_userid <=", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridIn(List<Integer> values) {
            addCriterion("update_userid in", values, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridNotIn(List<Integer> values) {
            addCriterion("update_userid not in", values, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridBetween(Integer value1, Integer value2) {
            addCriterion("update_userid between", value1, value2, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("update_userid not between", value1, value2, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}