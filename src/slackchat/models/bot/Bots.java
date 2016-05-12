package slackchat.models.bot;

/**
 * Created by chrs2021 on 5/11/2016.
 */
public class Bots
{
    private String id;

    private String name;

    private String deleted;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
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

}