package jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage;

import jp.rhp.model.interviewbookingregistneed.forjobofferposting.SendSectionToHire;
import jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage.mailtemplate.MailTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component( "mailMessageListFactory" )
public class MailMessageListFactory
{
    @Autowired
    private MailMessageFactory mailMessageFactory;

    public MailMessageList createList( List<SendSectionToHire> sendMailList, MailTemplate mailTemplate )
    {
        List<MailMessage> mailMessages = new ArrayList<MailMessage>();
        for ( SendSectionToHire sectionHire : sendMailList )
        {
            MailTemplate template = new MailTemplate( mailTemplate.from(), mailTemplate.mailSubject(), mailTemplate.mailBody() );
            mailMessages.add( mailMessageFactory.create( sectionHire, template ) );
        }
        return new MailMessageList( mailMessages );
    }
}
