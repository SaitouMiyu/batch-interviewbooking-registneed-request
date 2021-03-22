package jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage;

import jp.rhp.model.interviewbookingregistneed.forjobofferposting.SendSectionToHire;
import jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage.mailtemplate.MailTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component( "mailMessageFactory" )
public class MailMessageFactory
{
    @Autowired
    private MailMessageRepository mailMessageRepository;

    public MailMessage create( SendSectionToHire sectionHire, MailTemplate mailTemplate )
    {
        Integer id = mailMessageRepository.nextId();
        String toMailAddress = sectionHire.mailAddress();
        String shopName = sectionHire.shopName();
        return new MailMessage( id, toMailAddress, shopName, mailTemplate );
    }
}
