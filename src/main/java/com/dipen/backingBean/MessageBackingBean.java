package com.dipen.backingBean;

import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by dipen on 4/25/2017.
 */
public class MessageBackingBean
{

    @QueryParam("year") int year;
    @QueryParam("start") int start;
    @QueryParam("size") int size;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
