package jp.rhp.dataaccess.interviewbookingregistneed.forinterviewbooking;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.rhp.model.connection.DatabaseConnectionRepositoryForRecop;
import jp.rhp.model.interviewbookingregistneed.forinterviewbooking.InterviewbookingPosting;
import jp.rhp.model.interviewbookingregistneed.forinterviewbooking.InterviewbookingPostingList;
import jp.rhp.model.interviewbookingregistneed.forinterviewbooking.InterviewbookingPostingRepository;

@Repository("interviewbookingPostingRepository")
public class InterviewbookingDataAccess implements InterviewbookingPostingRepository
{
    @Autowired
    private DatabaseConnectionRepositoryForRecop databaseConnectionRepositoryForRecop;

    @Override
    public InterviewbookingPostingList listOfInterviewbooking()
    {
        List<InterviewbookingPosting> list = sqlSession().selectList( getClass().getName() + ".listOfInterviewbookingPosting" );
        return new InterviewbookingPostingList( list );
    }

    @Override
    public InterviewbookingPostingList listOfFreeInput()
    {
        List<InterviewbookingPosting> list = sqlSession().selectList( getClass().getName() + ".listOfFreeinputPosting" );
        return new InterviewbookingPostingList( list );
    }

    private SqlSession sqlSession()
    {
        SqlSession sqlSession = databaseConnectionRepositoryForRecop.sqlSession();
        return sqlSession;
    }
}
