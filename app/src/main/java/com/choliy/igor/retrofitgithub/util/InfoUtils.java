package com.choliy.igor.retrofitgithub.util;

import android.content.Context;
import android.widget.Toast;

import com.choliy.igor.retrofitgithub.R;

import es.dmoral.toasty.Toasty;

public final class InfoUtils {

    private static final int ERROR_403 = 403;
    private static final int ERROR_404 = 404;
    private static final int ERROR_500 = 500;
    private static final int ERROR_503 = 503;
    private static final int ERROR_504 = 504;

    private static Toast sToast;

    private InfoUtils() {
    }

    private static void showErrorToast(Context context, String text) {
        if (sToast != null) sToast.cancel();
        sToast = Toasty.error(context, text, Toast.LENGTH_SHORT, Boolean.TRUE);
        sToast.show();
    }

    public static void showInfoToast(Context context, String text) {
        if (sToast != null) sToast.cancel();
        sToast = Toasty.info(context, text, Toast.LENGTH_SHORT, Boolean.TRUE);
        sToast.show();
    }

    public static void showErrorCode(Context context, int errorCode) {
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
}