package com.moon.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Auctionroom implements Serializable {
    @Id
    private Integer rid;

    private String roomname;

    private String description;

    private Date startdate;

    private Date enddate;

    private Date createdate;

    private Integer status;

    private static final long serialVersionUID = 1L;

    /**
     * @return rid
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * @param rid
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * @return roomname
     */
    public String getRoomname() {
        return roomname;
    }

    /**
     * @param roomname
     */
    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return startdate
     */
    public Date getStartdate() {
        return startdate;
    }

    /**
     * @param startdate
     */
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    /**
     * @return enddate
     */
    public Date getEnddate() {
        return enddate;
    }

    /**
     * @param enddate
     */
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    /**
     * @return createdate
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * @param createdate
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}