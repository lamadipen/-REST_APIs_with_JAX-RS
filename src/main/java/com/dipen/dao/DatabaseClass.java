package com.dipen.dao;

import com.dipen.model.Message;
import com.dipen.model.Profile;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by dipen on 4/25/2017.
 */
public class DatabaseClass {

    private static Map<Long,Message> messages = new HashMap();
    private static Map<Long,Profile> profiles = new HashMap();

    public static Map<Long,Message> getAllMessages()
    {
        return messages;
    }

    public static Map<Long,Profile> getAllProfiles()
    {
        return profiles;
    }
}
