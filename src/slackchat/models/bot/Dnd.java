package slackchat.models.bot;

/**
 * Created by chrs2021 on 5/11/2016.
 */
public class Dnd {

    private String snooze_enabled;

    private String next_dnd_end_ts;

    private String next_dnd_start_ts;

    private String dnd_enabled;

    public String getSnooze_enabled ()
    {
        return snooze_enabled;
    }

    public void setSnooze_enabled (String snooze_enabled)
    {
        this.snooze_enabled = snooze_enabled;
    }

    public String getNext_dnd_end_ts ()
    {
        return next_dnd_end_ts;
    }

    public void setNext_dnd_end_ts (String next_dnd_end_ts)
    {
        this.next_dnd_end_ts = next_dnd_end_ts;
    }

    public String getNext_dnd_start_ts ()
    {
        return next_dnd_start_ts;
    }

    public void setNext_dnd_start_ts (String next_dnd_start_ts)
    {
        this.next_dnd_start_ts = next_dnd_start_ts;
    }

    public String getDnd_enabled ()
    {
        return dnd_enabled;
    }

    public void setDnd_enabled (String dnd_enabled)
    {
        this.dnd_enabled = dnd_enabled;
    }
}
