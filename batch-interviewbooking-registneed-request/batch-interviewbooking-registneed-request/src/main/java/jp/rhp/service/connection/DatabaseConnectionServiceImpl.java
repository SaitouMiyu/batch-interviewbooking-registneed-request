package jp.rhp.service.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.rhp.model.connection.DatabaseConnectionRepository;
import jp.rhp.model.connection.DatabaseConnectionRepositoryForRecop;
import jp.rhp.model.connection.company.CompanyDatabase;
import jp.rhp.model.connection.recop.RecopDatabase;

@Service( "databaseConnectionService" )
public class DatabaseConnectionServiceImpl implements DatabaseConnectionService
{
    @Autowired
    private DatabaseConnectionRepository databaseConnectionRepository;

    @Autowired
    private DatabaseConnectionRepositoryForRecop databaseConnectionRepositoryForRecop;

    @Override
    public void connect( CompanyDatabase database ) throws Exception
    {
        databaseConnectionRepository.connect( database );
    }

    @Override
    public void connect( RecopDatabase database ) throws Exception
    {
        databaseConnectionRepositoryForRecop.connect( database );
    }

}
