package com.xiaoju.basetech.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {
    private static String getUpdateTime() {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String updateTime = simpleDateFormat1.format(date);
        System.out.print(date);
        return updateTime;
    }

    public static void main(String[] args) {

//        GetTime.getUpdateTime();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = timestamp;
        System.out.println(timestamp);
        System.out.println(date);
    }
}
