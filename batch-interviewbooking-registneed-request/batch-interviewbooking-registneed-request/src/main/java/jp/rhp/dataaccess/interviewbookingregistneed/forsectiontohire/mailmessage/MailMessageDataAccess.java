package jp.rhp.dataaccess.interviewbookingregistneed.forsectiontohire.mailmessage;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.rhp.model.connection.DatabaseConnectionRepositoryForRecop;
import jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage.MailMessage;
import jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage.MailMessageList;
import jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage.MailMessageRepository;

@Repository( "mailMessageRepository" )
public class MailMessageDataAccess implements MailMessageRepository
{
    @Autowired
    private DatabaseConnectionRepositoryForRecop databaseConnectionRepositoryForRecop;

    public Integer nextId()
    {
        Integer id = sqlSession().selectOne( getClass().getName() + ".nextId" );
        return id;
    }

    public void register( MailMessageList mails )
    {
        for ( MailMessage mail : mails.mailMessages() )
            insertForMail( mail );
    }

    private void insertForMail( MailMessage mail )
    {
        SqlSession sqlSession = sqlSession();
        sqlSession.insert( getClass().getName() + ".registerMailMessage", mail );
        sqlSession.insert( getClass().getName() + ".registerSendMessageRequest", mail );
    }

    private SqlSession sqlSession()
    {
        return databaseConnectionRepositoryForRecop.sqlSession();
    }
}
