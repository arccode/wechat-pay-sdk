package net.arccode.wechat.pay.api.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 描述: 日期工具类
 *
 * @author http://arccode.net
 * @since 2015-05-25
 */
public class DateUtils {

    /**
     * 日期类型转字符串
     * @param dateFormat  格式化格式, eg: yyyy-MM-dd, yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String convertDate2String(String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String dateStr = sdf.format(getNow());
        return dateStr.trim();
    }

    /**
     * 日期类型转字符串
     * @param date java.util.Date
     * @param dateFormat  格式化格式, eg: yyyy-MM-dd, yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String convertDate2String(Date date, String dateFormat) {

        if(null == date) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String dateStr = sdf.format(date);
        return dateStr.trim();
    }

    /**
     * 日期类型转字符串, 带时区转换
     * @param dateFormat  格式化格式, eg: yyyy-MM-dd, yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String convertDate2String(Date sourceDate, String dateFormat, TimeZone sourceTimeZone,
                                            TimeZone targetTimeZone) {

        if(null == sourceDate) {
            return "";
        }

        Long targetTime = sourceDate.getTime() - sourceTimeZone.getRawOffset() + targetTimeZone.getRawOffset();
        return convertDate2String(new Date(targetTime), dateFormat);
    }

    /**
     * 时区转换
     *
     * @param sourceDate
     * @param sourceTimeZone
     * @param targetTimeZone
     * @return
     */
    public static Date convertTimeZone(Date sourceDate, TimeZone sourceTimeZone, TimeZone targetTimeZone) {

        if(null == sourceDate) {
            return null;
        }

        Long targetTime = sourceDate.getTime() - sourceTimeZone.getRawOffset() + targetTimeZone.getRawOffset();
        return new Date(targetTime);
    }

    /**
     * 字符串转日期类型
     * @param dateStr
     * @param dateFormat
     * @return
     */
    public static Date convertString2Date(String dateStr, String dateFormat) throws ParseException {
        if(null == dateStr || "".equals(dateStr.trim())) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date result = sdf.parse(dateStr);

        return result;
    }

    /**
     * 获取指定的date, 参看calendar api
     * @param field
     * @param amount
     * @return
     */
    public static Date getDefineTime(int field, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * 获取指定日期的起始值, e.g: 2014-11-11 10:11:22 -> 2014-11-11 00:00:00
     * @param date
     * @return
     */
    public static Date getDateStartByDate(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    /**
     * 获取指定日期的结束值, e.g: 2014-11-11 10:11:22 -> 2014-11-11 23:59:59
     * @param date
     * @return
     */
    public static Date getDateEndByDate(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        return calendar.getTime();
    }

    /**
     * 返回当前日期
     * @return
     */
    public static Date getNow() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

}
