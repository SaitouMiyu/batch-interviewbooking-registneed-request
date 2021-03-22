package jp.rhp.batch.process;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.rhp.model.connection.company.CompanyDatabase;
import jp.rhp.model.connection.recop.RecopDatabase;
import jp.rhp.model.interviewbookingregistneed.setting.InterviewbookingRegistneedFactory;
import jp.rhp.model.interviewbookingregistneed.setting.InterviewbookingRegistneedFactoryForRecop;
import jp.rhp.service.connection.DatabaseConnectionService;
import jp.rhp.service.interviewbookingregistneed.forsectiontohire.SendMailService;

@Component( "batchProcess" )
public class BatchProcessImpl implements BatchProcess
{
    private Log LOG = LogFactory.getLog( BatchProcessImpl.class );

    @Autowired
    private InterviewbookingRegistneedFactory interviewbookingRegistneedFactory;

    @Autowired
    private InterviewbookingRegistneedFactoryForRecop interviewbookingRegistneedFactoryForRecop;

    @Autowired
    private SendMailService sendMailService;

    @Autowired
    private DatabaseConnectionService databaseConnectionService;

    @Override
    public void doMainProcess( String[] args ) throws Exception
    {

       CompanyDatabase database = interviewbookingRegistneedFactory.createDatabase();
       RecopDatabase  recopDatabase = interviewbookingRegistneedFactoryForRecop.createDatabase();
        sendMail( database, recopDatabase );
    }

    private void sendMail( CompanyDatabase database, RecopDatabase recopDatabase )
    {
        try
        {
        	// publicDB接続処理
        	databaseConnectionService.connect( database );

        	// recopDB接続処理
        	databaseConnectionService.connect( recopDatabase );

            LOG.info( String.format( "interviewbooking need remind mail -- start" ) );
            sendMailService.send();
            LOG.info( String.format( "interviewbooking need remind mail -- end" ) );
        }
        catch ( Exception e )
        {
            LOG.error( String.format( "interviewbooking need remind mail -- abnormal error" ), e );
        }
    }
}
