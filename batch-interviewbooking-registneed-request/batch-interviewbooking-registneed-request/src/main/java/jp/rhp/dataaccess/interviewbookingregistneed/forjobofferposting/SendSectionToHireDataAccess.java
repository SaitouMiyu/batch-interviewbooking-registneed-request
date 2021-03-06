package jp.rhp.dataaccess.interviewbookingregistneed.forjobofferposting;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.rhp.model.connection.DatabaseConnectionRepositoryForRecop;
import jp.rhp.model.interviewbookingregistneed.forjobofferposting.SendJobOfferPostingRepository;
import jp.rhp.model.interviewbookingregistneed.forjobofferposting.SendSectionToHire;
import jp.rhp.model.interviewbookingregistneed.forjobofferposting.SendSectionToHireList;

@Repository("sendJobOfferPostingRepository")
public class SendSectionToHireDataAccess implements SendJobOfferPostingRepository
{
    @Autowired
    private DatabaseConnectionRepositoryForRecop databaseConnectionRepositoryForRecop;

    @Override
    public SendSectionToHireList list()
    {
      	List<SendSectionToHire> sectionHires = sqlSession().selectList( getClass().getName() + ".listOfJobOfferPosting" );
        return new SendSectionToHireList( sectionHires );
    }

    private SqlSession sqlSession()
    {
        SqlSession sqlSession = databaseConnectionRepositoryForRecop.sqlSession();
        return sqlSession;
    }
}
