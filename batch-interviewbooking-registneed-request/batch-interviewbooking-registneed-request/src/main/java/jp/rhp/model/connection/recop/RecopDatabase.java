package jp.rhp.model.connection.recop;

import java.io.Serializable;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import jp.rhp.model.primitive.Identifiable;

public class RecopDatabase implements Identifiable, Serializable
{
    private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
    private static final String DATABASE_URL_FORMAT = "jdbc:postgresql://%s:%s/%s";

    private Integer companyId;

    private String name;

    private String address;

    private String port;

    private String userId;

    private String password;

    public RecopDatabase()
    {
        this.companyId = -1;
        this.name = "";
        this.address = "";
        this.port = "";
        this.userId = "";
        this.password = "";
    }

    public RecopDatabase( String address, String port, String name, String userId, String password )
    {
        this.companyId = -1;
        this.name = name;
        this.address = address;
        this.port = port;
        this.userId = userId;
        this.password = password;
    }

    public DataSource dataSource()
    {
        BasicDataSource companyDataSource = new BasicDataSource();
        companyDataSource.setDriverClassName( DRIVER_CLASS_NAME );
        companyDataSource.setUrl( String.format( DATABASE_URL_FORMAT, address, port, name ) );
        companyDataSource.setUsername( userId );
        companyDataSource.setPassword( password );
        return companyDataSource;
    }

    public Integer companyId()
    {
        return companyId;
    }

    public String name()
    {
        return name;
    }

    public String address()
    {
        return address;
    }

    public String port()
    {
        return port;
    }

    public String userId()
    {
        return userId;
    }

    public String password()
    {
        return password;
    }

    @Deprecated
    public Integer getCompanyId()
    {
        return companyId;
    }

    @Deprecated
    public String getName()
    {
        return name;
    }

    @Deprecated
    public String getAddress()
    {
        return address;
    }

    @Deprecated
    public String getPort()
    {
        return port;
    }

    @Deprecated
    public String getUserId()
    {
        return userId;
    }

    @Deprecated
    public String getPassword()
    {
        return password;
    }

    @Deprecated
    public void setCompanyId( Integer companyId )
    {
        this.companyId = companyId;
    }

    @Deprecated
    public void setName( String name )
    {
        this.name = name;
    }

    @Deprecated
    public void setAddress( String address )
    {
        this.address = address;
    }

    @Deprecated
    public void setPort( String port )
    {
        this.port = port;
    }

    @Deprecated
    public void setUserId( String userId )
    {
        this.userId = userId;
    }

    @Deprecated
    public void setPassword( String password )
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        String format = "CompanyDatabase [companyId=%s, name=%s, address=%s, port=%s, userId=%s, password=%s]";
        return String.format( format, companyId, name, address, port, userId, password );
    }

    private static final long serialVersionUID = -3899167254105103837L;
}
