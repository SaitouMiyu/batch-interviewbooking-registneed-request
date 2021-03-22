package jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage.mailtemplate;

import java.util.Iterator;
import java.util.Map;

public class Contents
{
    private String subject;
    private String message;

    public Contents( String subject, String message )
    {
        this.subject = subject;
        this.message = message;
    }

    public void editMessage( Map<String, String> map )
    {
        for ( Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); )
        {
            Map.Entry entry = (Map.Entry)iterator.next();
            String change = this.message;
            this.message = change.replace( "%" + entry.getKey().toString() + "%", entry.getValue().toString() );
        }
    }

    @Deprecated
    public String getSubject()
    {
        return subject;
    }

    @Deprecated
    public String getMessage()
    {
        return message;
    }

    @Override
    public String toString()
    {
        return String.format( "Contents [subject=%s, message=%s]", subject, message );
    }
}
