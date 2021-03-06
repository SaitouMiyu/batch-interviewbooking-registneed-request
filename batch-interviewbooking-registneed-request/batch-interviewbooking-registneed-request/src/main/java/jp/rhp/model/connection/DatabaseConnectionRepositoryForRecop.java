package jp.rhp.model.connection;

import org.apache.ibatis.session.SqlSession;

import jp.rhp.model.connection.recop.RecopDatabase;

public interface DatabaseConnectionRepositoryForRecop
{
    public void connect( RecopDatabase RecopDatabase ) throws Exception;

    public SqlSession sqlSession();
}
