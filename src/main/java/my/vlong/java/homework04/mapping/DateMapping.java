package my.vlong.java.homework04.mapping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMapping {

    private static final String PATTERN = "yyyy-MM-dd";
    private DateFormat dateFormat;

    public DateMapping() {
        dateFormat = new SimpleDateFormat(PATTERN);
    }

    public Date toDate(String dateString) throws ParseException {
        Date date = null;
        if (dateString != null && !dateString.isEmpty()) {
            date = dateFormat.parse(dateString);
        }
        return date;
    }

    public String toDateString(Date date) {
        String dateString = "";
        if (date != null) {
            dateString = dateFormat.format(date);
        }

        return dateString;
    }

}
