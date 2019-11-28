package com.jzhl.yunjia.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间方法
 */
public class DateUtils {

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(Integer timeStamp){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这个是你要转成后的时间的格式
        String sd = sdf.format(new Date(timeStamp));   // 时间戳转换成时间
        return sd;
    }

    /**
     * 获取当前时间 按照指定格式
     */
    public static String noeDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());
    }

    /**
     * 判断二维码时间是否过期
     * @param date 二维码生成时间
     * @param hour 二维码时长
     * @return
     */
    public static Boolean isExpire(Date date,int hour){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);// 24小时制
        date = cal.getTime();

        if(new Date().getTime() > date.getTime()) {
            return false;
        }else{
            return true;
        }

    }

    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime 当前时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     * @author jqlin
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 计算两个时间相差的秒数
     * @param startDate
     * @return
     */
    public static int calLastedTime(Date startDate) {
        long a = new Date().getTime();
        long b = startDate.getTime();
        int c = (int)((a - b) / 1000);
        return c;
    }

    /**
     * 时间戳转Unix时间戳
     * @param timestamp
     * @return
     */
    public static long toUnixTimeStamp(long timestamp){
        return timestamp/1000;
    }

    /**
     * Unix时间戳转时间戳
     * @param unixTimeStamp
     * @return
     */
    public static long toTimestamp(long unixTimeStamp){
        return unixTimeStamp*1000;
    }


    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.HOUR));
        System.out.println(year);
    }

}
