package com.gap.atpractice.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ssibaja on 6/20/17.
 */
public class Utils {

    public String getCurrentDateTime(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        return dateFormat.format(date).toString();
    }

    public String getCurrentDateTimeUnderscore(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Date date = new Date();

        return dateFormat.format(date).toString();
    }

    public String getCurrentDate(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        return dateFormat.format(date).toString();
    }


}
