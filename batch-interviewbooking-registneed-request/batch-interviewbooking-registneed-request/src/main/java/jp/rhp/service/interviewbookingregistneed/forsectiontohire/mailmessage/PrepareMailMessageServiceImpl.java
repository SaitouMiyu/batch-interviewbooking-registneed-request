package jp.rhp.service.interviewbookingregistneed.forsectiontohire.mailmessage;

import jp.rhp.model.interviewbookingregistneed.forinterviewbooking.InterviewbookingPosting;
import jp.rhp.model.interviewbookingregistneed.forinterviewbooking.InterviewbookingPostingList;
import jp.rhp.model.interviewbookingregistneed.forinterviewbooking.InterviewbookingPostingRepository;
import jp.rhp.model.interviewbookingregistneed.forjobofferposting.SendJobOfferPostingRepository;
import jp.rhp.model.interviewbookingregistneed.forjobofferposting.SendSectionToHire;
import jp.rhp.model.interviewbookingregistneed.forjobofferposting.SendSectionToHireList;
import jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage.MailMessageList;
import jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage.MailMessageListFactory;
import jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage.mailtemplate.MailTemplate;
import jp.rhp.model.interviewbookingregistneed.setting.InterviewbookingRegistneedFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

@Service( "prepareMailMessageService" )
public class PrepareMailMessageServiceImpl implements PrepareMailMessageService
{
    private Log LOG = LogFactory.getLog( PrepareMailMessageServiceImpl.class );

    @Autowired
    private InterviewbookingRegistneedFactory interviewbookingRegistneedFactory;

    @Autowired
    private SendJobOfferPostingRepository sendJobOfferPostingRepository;

    @Autowired
    private InterviewbookingPostingRepository interviewbookingPostingRepository;

    @Autowired
    private MailMessageListFactory mailMessageListFactory;

    @Override
    public MailMessageList prepare() throws Exception
    {
        SendSectionToHireList sectionHires = sendJobOfferPostingRepository.list();
        if ( sectionHires.isEmpty() )
            return new MailMessageList();

        LOG.debug( "sectionHires ----> " + sectionHires.toString() );

        InterviewbookingPostingList postingList = interviewbookingPostingRepository.listOfInterviewbooking();

        LOG.debug( "postingList ----> " + postingList.toString() );

        postingList.addAll( interviewbookingPostingRepository.listOfFreeInput().list() );

        List<SendSectionToHire> sendMailList = matchSendMail( sectionHires, postingList );

        MailTemplate mailTemplate = interviewbookingRegistneedFactory.createMailTemplate();
        MailMessageList mailMessages = mailMessageListFactory.createList( sendMailList, mailTemplate );
        return mailMessages;
    }

    private List<SendSectionToHire> matchSendMail( SendSectionToHireList sectionHires, InterviewbookingPostingList interviewbookingPostings  )
    {
        List<SendSectionToHire> sendMailSectionToHire = new ArrayList<SendSectionToHire>();
        for ( SendSectionToHire sendSectionToHire : sectionHires.list() )
        {
            InterviewbookingPosting interviewbookingPosting =
                            interviewbookingPostings.InterviewbookingPostingById( sendSectionToHire.sectionToHireId() );
            if ( interviewbookingPosting.isEmpty() )
                continue;
            sendMailSectionToHire.add( sendSectionToHire );
        }
        return sendMailSectionToHire;
    }
}
