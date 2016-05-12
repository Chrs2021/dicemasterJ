package slackchat.models.bot;

/**
 * Created by chrs2021 on 5/11/2016.
 */
public class Users
{
    private String id;

    private String presence;

    private String is_bot;

    private String name;

    private String deleted;

    private String team_id;

    private Profile profile;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getPresence ()
    {
        return presence;
    }

    public void setPresence (String presence)
    {
        this.presence = presence;
    }

    public String getIs_bot ()
    {
        return is_bot;
    }

    public void setIs_bot (String is_bot)
    {
        this.is_bot = is_bot;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDeleted ()
    {
        return deleted;
    }

    public void setDeleted (String deleted)
    {
        this.deleted = deleted;
    }

    public String getTeam_id ()
    {
        return team_id;
    }

    public void setTeam_id (String team_id)
    {
        this.team_id = team_id;
    }

    public Profile getProfile ()
    {
        return profile;
    }

    public void setProfile (Profile profile)
    {
        this.profile = profile;
    }

}
