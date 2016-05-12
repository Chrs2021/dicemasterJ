package slackchat.models.bot;

/**
 * Created by chrs2021 on 5/11/2016.
 */
public class Team {

    private String id;

    private Icon icon;

    private Prefs prefs;

    private String plan;

    private String over_storage_limit;

    private String name;

    private String over_integrations_limit;

    private String domain;

    private String msg_edit_window_mins;

    private String email_domain;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Icon getIcon ()
    {
        return icon;
    }

    public void setIcon (Icon icon)
    {
        this.icon = icon;
    }

    public Prefs getPrefs ()
    {
        return prefs;
    }

    public void setPrefs (Prefs prefs)
    {
        this.prefs = prefs;
    }

    public String getPlan ()
    {
        return plan;
    }

    public void setPlan (String plan)
    {
        this.plan = plan;
    }

    public String getOver_storage_limit ()
    {
        return over_storage_limit;
    }

    public void setOver_storage_limit (String over_storage_limit)
    {
        this.over_storage_limit = over_storage_limit;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getOver_integrations_limit ()
    {
        return over_integrations_limit;
    }

    public void setOver_integrations_limit (String over_integrations_limit)
    {
        this.over_integrations_limit = over_integrations_limit;
    }

    public String getDomain ()
    {
        return domain;
    }

    public void setDomain (String domain)
    {
        this.domain = domain;
    }

    public String getMsg_edit_window_mins ()
    {
        return msg_edit_window_mins;
    }

    public void setMsg_edit_window_mins (String msg_edit_window_mins)
    {
        this.msg_edit_window_mins = msg_edit_window_mins;
    }

    public String getEmail_domain ()
    {
        return email_domain;
    }

    public void setEmail_domain (String email_domain)
    {
        this.email_domain = email_domain;
    }
}
