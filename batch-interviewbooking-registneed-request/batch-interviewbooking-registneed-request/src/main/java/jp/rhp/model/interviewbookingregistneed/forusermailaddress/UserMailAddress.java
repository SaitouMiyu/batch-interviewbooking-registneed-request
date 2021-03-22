package jp.rhp.model.interviewbookingregistneed.forusermailaddress;

import jp.rhp.model.primitive.Identifiable;

import java.io.Serializable;

public class UserMailAddress implements Identifiable, Serializable
{
    private Integer userId;

    private String mailaddress;

    public UserMailAddress()
    {
        this.userId = ID_EMPTY;
        this.mailaddress = "";
    }

    @Deprecated
    public Integer getUserId()
    {
        return userId;
    }

    @Deprecated
    public String getMailaddress()
    {
        return mailaddress;
    }

    @Deprecated
    public void setUserId( Integer userId )
    {
        this.userId = userId;
    }

    @Deprecated
    public void setMailaddress( String mailaddress )
    {
        this.mailaddress = mailaddress;
    }

    @Override
    public String toString()
    {
        return String.format( "UserMailAddress [userId=%s, mailaddress=%s]", userId, mailaddress );
    }

    private static final long serialVersionUID = 3043802855760681231L;
}
