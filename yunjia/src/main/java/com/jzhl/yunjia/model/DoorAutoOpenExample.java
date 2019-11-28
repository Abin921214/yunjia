package com.jzhl.yunjia.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DoorAutoOpenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public DoorAutoOpenExample() {
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

        public Criteria andSubDeviceIdIsNull() {
            addCriterion("sub_device_id is null");
            return (Criteria) this;
        }

        public Criteria andSubDeviceIdIsNotNull() {
            addCriterion("sub_device_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubDeviceIdEqualTo(Integer value) {
            addCriterion("sub_device_id =", value, "subDeviceId");
            return (Criteria) this;
        }

        public Criteria andSubDeviceIdNotEqualTo(Integer value) {
            addCriterion("sub_device_id <>", value, "subDeviceId");
            return (Criteria) this;
        }

        public Criteria andSubDeviceIdGreaterThan(Integer value) {
            addCriterion("sub_device_id >", value, "subDeviceId");
            return (Criteria) this;
        }

        public Criteria andSubDeviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_device_id >=", value, "subDeviceId");
            return (Criteria) this;
        }

        public Criteria andSubDeviceIdLessThan(Integer value) {
            addCriterion("sub_device_id <", value, "subDeviceId");
            return (Criteria) this;
        }

        public Criteria andSubDeviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("sub_device_id <=", value, "subDeviceId");
            return (Criteria) this;
        }

        public Criteria andSubDeviceIdIn(List<Integer> values) {
            addCriterion("sub_device_id in", values, "subDeviceId");
            return (Criteria) this;
        }

        public Criteria andSubDeviceIdNotIn(List<Integer> values) {
            addCriterion("sub_device_id not in", values, "subDeviceId");
            return (Criteria) this;
        }

        public Criteria andSubDeviceIdBetween(Integer value1, Integer value2) {
            addCriterion("sub_device_id between", value1, value2, "subDeviceId");
            return (Criteria) this;
        }

        public Criteria andSubDeviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_device_id not between", value1, value2, "subDeviceId");
            return (Criteria) this;
        }

        public Criteria andActiveTypeIsNull() {
            addCriterion("active_type is null");
            return (Criteria) this;
        }

        public Criteria andActiveTypeIsNotNull() {
            addCriterion("active_type is not null");
            return (Criteria) this;
        }

        public Criteria andActiveTypeEqualTo(Integer value) {
            addCriterion("active_type =", value, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeNotEqualTo(Integer value) {
            addCriterion("active_type <>", value, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeGreaterThan(Integer value) {
            addCriterion("active_type >", value, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("active_type >=", value, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeLessThan(Integer value) {
            addCriterion("active_type <", value, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeLessThanOrEqualTo(Integer value) {
            addCriterion("active_type <=", value, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeIn(List<Integer> values) {
            addCriterion("active_type in", values, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeNotIn(List<Integer> values) {
            addCriterion("active_type not in", values, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeBetween(Integer value1, Integer value2) {
            addCriterion("active_type between", value1, value2, "activeType");
            return (Criteria) this;
        }

        public Criteria andActiveTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("active_type not between", value1, value2, "activeType");
            return (Criteria) this;
        }

        public Criteria andStartHourIsNull() {
            addCriterion("start_hour is null");
            return (Criteria) this;
        }

        public Criteria andStartHourIsNotNull() {
            addCriterion("start_hour is not null");
            return (Criteria) this;
        }

        public Criteria andStartHourEqualTo(String value) {
            addCriterion("start_hour =", value, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourNotEqualTo(String value) {
            addCriterion("start_hour <>", value, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourGreaterThan(String value) {
            addCriterion("start_hour >", value, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourGreaterThanOrEqualTo(String value) {
            addCriterion("start_hour >=", value, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourLessThan(String value) {
            addCriterion("start_hour <", value, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourLessThanOrEqualTo(String value) {
            addCriterion("start_hour <=", value, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourLike(String value) {
            addCriterion("start_hour like", value, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourNotLike(String value) {
            addCriterion("start_hour not like", value, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourIn(List<String> values) {
            addCriterion("start_hour in", values, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourNotIn(List<String> values) {
            addCriterion("start_hour not in", values, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourBetween(String value1, String value2) {
            addCriterion("start_hour between", value1, value2, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourNotBetween(String value1, String value2) {
            addCriterion("start_hour not between", value1, value2, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartMinuteIsNull() {
            addCriterion("start_minute is null");
            return (Criteria) this;
        }

        public Criteria andStartMinuteIsNotNull() {
            addCriterion("start_minute is not null");
            return (Criteria) this;
        }

        public Criteria andStartMinuteEqualTo(String value) {
            addCriterion("start_minute =", value, "startMinute");
            return (Criteria) this;
        }

        public Criteria andStartMinuteNotEqualTo(String value) {
            addCriterion("start_minute <>", value, "startMinute");
            return (Criteria) this;
        }

        public Criteria andStartMinuteGreaterThan(String value) {
            addCriterion("start_minute >", value, "startMinute");
            return (Criteria) this;
        }

        public Criteria andStartMinuteGreaterThanOrEqualTo(String value) {
            addCriterion("start_minute >=", value, "startMinute");
            return (Criteria) this;
        }

        public Criteria andStartMinuteLessThan(String value) {
            addCriterion("start_minute <", value, "startMinute");
            return (Criteria) this;
        }

        public Criteria andStartMinuteLessThanOrEqualTo(String value) {
            addCriterion("start_minute <=", value, "startMinute");
            return (Criteria) this;
        }

        public Criteria andStartMinuteLike(String value) {
            addCriterion("start_minute like", value, "startMinute");
            return (Criteria) this;
        }

        public Criteria andStartMinuteNotLike(String value) {
            addCriterion("start_minute not like", value, "startMinute");
            return (Criteria) this;
        }

        public Criteria andStartMinuteIn(List<String> values) {
            addCriterion("start_minute in", values, "startMinute");
            return (Criteria) this;
        }

        public Criteria andStartMinuteNotIn(List<String> values) {
            addCriterion("start_minute not in", values, "startMinute");
            return (Criteria) this;
        }

        public Criteria andStartMinuteBetween(String value1, String value2) {
            addCriterion("start_minute between", value1, value2, "startMinute");
            return (Criteria) this;
        }

        public Criteria andStartMinuteNotBetween(String value1, String value2) {
            addCriterion("start_minute not between", value1, value2, "startMinute");
            return (Criteria) this;
        }

        public Criteria andEndHourIsNull() {
            addCriterion("end_hour is null");
            return (Criteria) this;
        }

        public Criteria andEndHourIsNotNull() {
            addCriterion("end_hour is not null");
            return (Criteria) this;
        }

        public Criteria andEndHourEqualTo(String value) {
            addCriterion("end_hour =", value, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourNotEqualTo(String value) {
            addCriterion("end_hour <>", value, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourGreaterThan(String value) {
            addCriterion("end_hour >", value, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourGreaterThanOrEqualTo(String value) {
            addCriterion("end_hour >=", value, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourLessThan(String value) {
            addCriterion("end_hour <", value, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourLessThanOrEqualTo(String value) {
            addCriterion("end_hour <=", value, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourLike(String value) {
            addCriterion("end_hour like", value, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourNotLike(String value) {
            addCriterion("end_hour not like", value, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourIn(List<String> values) {
            addCriterion("end_hour in", values, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourNotIn(List<String> values) {
            addCriterion("end_hour not in", values, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourBetween(String value1, String value2) {
            addCriterion("end_hour between", value1, value2, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourNotBetween(String value1, String value2) {
            addCriterion("end_hour not between", value1, value2, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndMinuteIsNull() {
            addCriterion("end_minute is null");
            return (Criteria) this;
        }

        public Criteria andEndMinuteIsNotNull() {
            addCriterion("end_minute is not null");
            return (Criteria) this;
        }

        public Criteria andEndMinuteEqualTo(String value) {
            addCriterion("end_minute =", value, "endMinute");
            return (Criteria) this;
        }

        public Criteria andEndMinuteNotEqualTo(String value) {
            addCriterion("end_minute <>", value, "endMinute");
            return (Criteria) this;
        }

        public Criteria andEndMinuteGreaterThan(String value) {
            addCriterion("end_minute >", value, "endMinute");
            return (Criteria) this;
        }

        public Criteria andEndMinuteGreaterThanOrEqualTo(String value) {
            addCriterion("end_minute >=", value, "endMinute");
            return (Criteria) this;
        }

        public Criteria andEndMinuteLessThan(String value) {
            addCriterion("end_minute <", value, "endMinute");
            return (Criteria) this;
        }

        public Criteria andEndMinuteLessThanOrEqualTo(String value) {
            addCriterion("end_minute <=", value, "endMinute");
            return (Criteria) this;
        }

        public Criteria andEndMinuteLike(String value) {
            addCriterion("end_minute like", value, "endMinute");
            return (Criteria) this;
        }

        public Criteria andEndMinuteNotLike(String value) {
            addCriterion("end_minute not like", value, "endMinute");
            return (Criteria) this;
        }

        public Criteria andEndMinuteIn(List<String> values) {
            addCriterion("end_minute in", values, "endMinute");
            return (Criteria) this;
        }

        public Criteria andEndMinuteNotIn(List<String> values) {
            addCriterion("end_minute not in", values, "endMinute");
            return (Criteria) this;
        }

        public Criteria andEndMinuteBetween(String value1, String value2) {
            addCriterion("end_minute between", value1, value2, "endMinute");
            return (Criteria) this;
        }

        public Criteria andEndMinuteNotBetween(String value1, String value2) {
            addCriterion("end_minute not between", value1, value2, "endMinute");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("`desc` is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("`desc` is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("`desc` =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("`desc` <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("`desc` >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("`desc` >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("`desc` <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("`desc` <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("`desc` like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("`desc` not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(List<String> values) {
            addCriterion("`desc` in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(List<String> values) {
            addCriterion("`desc` not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("`desc` between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("`desc` not between", value1, value2, "desc");
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