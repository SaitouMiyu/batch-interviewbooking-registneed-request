package jp.rhp.model.interviewbookingregistneed.setting;

import org.springframework.stereotype.Component;

import jp.rhp.model.connection.company.CompanyDatabase;
import jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage.mailtemplate.MailTemplate;

@Component( "interviewbookingRegistneedFactory" )
public class InterviewbookingRegistneedFactory
{
    private String address;

    private String name;

    private String port;

    private String userid;

    private String password;

//    private String starttime;

    private String from;

    private String subject;

    private String body;

    public CompanyDatabase createDatabase()
    {
       return new CompanyDatabase( address, port, name, userid, password );
    }

    public MailTemplate createMailTemplate()
    {
        return new MailTemplate( from, subject, body );
    }

//    public String starttime()
//    {
//        return this.starttime;
//    }

    @Deprecated
    public String getAddress()
    {
        return address;
    }

    @Deprecated
    public void setAddress( String address )
    {
        this.address = address;
    }

    @Deprecated
    public String getName()
    {
        return name;
    }

    @Deprecated
    public void setName( String name )
    {
        this.name = name;
    }

    @Deprecated
    public String getPort()
    {
        return port;
    }

    @Deprecated
    public void setPort( String port )
    {
        this.port = port;
    }

    @Deprecated
    public String getUserid()
    {
        return userid;
    }

    @Deprecated
    public void setUserid( String userid )
    {
        this.userid = userid;
    }

    @Deprecated
    public String getPassword()
    {
        return password;
    }

    @Deprecated
    public void setPassword( String password )
    {
        this.password = password;
    }

//    @Deprecated
//    public String getStarttime()
//    {
//        return starttime;
//    }

//    @Deprecated
//    public void setStarttime( String starttime )
//    {
//        this.starttime = starttime;
//    }

    @Deprecated
    public String getFrom()
    {
        return from;
    }

    @Deprecated
    public void setFrom( String from )
    {
        this.from = from;
    }

    @Deprecated
    public String getSubject()
    {
        return subject;
    }

    @Deprecated
    public void setSubject( String subject )
    {
        this.subject = subject;
    }

    @Deprecated
    public String getBody()
    {
        return body;
    }

    @Deprecated
    public void setBody( String body )
    {
        this.body = body;
    }


}