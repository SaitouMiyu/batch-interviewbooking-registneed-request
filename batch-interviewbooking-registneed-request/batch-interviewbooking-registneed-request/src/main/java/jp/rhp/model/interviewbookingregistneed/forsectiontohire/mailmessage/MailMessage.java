package jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage;

import jp.rhp.model.interviewbookingregistneed.forsectiontohire.mailmessage.mailtemplate.MailTemplate;
import jp.rhp.model.primitive.Identifiable;

import java.util.HashMap;
import java.util.Map;

public class MailMessage implements Identifiable
{
    enum KeyType
    {
        SHOPNAME( 0, "KEY_SHOPNAME" );

        private int index;
        private String keyName;

        private KeyType( int index, String keyName )
        {
            this.index = index;
            this.keyName = keyName;
        }

        int index()
        {
            return this.index;
        }

        String keyName()
        {
            return this.keyName;
        }
    }

    private Integer id;
    private String to;
    private MailTemplate mailTemplate;

    public MailMessage( Integer id, String to, String shopName, MailTemplate mailTemplate )
    {
        this.id = id;
        this.to = to;
        this.mailTemplate = mailTemplate;

        this.implant( shopName );
    }

    private void implant( String... changes )
    {
        Map map = new HashMap<String, String>();
        map.put( KeyType.SHOPNAME.keyName, changes[ KeyType.SHOPNAME.index() ] );
        this.mailTemplate.implantForMessage( map );
    }

    @Deprecated
    public Integer getId()
    {
        return id;
    }

    @Deprecated
    public String getTo()
    {
        return to;
    }

    @Deprecated
    public MailTemplate getMailTemplate()
    {
        return mailTemplate;
    }
}
