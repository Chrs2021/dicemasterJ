package slackchat.impl.utils;

import slackchat.models.bot.Users;

/**
 * Created by chrs2021 on 5/12/2016.
 */
public class userUtils {

    public static String getNameFromID(String id, Users[] userArray)
    {
        String name = null;
        for(Users user : userArray)
        {
            if(id.equals(user.getId()))
            {
                name = user.getName();
                continue;
            }
        }
        return name;
    }

    public static Users getUserFromId(String id,Users[] userArray)
    {
        Users foundUser = null;
        for(Users user : userArray)
        {
            if(id.equals(user.getId()))
            {
                foundUser = user;
                continue;
            }
        }
        return foundUser;
    }

}
