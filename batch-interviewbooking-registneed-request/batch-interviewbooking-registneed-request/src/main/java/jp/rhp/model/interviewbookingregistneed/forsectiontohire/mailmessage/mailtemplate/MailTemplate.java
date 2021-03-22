package jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage.mailtemplate;

import java.util.Map;

public class MailTemplate
{
    private String from;
    private Contents contents;

    public MailTemplate( String from, String subject, String body )
    {
        this.from = from;
        this.contents = new Contents( subject, body );
    }

    public void implantForMessage( Map<String, String> map )
    {
        this.contents.editMessage( map );
    }

    public String from()
    {
        return this.from;
    }

    public String mailSubject()
    {
        return contents.getSubject();
    }

    public String mailBody()
    {
        return contents.getMessage();
    }

    @Deprecated
    public String getFrom()
    {
        return from;
    }

    @Deprecated
    public Contents getContents()
    {
        return contents;
    }

    @Override
    public String toString()
    {
        return String.format( "MailTemplate [from=%s, contents=%s]", from, contents );
    }
}
