package jp.rhp.service.connection;

import jp.rhp.model.connection.company.CompanyDatabase;
import jp.rhp.model.connection.recop.RecopDatabase;

public interface DatabaseConnectionService
{
    public void connect( CompanyDatabase database ) throws Exception;

    public void connect( RecopDatabase database ) throws Exception;

}
