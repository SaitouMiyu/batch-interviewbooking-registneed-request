package jp.rhp.model.interviewbookingregistneed.forjobofferposting;

import jp.rhp.model.primitive.Identifiable;

import java.io.Serializable;

public class SectionToHire implements Identifiable, Serializable
{
    private Integer id;

    private String name;

    public SectionToHire()
    {
        this.id = ID_EMPTY;
        this.name = "";
    }

    public Integer id()
    {
        return this.id;
    }

    public String shopName()
    {
        return this.name;
    }

    @Deprecated
    public Integer getId()
    {
        return id;
    }

    @Deprecated
    public String getName()
    {
        return name;
    }

    @Deprecated
    public void sevtId( Integer id )
    {
        this.id = id;
    }

    @Deprecated
    public void setName( String name )
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return String.format( "SectionToHire [id=%s, name=%s]",
                                    id, name );
    }

    private static final long serialVersionUID = -9013487637355283236L;
}
