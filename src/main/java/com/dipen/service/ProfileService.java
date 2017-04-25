package com.dipen.service;

import com.dipen.dao.DatabaseClass;
import com.dipen.model.Message;
import com.dipen.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dipen on 4/25/2017.
 */
public class ProfileService {

    private  Map<String,Profile> profiles = DatabaseClass.getAllProfiles();

    public ProfileService()
    {
        profiles.put("dipen",new Profile(1,"dipen","Hello Dipen","Dilip"));
        profiles.put("hari",new Profile(2,"hari","Hello hari","ram"));

    }
    public List<Profile> getAllMessages()
    {
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getMessage(String profileName)
    {
        return profiles.get(profileName);
    }

    public Profile addMessage(Profile profile)
    {
        profile.setId(profiles.size()+1);
        profiles.put(profile.getProfileName(),profile);
        return profile;
    }

    public Profile updateMessage(Profile profile)
    {
        if(profile.getProfileName().isEmpty())
        {
            return null;
        }
        profiles.put(profile.getProfileName(),profile);
        return profile;
    }

    public Profile removeMessage(String profileName)
    {
        return profiles.remove(profileName);
    }
}
