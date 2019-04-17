package com.yuantu.faceUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date
 * Created by brj on 2017/9/4.
 */
public class DateStringUtils {

    public static String DateToString(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str=sdf.format(date);
        return str;
    }

    public static String DateToString2(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String str=sdf.format(date);
        return str;
    }

    public static Date StringToDate(String dateStr){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date= null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String compareDate(Date operteDate,String departTime){
        String flag=null;
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(operteDate);
        calendar.add(Calendar.HOUR_OF_DAY,Integer.parseInt(departTime));
        Date youxiaoDate=calendar.getTime();
        Date currentDate=new Date();
        if (youxiaoDate.getTime() >= currentDate.getTime()) {
            flag="1";
        } else if (youxiaoDate.getTime() < currentDate.getTime()) {
            flag="2";
        }
        return flag;
    }
}
