package com.choliy.igor.retrofitgithub.util;

import android.content.Context;
import android.text.format.DateFormat;
import android.util.Log;
import android.util.TimeUtils;
import android.widget.Toast;

import com.choliy.igor.retrofitgithub.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import es.dmoral.toasty.Toasty;

public final class Utils {

    private static final int ERROR_403 = 403;
    private static final int ERROR_404 = 404;
    private static final int ERROR_500 = 500;
    private static final int ERROR_503 = 503;
    private static final int ERROR_504 = 504;

    private static final String DATE_FORMAT = "d MMMM yyyy";
    private static final String TIME_FORMAT_UK = "HH:mm";
    private static final String TIME_FORMAT_US = "h:mm a";
    private static final String FORMAT_DATE_TAKEN = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String INFO_DATE_FORMAT_UK = DATE_FORMAT + " (" + TIME_FORMAT_UK + ")";
    private static final String INFO_DATE_FORMAT_US = DATE_FORMAT + " (" + TIME_FORMAT_US + ")";

    private Utils() {
    }

    private static void showErrorToast(Context context, String text) {
        Toasty.error(context, text, Toast.LENGTH_SHORT, Boolean.TRUE).show();
    }

    public static void showInfoToast(Context context, String text) {
        Toasty.info(context, text, Toast.LENGTH_SHORT, Boolean.TRUE).show();
    }

    public static void checkErrorCode(Context context, int errorCode) {
        switch (errorCode) {
            case ERROR_403:
                showErrorToast(context, context.getString(R.string.error_403));
                break;
            case ERROR_404:
                showErrorToast(context, context.getString(R.string.error_404));
                break;
            case ERROR_500:
                showErrorToast(context, context.getString(R.string.error_500));
                break;
            case ERROR_503:
                showErrorToast(context, context.getString(R.string.error_503));
                break;
            case ERROR_504:
                showErrorToast(context, context.getString(R.string.error_504));
                break;
        }
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