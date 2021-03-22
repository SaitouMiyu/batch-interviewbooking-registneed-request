package jp.rhp.model.interviewbookingregistneed.forinterviewbooking;

import jp.rhp.model.primitive.Identifiable;

import java.io.Serializable;

public class InterviewbookingPosting implements Identifiable, Serializable
{
    private Integer sectionToHireId;

    public InterviewbookingPosting()
    {
        this.sectionToHireId = ID_EMPTY;
    }

    public Integer sectionToHireId()
    {
        return sectionToHireId;
    }

    public boolean isEmpty()
    {
        return ID_EMPTY.equals( this.sectionToHireId ) ? true : false;
    }

    @Deprecated
    public Integer getSectionToHireId()
    {
        return sectionToHireId;
    }

    @Deprecated
    public void setSectionToHireId( Integer sectionToHireId )
    {
        this.sectionToHireId = sectionToHireId;
    }

    @Override
    public String toString()
    {
        return String.format( "InterviewbookingPosting [sectionToHireId=%s]",
                                        sectionToHireId );
    }

    private static final long serialVersionUID = -8521860704111908548L;
}
