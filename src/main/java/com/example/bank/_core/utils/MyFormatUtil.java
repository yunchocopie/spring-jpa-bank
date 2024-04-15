package com.example.bank._core.utils;

import java.text.DecimalFormat;

public class MyFormatUtil {

    public static String moneyFormat(Long value){
        DecimalFormat df = new DecimalFormat("###,###");
        String formatValue = df.format(value);
        return formatValue;
    }
}