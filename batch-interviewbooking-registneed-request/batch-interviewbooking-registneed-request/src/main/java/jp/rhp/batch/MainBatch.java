package jp.rhp.batch;

import jp.rhp.batch.process.BatchProcess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MainBatch
{
    private static Log LOG = LogFactory.getLog( MainBatch.class );

    private static final String APPLICATION_CONTEXT_PATH = "META-INF/spring/beans-all.xml";

    protected static final ApplicationContext context = new ClassPathXmlApplicationContext( APPLICATION_CONTEXT_PATH );

    protected static final int SUCCESS = 0;
    protected static final int SYSTEM_ERROR = 1;

    public static void main( String[] args )
    {
        try
        {
            LOG.info( "process start." );
            doMainProcess( args );
            LOG.info( "process end." );

            System.exit( SUCCESS );
        }
        catch ( Exception e )
        {
            LOG.error( "process abnormal end.", e );
            System.exit( SYSTEM_ERROR );
        }
    }

    private static void doMainProcess( String[] args ) throws Exception
    {
        ( (BatchProcess) context.getBean( "batchProcess" ) ).doMainProcess( args );
    }
}
