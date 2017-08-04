package learnjava;

import java.text.SimpleDateFormat;

/**
 * Created by harshikesh.kumar on 29/06/17.
 */
public class DateUtilHelper {

    public static void main(String[] args) {
       long time = System.currentTimeMillis();
        System.out.println("current time in ms " + time);
        String isddate = DateUtil.getISTDate(String.valueOf(time));
        System.out.println("isd date " + isddate);
        try {
            String timeformat = DateUtil.getNewFormatDate("yyyy-MM-dd'T'HH:mm:ss+05:30","dd-MMM-yyyy",isddate);
            System.out.println("new format  " + timeformat);
        } catch (Exception e) {
            System.out.println("exception");
        }

        Long epochtime = DateUtil.getEpochTime(String.valueOf(isddate));
        System.out.println("epoch time " + epochtime);

        String isddate2 = DateUtil.getISTDate(String.valueOf(epochtime+(4*60*1000)));
        System.out.println("isd date 2 " + isddate2);

        SimpleDateFormat date24Format = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+05:30'");

        try {
            String timeformat = DateUtil.getNewFormatDate("yyyy-MM-dd'T'HH:mm:ss+05:30","hh:mm:ss a",isddate2);
            System.out.println("new format  " + timeformat);
        } catch (Exception e) {
            System.out.println("exception");
        }


        // System.out.println("isd date " + isddate);




    }
}
