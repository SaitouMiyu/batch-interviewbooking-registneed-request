package jp.rhp.service.interviewbookingregistneed.forsectiontohire.mailmessage;

import jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage.MailMessageList;
import jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage.MailMessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service( "registerMailMessageService" )
public class RegisterMailMessageServiceImpl implements RegisterMailMessageService
{
    @Autowired
    private MailMessageRepository mailMessageRepository;

    @Override
    public void register( MailMessageList mails )
    {
        mailMessageRepository.register( mails );
    }
}
