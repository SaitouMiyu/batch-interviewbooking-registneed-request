package jp.rhp.model.interviewbookingregistneed.forsectiontohire.request;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Request
{
    private Timestamp rangeFrom;
    private Timestamp rangeTo;

    public Request( String time )
    {
        createRange( time );
    }

    private void createRange( String time )
    {
        Date date = new Date();
        this.rangeFrom = rangeFrom( date, time );
        this.rangeTo = rangeTo( date, time );
    }

    private Timestamp rangeFrom( Date date, String time )
    {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = new GregorianCalendar( new Locale("ja","JP") );
        calendar.setTime( date );
        calendar.add(Calendar.DATE, -1);
        return Timestamp.valueOf( format.format( calendar.getTime() ) + " " + time );
    }

    private Timestamp rangeTo( Date date, String time )
    {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = new GregorianCalendar( new Locale("ja","JP") );
        calendar.setTime( date );
        return Timestamp.valueOf( format.format( calendar.getTime() ) + " " + time );
    }

}
