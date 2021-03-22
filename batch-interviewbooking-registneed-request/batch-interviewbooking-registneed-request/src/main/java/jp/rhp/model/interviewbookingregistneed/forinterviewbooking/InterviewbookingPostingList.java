package jp.rhp.model.interviewbookingregistneed.forinterviewbooking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InterviewbookingPostingList implements Serializable
{
    private List<InterviewbookingPosting> interviewbookingPosting;

    public InterviewbookingPostingList()
    {
        this.interviewbookingPosting = new ArrayList<InterviewbookingPosting>();
    }

    public InterviewbookingPostingList( List<InterviewbookingPosting> interviewbookingPosting )
    {
        this.interviewbookingPosting = interviewbookingPosting;
    }

    public InterviewbookingPosting InterviewbookingPostingById( Integer sectionToHireId )
    {
        for ( InterviewbookingPosting interviewbookingPosting : this.list() )
            if ( sectionToHireId.equals( interviewbookingPosting.sectionToHireId() ) )
                return interviewbookingPosting;
        return new InterviewbookingPosting();
    }

    public boolean isEmpty()
    {
        return interviewbookingPosting.isEmpty();
    }

    public void addAll( List<InterviewbookingPosting> list )
    {
    	interviewbookingPosting.addAll( list );
    }

    public List<InterviewbookingPosting> list()
    {
        return interviewbookingPosting;
    }

    @Deprecated
    public List<InterviewbookingPosting> getInterviewbookingPosting()
    {
        return interviewbookingPosting;
    }

    @Deprecated
    public void setInterviewbookingPosting( List<InterviewbookingPosting> interviewbookingPosting )
    {
        this.interviewbookingPosting = interviewbookingPosting;
    }

    @Override
    public String toString()
    {
        return String.format( "InterviewbookingPostingList [interviewbookingPosting=%s]",
                                        interviewbookingPosting );

    }

    private static final long serialVersionUID = -2704984216845897396L;
}
