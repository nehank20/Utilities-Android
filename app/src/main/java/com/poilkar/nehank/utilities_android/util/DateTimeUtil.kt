package com.poilkar.nehank.utilities_android.util

import android.app.AlertDialog
import android.view.LayoutInflater
import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtil {

    private var SECOND_MILLIS = 1000
    private var MINUTE_MILLIS = 60 * SECOND_MILLIS
    private var HOUR_MILLIS = 60 * MINUTE_MILLIS
    private var DAY_MILLIS = 24 * HOUR_MILLIS

    val hourFormat = SimpleDateFormat("hh:mm a")
    val onleDateFormat = SimpleDateFormat("dd/MM/yy")
    val dateFormat = SimpleDateFormat("hh:mm a dd/MM")

    fun getTimeAgo(newsDate: Long): String {
        SECOND_MILLIS = 1000
        MINUTE_MILLIS = 60 * SECOND_MILLIS
        HOUR_MILLIS = 60 * MINUTE_MILLIS
        DAY_MILLIS = 24 * HOUR_MILLIS

        val now = System.currentTimeMillis()
        val diff = (now - newsDate)

        when {
            diff < MINUTE_MILLIS -> return "Now"
            diff < 2 * MINUTE_MILLIS -> return "Now"
            diff < 60 * MINUTE_MILLIS -> {
                val difference = diff / MINUTE_MILLIS
                return "${difference}m"
            }
            diff < 2 * HOUR_MILLIS -> return "1h"
            diff < 24 * HOUR_MILLIS -> {
                val difference = diff / HOUR_MILLIS
                return "${difference}h"
            }
            diff < 48 * HOUR_MILLIS -> return "Yesterday"
            else -> {
                val elapsedDays = (diff / DAY_MILLIS).toDouble()
                return if (elapsedDays <= 7) {
                    " 1 week ago"
                } else if (elapsedDays <= 15 && elapsedDays > 7) {
                    " 2 weeks ago"
                } else if (elapsedDays <= 22 && elapsedDays > 15) {
                    " 3 weeks ago"
                } else if (elapsedDays <= 29 && elapsedDays > 22) {
                    " 4 weeks ago"
                } else if (elapsedDays > 29 && elapsedDays <= 58) {
                    "1 mth ago"
                } else if (elapsedDays > 58 && elapsedDays <= 87) {
                    "2 mth ago"
                } else if (elapsedDays > 87 && elapsedDays <= 116) {
                    "3 mth ago"
                } else if (elapsedDays > 116 && elapsedDays <= 145) {
                    "4 mth ago"
                } else if (elapsedDays > 145 && elapsedDays <= 174) {
                    "5 mth ago"
                } else if (elapsedDays > 174 && elapsedDays <= 203) {
                    "6 mth ago"
                } else if (elapsedDays > 203 && elapsedDays <= 232) {
                    "7 mth ago"
                } else if (elapsedDays > 232 && elapsedDays <= 261) {
                    "8 mth ago"
                } else if (elapsedDays > 261 && elapsedDays <= 290) {
                    "9 mth ago"
                } else if (elapsedDays > 290 && elapsedDays <= 319) {
                    "10 mth ago"
                } else if (elapsedDays > 319 && elapsedDays <= 348) {
                    "11mth ago"
                } else if (elapsedDays > 348 && elapsedDays <= 360) {
                    "12 mth ago"
                } else if (elapsedDays > 360 && elapsedDays <= 720) {
                    "1 year ago"
                } else if (elapsedDays > 720 && elapsedDays <= 1080) {
                    "1 year ago"
                } else
                    "$elapsedDays days ago"
            }
        }
    }

    fun getTimeAgoV1(timeInMillis:Long):String{
        val calendar = getTodayCalendarReset()
        val paramCal = Calendar.getInstance().apply { setTimeInMillis(timeInMillis) }
        return if (paramCal.time.after(calendar.time)){
            hourFormat.format(paramCal.time)
        }else{
            dateFormat.format(paramCal.time)
        }
    }

    /**
     * returns
     */
    fun getTimeAgoV2(timeInMillis: Long):String{
        val calendar = getTodayCalendarReset()
        val paramCal = Calendar.getInstance().apply { setTimeInMillis(timeInMillis) }
        return if (paramCal.time.after(calendar.time)){
            hourFormat.format(paramCal.time)
        }else{
            onleDateFormat.format(paramCal.time)
        }
    }

    fun getTodayCalendarReset() = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }
}