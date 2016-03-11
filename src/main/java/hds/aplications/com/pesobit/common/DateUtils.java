package hds.aplications.com.pesobit.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Miguel Gomez Leon on 12/10/15.
 * mgleonsc@gmail.com
 */
public class DateUtils {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-M-dd");

    public static Date generateDayFromString(String dateInString) {
        SimpleDateFormat sdf = DateUtils.DATE_FORMAT;
        Date date = null;
        try {
            date = sdf.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public  static Date beginningDay(Date day){
        Calendar calendarDay = Calendar.getInstance();
        calendarDay.setTime(DateUtils.generateDayFromString("2015-01-01"));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);

        calendarDay.set(Calendar.DATE, calendar.get(Calendar.DATE));
        calendarDay.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        calendarDay.set(Calendar.YEAR, calendar.get(Calendar.YEAR));

        return calendarDay.getTime();
    }
}
