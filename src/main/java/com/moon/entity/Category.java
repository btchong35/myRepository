package com.moon.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Category implements Serializable {
    @Id
    private Integer cid;

    private String categoryname;

    private Integer deep;

    private String categorysrc;

    private Integer parentid;

    private Date createdate;

    private Integer status;

    private static final long serialVersionUID = 1L;

    /**
     * @return cid
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * @param cid
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * @return categoryname
     */
    public String getCategoryname() {
        return categoryname;
    }

    /**
     * @param categoryname
     */
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    /**
     * @return deep
     */
    public Integer getDeep() {
        return deep;
    }

    /**
     * @param deep
     */
    public void setDeep(Integer deep) {
        this.deep = deep;
    }

    /**
     * @return categorysrc
     */
    public String getCategorysrc() {
        return categorysrc;
    }

    /**
     * @param categorysrc
     */
    public void setCategorysrc(String categorysrc) {
        this.categorysrc = categorysrc;
    }

    /**
     * @return parentid
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * @param parentid
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
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