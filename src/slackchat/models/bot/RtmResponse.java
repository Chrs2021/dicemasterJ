package slackchat.models.bot;

/**
 * Created by chrs2021 on 5/11/2016.
 */
public class RtmResponse {
    private String cache_ts;

    private Users[] users;

    private Ims[] ims;

    private Bots[] bots;

    private Channels[] channels;

    private Self self;

    private Team team;

    private String latest_event_ts;

    private String url;

    private Dnd dnd;

    private String ok;

    private Subteams subteams;

    private String cache_version;

    private String cache_ts_version;

    private String[] groups;

    public String getCache_ts ()
    {
        return cache_ts;
    }

    public void setCache_ts (String cache_ts)
    {
        this.cache_ts = cache_ts;
    }

    public Users[] getUsers ()
    {
        return users;
    }

    public void setUsers (Users[] users)
    {
        this.users = users;
    }

    public Ims[] getIms ()
    {
        return ims;
    }

    public void setIms (Ims[] ims)
    {
        this.ims = ims;
    }

    public Bots[] getBots ()
    {
        return bots;
    }

    public void setBots (Bots[] bots)
    {
        this.bots = bots;
    }

    public Channels[] getChannels ()
    {
        return channels;
    }

    public void setChannels (Channels[] channels)
    {
        this.channels = channels;
    }

    public Self getSelf ()
    {
        return self;
    }

    public void setSelf (Self self)
    {
        this.self = self;
    }

    public Team getTeam ()
    {
        return team;
    }

    public void setTeam (Team team)
    {
        this.team = team;
    }

    public String getLatest_event_ts ()
    {
        return latest_event_ts;
    }

    public void setLatest_event_ts (String latest_event_ts)
    {
        this.latest_event_ts = latest_event_ts;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public Dnd getDnd ()
    {
        return dnd;
    }

    public void setDnd (Dnd dnd)
    {
        this.dnd = dnd;
    }

    public String getOk ()
    {
        return ok;
    }

    public void setOk (String ok)
    {
        this.ok = ok;
    }

    public Subteams getSubteams ()
    {
        return subteams;
    }

    public void setSubteams (Subteams subteams)
    {
        this.subteams = subteams;
    }

    public String getCache_version ()
    {
        return cache_version;
    }

    public void setCache_version (String cache_version)
    {
        this.cache_version = cache_version;
    }

    public String getCache_ts_version ()
    {
        return cache_ts_version;
    }

    public void setCache_ts_version (String cache_ts_version)
    {
        this.cache_ts_version = cache_ts_version;
    }

    public String[] getGroups ()
    {
        return groups;
    }

    public void setGroups (String[] groups)
    {
        this.groups = groups;
    }
}
