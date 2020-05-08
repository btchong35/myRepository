package com.moon.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Product implements Serializable {
    @Id
    private Integer pid;

    private String productname;

    private String imgsrc;

    private String description;

    private Integer categoryid;

    private Double startprice;

    private Double stepprice;

    private Double transactionprice;

    private Date transactiondate;

    private Integer ownerid;

    private String ownername;

    private Integer buyerid;

    private String buyername;

    private Date createdate;

    private Date updatedate;

    /**
     * 0-未上架，1-已上架，2-已卖出
     */
    private Integer status;

    private Date enddate;

    private static final long serialVersionUID = 1L;

    /**
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * @return productname
     */
    public String getProductname() {
        return productname;
    }

    /**
     * @param productname
     */
    public void setProductname(String productname) {
        this.productname = productname;
    }

    /**
     * @return imgsrc
     */
    public String getImgsrc() {
        return imgsrc;
    }

    /**
     * @param imgsrc
     */
    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
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
     * @return categoryid
     */
    public Integer getCategoryid() {
        return categoryid;
    }

    /**
     * @param categoryid
     */
    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    /**
     * @return startprice
     */
    public Double getStartprice() {
        return startprice;
    }

    /**
     * @param startprice
     */
    public void setStartprice(Double startprice) {
        this.startprice = startprice;
    }

    /**
     * @return stepprice
     */
    public Double getStepprice() {
        return stepprice;
    }

    /**
     * @param stepprice
     */
    public void setStepprice(Double stepprice) {
        this.stepprice = stepprice;
    }

    /**
     * @return transactionprice
     */
    public Double getTransactionprice() {
        return transactionprice;
    }

    /**
     * @param transactionprice
     */
    public void setTransactionprice(Double transactionprice) {
        this.transactionprice = transactionprice;
    }

    /**
     * @return transactiondate
     */
    public Date getTransactiondate() {
        return transactiondate;
    }

    /**
     * @param transactiondate
     */
    public void setTransactiondate(Date transactiondate) {
        this.transactiondate = transactiondate;
    }

    /**
     * @return ownerid
     */
    public Integer getOwnerid() {
        return ownerid;
    }

    /**
     * @param ownerid
     */
    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }

    /**
     * @return ownername
     */
    public String getOwnername() {
        return ownername;
    }

    /**
     * @param ownername
     */
    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    /**
     * @return buyerid
     */
    public Integer getBuyerid() {
        return buyerid;
    }

    /**
     * @param buyerid
     */
    public void setBuyerid(Integer buyerid) {
        this.buyerid = buyerid;
    }

    /**
     * @return buyername
     */
    public String getBuyername() {
        return buyername;
    }

    /**
     * @param buyername
     */
    public void setBuyername(String buyername) {
        this.buyername = buyername;
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
     * @return updatedate
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * @param updatedate
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取0-未上架，1-已上架，2-已卖出
     *
     * @return status - 0-未上架，1-已上架，2-已卖出
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0-未上架，1-已上架，2-已卖出
     *
     * @param status 0-未上架，1-已上架，2-已卖出
     */
    public void setStatus(Integer status) {
        this.status = status;
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
}