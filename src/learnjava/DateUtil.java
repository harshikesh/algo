package learnjava;

import java.text.DecimalFormat;
/**
 * Created by praneeth.lakmala on 8/17/16.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;


public class DateUtil {


    /*
    public String getTimeDiffInMinutes(String time) {
        if(StringUtils.isEmpty(time)){
            return time;
        }
        Integer hour = Integer.parseInt(time.split(":")[0]);
        Integer min = Integer.parseInt(time.split(":")[1]);

        Calendar cal= Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,hour);
        cal.set(Calendar.MINUTE, min);

        cal.add(Calendar.MINUTE, -1 * 15);
        return cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE);
    }
    */


    public static String getTimeInAMPM(String time) {
        try {
            SimpleDateFormat date12Format = new SimpleDateFormat("hh:mm a");

            SimpleDateFormat date24Format = new SimpleDateFormat("HH:mm");

            return  date12Format.format(date24Format.parse(time));
        } catch (ParseException excep) {
            return time;
        }
    }

    public static String getAmPmTime(String timestamp){

        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone("IST"));

        String formattedDate = null;

        try {
            Long timestampLong = Long.parseLong(timestamp);
            formattedDate = formatter.format(timestampLong);
        } catch (Exception e) {
            try {
                Date now = new Date();
                formattedDate = formatter.format(now);
            } catch (Exception e1) {
            }
        }

        return formattedDate;
    }

    public static String getAmPmDate(String timestamp){

        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, hh:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone("IST"));

        String formattedDate = null;

        try {
            Long timestampLong = Long.parseLong(timestamp);
            formattedDate = formatter.format(timestampLong);
        } catch (Exception e) {
            try {
                Date now = new Date();
                formattedDate = formatter.format(now);
            } catch (Exception e1) {
            }
        }

        if (LOGGER.isInfoEnabled()) { LOGGER.info("IST datetime => " + formattedDate); }
        return formattedDate;
    }

    public static String getNewFormatDate(String oldFormat,String newFormat,String time) throws Exception {
        if(time == null)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(oldFormat);
        String newTripStartTime = "";
        try {
            Date start = sdf.parse(time);
            sdf.applyPattern(newFormat);
            newTripStartTime = sdf.format(start);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newTripStartTime;
    }

    public static String getISTDate(String timestamp) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
        formatter.setTimeZone(TimeZone.getTimeZone("IST"));

        String formattedDate = null;

        try {
            Long timestampLong = Long.parseLong(timestamp);
            formattedDate = formatter.format(timestampLong);
        } catch (Exception e) {
            LOGGER.error("Error in getting the datetime from timestamp");
            try {
                Date now = new Date();
                formattedDate = formatter.format(now);
            } catch (Exception e1) {
                LOGGER.error("Error in getting the datetime from current time");
            }
        }

        LOGGER.info("IST datetime => " + formattedDate);
        return formattedDate;
    }


    public static String getISTDateToMillisecond(String timestamp) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
        formatter.setTimeZone(TimeZone.getTimeZone("IST"));

        String formattedDate = null;

        try {
            Date date = formatter.parse(timestamp);
            TimeUnit.MINUTES.toMillis(date.getMinutes());
        } catch (Exception e) {
            LOGGER.error("Error in getting the datetime from timestamp");
            try {
                Date now = new Date();
                formattedDate = formatter.format(now);
            } catch (Exception e1) {
                LOGGER.error("Error in getting the datetime from current time");
            }
        }

        LOGGER.info("IST datetime => " + formattedDate);
        return formattedDate;
    }



    public static Long getTimeInMilliseconds() {
        Date date = new Date();

        return date.getTime();
    }


    public static String getTimeDiffInMinutes(String time, int difference) {
        Integer hour = Integer.parseInt(time.split(":")[0]);
        Integer min = Integer.parseInt(time.split(":")[1]);

        Calendar cal= Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,hour);
        cal.set(Calendar.MINUTE, min);

        cal.add(Calendar.MINUTE, -1 * difference);
        DecimalFormat mFormat= new DecimalFormat("00");
        return mFormat.format(Integer.valueOf(cal.get(Calendar.HOUR_OF_DAY)))+":" + mFormat.format(Integer.valueOf(cal.get(Calendar.MINUTE)));
    }

    public static String normalizeTime(String inTime) {
        String hour = inTime.split(":")[0];
        String min = inTime.split(":")[1];
        if ( hour.length() == 1)
            hour = "0" + hour;
        if (min.length() == 1)
            min = "0" + min;

        return hour + ":" + min;

    }

    public static String getCurrentTime() {
        // Get current time
        Date date = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(date);

        return currentTime;
    }

    public static Integer getTimeDiffFromNow(String datetime) {
        try {
            // Get the datetime object
            Date datetimeObj = getDateObject(datetime);

            // Get current datetime
            Date curDatetime = getCurrentDatetime();

            long diff = curDatetime.getTime() - datetimeObj.getTime();
            long diffseconds = diff / 1000;

            return (int) diffseconds;
        } catch (Exception e) {
        }

        return 0;
    }

    public static Date getDateObject(String datetime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date dateObj = null;
        try {
            dateObj = dateFormat.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateObj;
    }

    public static Date getCurrentDatetime() {
        // Get current time
        Date date = new Date();

        return date;
    }

    public static Long getEpochTimeSpaceFormat(String timestamp) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Long epoch = 0L;

        try {
            Date date = formatter.parse(timestamp);
            epoch = date.getTime();
        } catch (Exception e) {
        }

        return epoch;
    }


    public static Long getEpochTime(String timestamp) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+05:30'");

        Long epoch = 0L;

        try {
            Date date = formatter.parse(timestamp);
            epoch = date.getTime();
        } catch (Exception e) {
        }

        return epoch;
    }

    public static String getDayAmPmDate(String timestamp, boolean sendTextForDate){

        SimpleDateFormat formatter1 = new SimpleDateFormat("EEE, MMM d, hh:mm a");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
        SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatter4 = new SimpleDateFormat("hh:mm a");
        formatter1.setTimeZone(TimeZone.getTimeZone("IST"));

        String formattedDate = null;

        Long epoch = 0L;
        try {
            Date date = formatter2.parse(timestamp);
            Date now = new Date();

            Date prevDate = formatter3.parse(formatter3.format(now.getTime() - 1000 * 60 * 60 * 24));

            Long timestampLong = date.getTime();
            formattedDate = formatter1.format(timestampLong);

            if (sendTextForDate && now.getDate() == date.getDate()) {
                formattedDate = "Today, " + formatter4.format(date.getTime());
            } else if (sendTextForDate && prevDate.getDate() == date.getDate()) {
                formattedDate = "Yesterday, " + formatter4.format(date.getTime());;
            }
        } catch (Exception e) {
            try {
                Date now = new Date();
                formattedDate = formatter1.format(now);
            } catch (Exception e1) {
            }
        }

        return formattedDate;
    }
}
