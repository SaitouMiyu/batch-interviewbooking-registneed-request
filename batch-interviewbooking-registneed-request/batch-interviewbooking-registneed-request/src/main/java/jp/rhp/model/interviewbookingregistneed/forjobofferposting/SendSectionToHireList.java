package jp.rhp.model.interviewbookingregistneed.forjobofferposting;

import java.util.ArrayList;
import java.util.List;

public class SendSectionToHireList
{
    private List<SendSectionToHire> sendSectionHireList;

    public SendSectionToHireList()
    {
        this.sendSectionHireList = new ArrayList<SendSectionToHire>();
    }

    public SendSectionToHireList( List<SendSectionToHire> sendSectionHireList )
    {
        this.sendSectionHireList = sendSectionHireList;
    }

    public SendSectionToHire sendSectionToHireById( Integer sectionToHireId )
    {
        for ( SendSectionToHire sendSectionToHire : this.sendSectionHireList )
            if ( sectionToHireId.equals( sendSectionToHire.getSectionToHire().id() ) )
                return sendSectionToHire;
        return new SendSectionToHire();
    }

    public boolean isEmpty()
    {
        return sendSectionHireList.isEmpty();
    }

    public List<SendSectionToHire> list()
    {
        return sendSectionHireList;
    }

    public List<SendSectionToHire> sendSectionHires()
    {
        return sendSectionHireList;
    }

    @Deprecated
    public List<SendSectionToHire> getSendSectionHireList()
    {
        return sendSectionHireList;
    }

    @Deprecated
    public void setSendSectionHireList( List<SendSectionToHire> sendSectionHireList )
    {
        this.sendSectionHireList = sendSectionHireList;
    }

    @Override
    public String toString()
    {
        return String.format( "SendSectionToHireList [sendSectionHireList=%s]",
                                        sendSectionHireList );
    }
}
