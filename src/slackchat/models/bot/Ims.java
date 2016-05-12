package slackchat.models.bot;

/**
 * Created by chrs2021 on 5/11/2016.
 */
public class Ims {
    private String has_pins;

    private String is_org_shared;

    private String id;

    private String unread_count_display;

    private String last_read;

    private String created;

    private String is_open;

    private String is_im;

    private String unread_count;

    private String user;

    public String getHas_pins ()
    {
        return has_pins;
    }

    public void setHas_pins (String has_pins)
    {
        this.has_pins = has_pins;
    }

    public String getIs_org_shared ()
    {
        return is_org_shared;
    }

    public void setIs_org_shared (String is_org_shared)
    {
        this.is_org_shared = is_org_shared;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getUnread_count_display ()
    {
        return unread_count_display;
    }

    public void setUnread_count_display (String unread_count_display)
    {
        this.unread_count_display = unread_count_display;
    }

    public String getLast_read ()
    {
        return last_read;
    }

    public void setLast_read (String last_read)
    {
        this.last_read = last_read;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public String getIs_open ()
    {
        return is_open;
    }

    public void setIs_open (String is_open)
    {
        this.is_open = is_open;
    }

    public String getIs_im ()
    {
        return is_im;
    }

    public void setIs_im (String is_im)
    {
        this.is_im = is_im;
    }


    public String getUnread_count ()
    {
        return unread_count;
    }

    public void setUnread_count (String unread_count)
    {
        this.unread_count = unread_count;
    }

    public String getUser ()
    {
        return user;
    }

    public void setUser (String user)
    {
        this.user = user;
    }
}
