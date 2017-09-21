package com.choliy.igor.retrofitgithub.util;

import android.content.Context;
import android.text.format.DateFormat;
import android.util.Log;
import android.util.TimeUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class DateUtils {

    private static final String DATE_FORMAT = "d MMMM yyyy";
    private static final String TIME_FORMAT_UK = "HH:mm";
    private static final String TIME_FORMAT_US = "h:mm a";
    private static final String FORMAT_DATE_TAKEN = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String INFO_DATE_FORMAT_UK = DATE_FORMAT + " (" + TIME_FORMAT_UK + ")";
    private static final String INFO_DATE_FORMAT_US = DATE_FORMAT + " (" + TIME_FORMAT_US + ")";

    private DateUtils() {
    }

    public static String formatDate(Context context, String dateTaken) {
        Date date;
        String formattedDate;
        try {
            if (DateFormat.is24HourFormat(context)) {
                date = new SimpleDateFormat(FORMAT_DATE_TAKEN, Locale.UK).parse(dateTaken);
                formattedDate = new SimpleDateFormat(INFO_DATE_FORMAT_UK, Locale.UK).format(date);
            } else {
                date = new SimpleDateFormat(FORMAT_DATE_TAKEN, Locale.US).parse(dateTaken);
                formattedDate = new SimpleDateFormat(INFO_DATE_FORMAT_US, Locale.US).format(date);
            }
            return formattedDate;
        } catch (ParseException e) {
            Log.e(TimeUtils.class.getSimpleName(), e.getMessage());
        }
        return null;
    }
}