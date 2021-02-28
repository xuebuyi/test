package top.xuebuyi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xuebuyi
 * @date 2021-01-24 22:32
 */
public class DateAndStringUtils {
    //日期转换为字符串
    public static String dateToString(Date date, String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String format = simpleDateFormat.format(date);
        return format;
    }
    //字符串转日期
    public static Date stringToDate(String string, String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(string);
        return date;
    }
}
