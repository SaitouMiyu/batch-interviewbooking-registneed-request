package jp.rhp.service.interviewbookingregistneed.forsectiontohire;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage.MailMessageList;
import jp.rhp.service.interviewbookingregistneed.forsectiontohire.mailmessage.PrepareMailMessageService;
import jp.rhp.service.interviewbookingregistneed.forsectiontohire.mailmessage.RegisterMailMessageService;

@Service( "sendMailService" )
public class SendMailServiceImpl implements SendMailService
{
    private Log LOG = LogFactory.getLog( SendMailServiceImpl.class );

    @Autowired
    private PrepareMailMessageService prepareMailMessageService;

    @Autowired
    private RegisterMailMessageService registerMailMessageService;

    @Override
    public void send()
    {
        try
        {
            MailMessageList messageList = prepareMailMessageService.prepare();
            if ( messageList.isEmpty() )
                return;
            registerMailMessageService.register( messageList );
        }
        catch ( Exception e )
        {
            LOG.error( e );
            e.printStackTrace();
        }
    }
}
