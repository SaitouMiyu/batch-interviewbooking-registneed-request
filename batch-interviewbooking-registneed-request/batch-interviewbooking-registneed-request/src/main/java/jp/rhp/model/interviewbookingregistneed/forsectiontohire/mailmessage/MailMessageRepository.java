package jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage;

public interface MailMessageRepository
{
    public Integer nextId();

    public void register( MailMessageList mails );
}
