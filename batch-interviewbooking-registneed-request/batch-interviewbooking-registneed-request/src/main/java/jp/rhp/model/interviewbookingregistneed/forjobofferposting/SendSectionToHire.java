package jp.rhp.model.interviewbookingregistneed.forjobofferposting;

import jp.rhp.model.interviewbookingregistneed.forusermailaddress.UserMailAddress;
import jp.rhp.model.primitive.Identifiable;

import java.io.Serializable;

public class SendSectionToHire implements Serializable
{
    private SectionToHire sectionToHire;

    private UserMailAddress userMailAddress;

    public SendSectionToHire()
    {
        this.sectionToHire = new SectionToHire();
        this.userMailAddress = new UserMailAddress();
    }

    public boolean isSectionToHireEmpty()
    {
        if ( Identifiable.ID_EMPTY.equals( sectionToHire.id() ) )
            return true;
        return false;
    }

    public Integer sectionToHireId()
    {
        return sectionToHire.id();
    }

    public String mailAddress()
    {
        return userMailAddress.getMailaddress();
    }

    public String shopName()
    {
        return sectionToHire.shopName();
    }

    @Deprecated
    public SectionToHire getSectionToHire()
    {
        return sectionToHire;
    }

    @Deprecated
    public UserMailAddress getUserMailAddress()
    {
        return userMailAddress;
    }

    @Deprecated
    public void setSectionToHire( SectionToHire sectionToHire )
    {
        this.sectionToHire = sectionToHire;
    }

    @Deprecated
    public void setUserMailAddress( UserMailAddress userMailAddress )
    {
        this.userMailAddress = userMailAddress;
    }

    @Override
    public String toString()
    {
        return String.format( "SendSectionToHire [sectionToHire=%s, userMailAddress=%s]",
                                        sectionToHire, userMailAddress );
    }

    private static final long serialVersionUID = 4390830885349094943L;
}
