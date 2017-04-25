package com.dipen.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by dipen on 4/25/2017.
 */
@XmlRootElement
public class Profile
{
    private long id;
    private String profileName;
    private String firstName;
    private String lastName;
    private Date created;

    public Profile()
    {

    }

    public Profile(long id, String profileName, String fistName, String lastName) {
        this.id = id;
        this.profileName = profileName;
        this.firstName = fistName;
        this.lastName = lastName;
        this.created = new Date();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fistName) {
        this.firstName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }





}
