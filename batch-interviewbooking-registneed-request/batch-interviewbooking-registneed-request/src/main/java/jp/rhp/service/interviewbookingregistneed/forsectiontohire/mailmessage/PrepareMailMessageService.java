package jp.rhp.service.interviewbookingregistneed.forsectiontohire.mailmessage;

import jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage.MailMessageList;

public interface PrepareMailMessageService
{
    public MailMessageList prepare() throws Exception;
}
