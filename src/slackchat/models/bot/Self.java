package slackchat.models.bot;

/**
 * Created by chrs2021 on 5/11/2016.
 */
public class Self {
    private String id;

    private Prefs prefs;

    private String manual_presence;

    private String created;

    private String name;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Prefs getPrefs ()
    {
        return prefs;
    }

    public void setPrefs (Prefs prefs)
    {
        this.prefs = prefs;
    }

    public String getManual_presence ()
    {
        return manual_presence;
    }

    public void setManual_presence (String manual_presence)
    {
        this.manual_presence = manual_presence;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }
}
