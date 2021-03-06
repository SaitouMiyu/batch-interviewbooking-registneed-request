package jp.rhp.model.connection;

import org.apache.ibatis.session.SqlSession;

import jp.rhp.model.connection.company.CompanyDatabase;

public interface DatabaseConnectionRepository
{
    public void connect( CompanyDatabase companyDatabase ) throws Exception;

    public SqlSession sqlSession();
}
