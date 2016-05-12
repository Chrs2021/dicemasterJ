package slackchat.models.bot;

/**
 * Created by chrs2021 on 5/11/2016.
 */
public class Channels {
    private String has_pins;

    private String id;

    private String is_general;

    private String created;

    private String is_member;

    private String name;

    private String is_archived;

    private String is_channel;

    private String creator;

    public String getHas_pins ()
    {
        return has_pins;
    }

    public void setHas_pins (String has_pins)
    {
        this.has_pins = has_pins;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getIs_general ()
    {
        return is_general;
    }

    public void setIs_general (String is_general)
    {
        this.is_general = is_general;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public String getIs_member ()
    {
        return is_member;
    }

    public void setIs_member (String is_member)
    {
        this.is_member = is_member;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getIs_archived ()
    {
        return is_archived;
    }

    public void setIs_archived (String is_archived)
    {
        this.is_archived = is_archived;
    }

    public String getIs_channel ()
    {
        return is_channel;
    }

    public void setIs_channel (String is_channel)
    {
        this.is_channel = is_channel;
    }

    public String getCreator ()
    {
        return creator;
    }

    public void setCreator (String creator)
    {
        this.creator = creator;
    }
}
