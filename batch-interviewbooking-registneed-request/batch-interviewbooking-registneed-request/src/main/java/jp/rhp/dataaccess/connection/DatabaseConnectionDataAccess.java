package jp.rhp.dataaccess.connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;

import jp.rhp.model.connection.DatabaseConnectionRepository;
import jp.rhp.model.connection.company.CompanyDatabase;

@Repository( "databaseConnectionRepository" )
public class DatabaseConnectionDataAccess implements DatabaseConnectionRepository
{
    @Autowired
    private SqlSessionFactoryBean sqlSessionFactoryBean;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    private static SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void connect( CompanyDatabase companyDatabase ) throws Exception
    {
        DataSource dataSource = companyDatabase.dataSource();
        sqlSessionFactoryBean.setDataSource( dataSource );
        sqlSessionFactoryBean.afterPropertiesSet();

        sqlSessionTemplate = new SqlSessionTemplate( sqlSessionFactoryBean.getObject() );
        dataSourceTransactionManager.setDataSource( dataSource );
        dataSourceTransactionManager.afterPropertiesSet();
    }

    @Override
    public SqlSession sqlSession()
    {
        return sqlSessionTemplate;
    }
}
