package jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage;

import java.util.ArrayList;
import java.util.List;

public class MailMessageList
{
    private List<MailMessage> mailMessages;

    public MailMessageList( List<MailMessage> mailMessages )
    {
        this.mailMessages = mailMessages;
    }

    public MailMessageList()
    {
        mailMessages = new ArrayList<MailMessage>();
    }

    public List<MailMessage> mailMessages()
    {
        return mailMessages;
    }

    public boolean isEmpty()
    {
        return mailMessages.isEmpty();
    }

    @Deprecated
    public List<MailMessage> getMailMessages()
    {
        return mailMessages;
    }

    @Deprecated
    public void setMailMessages( List<MailMessage> mailMessages )
    {
        this.mailMessages = mailMessages;
    }

    @Override
    public String toString()
    {
        String format = "MailMessageList [mailMessages=%s]";
        return String.format( format, mailMessages );
    }
}
