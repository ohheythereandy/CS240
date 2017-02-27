import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeDate {
    private Calendar calendar;
    private final String startDate = "03012017 09:00";
    private final String endDate = "401"; // feb 1
    private final String closingTime = "19:00"; // 7pm
    private Date date;
    private DateFormat dateFormat;
    private DateFormat intFormat;
    private DateFormat timeFormat;
    private DateFormat halfDateFormat;
    private DateFormat reportFormat;


    public TimeDate() {
        dateFormat = new SimpleDateFormat("MMddyyyy HH:mm");
        halfDateFormat = new SimpleDateFormat("MMddyyyy");
        intFormat = new SimpleDateFormat("Mdd");
        timeFormat = new SimpleDateFormat("HH:mm");
        reportFormat = new SimpleDateFormat("MM-dd-yyyy");
        calendar = Calendar.getInstance();
        try {
            date = dateFormat.parse(startDate);
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void nextHour() {
        calendar.add(Calendar.HOUR,1);
        date = calendar.getTime();
    }

    public void nextDay() {
        calendar.add(Calendar.DATE, 1);
        String resetTime = halfDateFormat.format(calendar.getTime())+" 09:00";
        try {
            date = dateFormat.parse(resetTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public int dateToInt() {
        int intDate = Integer.parseInt((intFormat.format(date)));
        return intDate;
    }

    public boolean isEndOfMarch() {
        return endDate.equals(this.getDate());
    }

    public boolean isOpen() {
        return closingTime.equals(timeFormat.format(date));
    }

    public String getDate() {
        return intFormat.format(date);
    }



    public boolean isRestockTime(){
        return timeFormat.format(date).equals("09:00");

    }

    public String getReportDate() {
        return reportFormat.format(date);
    }
}